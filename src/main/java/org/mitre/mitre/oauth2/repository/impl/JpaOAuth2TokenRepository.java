
package org.mitre.mitre.oauth2.repository.impl;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.mitre.data.DefaultPageCriteria;
import org.mitre.data.PageCriteria;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.OAuth2AccessTokenEntity;
import org.mitre.oauth2.model.OAuth2RefreshTokenEntity;
import org.mitre.oauth2.repository.OAuth2TokenRepository;
import org.mitre.openid.connect.model.ApprovedSite;
import org.mitre.uma.model.ResourceSet;
import org.mitre.util.jpa.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.*;

@Repository
public class JpaOAuth2TokenRepository implements OAuth2TokenRepository {

	private static final int MAXEXPIREDRESULTS = 1000;

	private static final Logger logger = LoggerFactory.getLogger(JpaOAuth2TokenRepository.class);

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	@Override
	public Set<OAuth2AccessTokenEntity> getAllAccessTokens() {
		TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_ALL, OAuth2AccessTokenEntity.class);
		return new LinkedHashSet<>(query.getResultList());
	}

	@Override
	public Set<OAuth2RefreshTokenEntity> getAllRefreshTokens() {
		TypedQuery<OAuth2RefreshTokenEntity> query = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_ALL, OAuth2RefreshTokenEntity.class);
		return new LinkedHashSet<>(query.getResultList());
	}


	@Override
	public OAuth2AccessTokenEntity getAccessTokenByValue(String accessTokenValue) {
		try {
			JWT jwt = JWTParser.parse(accessTokenValue);
			TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_TOKEN_VALUE, OAuth2AccessTokenEntity.class);
			query.setParameter(OAuth2AccessTokenEntity.PARAM_TOKEN_VALUE, jwt);
			return JpaUtil.getSingleResult(query.getResultList());
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public OAuth2AccessTokenEntity getAccessTokenById(Long id) {
		return manager.find(OAuth2AccessTokenEntity.class, id);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public OAuth2AccessTokenEntity saveAccessToken(OAuth2AccessTokenEntity token) {
		return JpaUtil.saveOrUpdate(token.getId(), manager, token);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void removeAccessToken(OAuth2AccessTokenEntity accessToken) {
		OAuth2AccessTokenEntity found = getAccessTokenById(accessToken.getId());
		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException("Access token not found: " + accessToken);
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void clearAccessTokensForRefreshToken(OAuth2RefreshTokenEntity refreshToken) {
		TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_REFRESH_TOKEN, OAuth2AccessTokenEntity.class);
		query.setParameter(OAuth2AccessTokenEntity.PARAM_REFERSH_TOKEN, refreshToken);
		List<OAuth2AccessTokenEntity> accessTokens = query.getResultList();
		for (OAuth2AccessTokenEntity accessToken : accessTokens) {
			removeAccessToken(accessToken);
		}
	}

	@Override
	public OAuth2RefreshTokenEntity getRefreshTokenByValue(String refreshTokenValue) {
		try {
			JWT jwt = JWTParser.parse(refreshTokenValue);
			TypedQuery<OAuth2RefreshTokenEntity> query = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_BY_TOKEN_VALUE, OAuth2RefreshTokenEntity.class);
			query.setParameter(OAuth2RefreshTokenEntity.PARAM_TOKEN_VALUE, jwt);
			return JpaUtil.getSingleResult(query.getResultList());
		} catch (ParseException e) {
			return null;
		}
	}

	@Override
	public OAuth2RefreshTokenEntity getRefreshTokenById(Long id) {
		return manager.find(OAuth2RefreshTokenEntity.class, id);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public OAuth2RefreshTokenEntity saveRefreshToken(OAuth2RefreshTokenEntity refreshToken) {
		return JpaUtil.saveOrUpdate(refreshToken.getId(), manager, refreshToken);
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void removeRefreshToken(OAuth2RefreshTokenEntity refreshToken) {
		OAuth2RefreshTokenEntity found = getRefreshTokenById(refreshToken.getId());
		if (found != null) {
			manager.remove(found);
		} else {
			throw new IllegalArgumentException("Refresh token not found: " + refreshToken);
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void clearTokensForClient(ClientDetailsEntity client) {
		TypedQuery<OAuth2AccessTokenEntity> queryA = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_CLIENT, OAuth2AccessTokenEntity.class);
		queryA.setParameter(OAuth2AccessTokenEntity.PARAM_CLIENT, client);
		List<OAuth2AccessTokenEntity> accessTokens = queryA.getResultList();
		for (OAuth2AccessTokenEntity accessToken : accessTokens) {
			removeAccessToken(accessToken);
		}
		TypedQuery<OAuth2RefreshTokenEntity> queryR = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_BY_CLIENT, OAuth2RefreshTokenEntity.class);
		queryR.setParameter(OAuth2RefreshTokenEntity.PARAM_CLIENT, client);
		List<OAuth2RefreshTokenEntity> refreshTokens = queryR.getResultList();
		for (OAuth2RefreshTokenEntity refreshToken : refreshTokens) {
			removeRefreshToken(refreshToken);
		}
	}

	@Override
	public List<OAuth2AccessTokenEntity> getAccessTokensForClient(ClientDetailsEntity client) {
		TypedQuery<OAuth2AccessTokenEntity> queryA = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_CLIENT, OAuth2AccessTokenEntity.class);
		queryA.setParameter(OAuth2AccessTokenEntity.PARAM_CLIENT, client);
		List<OAuth2AccessTokenEntity> accessTokens = queryA.getResultList();
		return accessTokens;
	}

	@Override
	public List<OAuth2RefreshTokenEntity> getRefreshTokensForClient(ClientDetailsEntity client) {
		TypedQuery<OAuth2RefreshTokenEntity> queryR = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_BY_CLIENT, OAuth2RefreshTokenEntity.class);
		queryR.setParameter(OAuth2RefreshTokenEntity.PARAM_CLIENT, client);
		List<OAuth2RefreshTokenEntity> refreshTokens = queryR.getResultList();
		return refreshTokens;
	}
	
	@Override
	public Set<OAuth2AccessTokenEntity> getAccessTokensByUserName(String name) {
		TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_NAME, OAuth2AccessTokenEntity.class);
	    query.setParameter(OAuth2AccessTokenEntity.PARAM_NAME, name);
	    List<OAuth2AccessTokenEntity> results = query.getResultList();
	    return results != null ? new HashSet<>(results) : new HashSet<>();
	}
	
	@Override
	public Set<OAuth2RefreshTokenEntity> getRefreshTokensByUserName(String name) {
		TypedQuery<OAuth2RefreshTokenEntity> query = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_BY_NAME, OAuth2RefreshTokenEntity.class);
	    query.setParameter(OAuth2RefreshTokenEntity.PARAM_NAME, name);
	    List<OAuth2RefreshTokenEntity> results = query.getResultList();
	    return results != null ? new HashSet<>(results) : new HashSet<>();
	}

	@Override
	public Set<OAuth2AccessTokenEntity> getAllExpiredAccessTokens() {
		DefaultPageCriteria pageCriteria = new DefaultPageCriteria(0, MAXEXPIREDRESULTS);
		return getAllExpiredAccessTokens(pageCriteria);
	}

	@Override
	public Set<OAuth2AccessTokenEntity> getAllExpiredAccessTokens(PageCriteria pageCriteria) {
		TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_EXPIRED_BY_DATE, OAuth2AccessTokenEntity.class);
		query.setParameter(OAuth2AccessTokenEntity.PARAM_DATE, new Date());
		return new LinkedHashSet<>(JpaUtil.getResultPage(query, pageCriteria));
	}

	@Override
	public Set<OAuth2RefreshTokenEntity> getAllExpiredRefreshTokens() {
		DefaultPageCriteria pageCriteria = new DefaultPageCriteria(0, MAXEXPIREDRESULTS);
		return getAllExpiredRefreshTokens(pageCriteria);
	}

	@Override
	public Set<OAuth2RefreshTokenEntity> getAllExpiredRefreshTokens(PageCriteria pageCriteria) {
		TypedQuery<OAuth2RefreshTokenEntity> query = manager.createNamedQuery(OAuth2RefreshTokenEntity.QUERY_EXPIRED_BY_DATE, OAuth2RefreshTokenEntity.class);
		query.setParameter(OAuth2AccessTokenEntity.PARAM_DATE, new Date());
		return new LinkedHashSet<>(JpaUtil.getResultPage(query,pageCriteria));
	}

	@Override
	public Set<OAuth2AccessTokenEntity> getAccessTokensForResourceSet(ResourceSet rs) {
		TypedQuery<OAuth2AccessTokenEntity> query = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_RESOURCE_SET, OAuth2AccessTokenEntity.class);
		query.setParameter(OAuth2AccessTokenEntity.PARAM_RESOURCE_SET_ID, rs.getId());
		return new LinkedHashSet<>(query.getResultList());
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void clearDuplicateAccessTokens() {
		Query query = manager.createQuery("select a.jwt, count(1) as c from OAuth2AccessTokenEntity a GROUP BY a.jwt HAVING count(1) > 1");
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = query.getResultList();
		List<JWT> values = new ArrayList<>();
		for (Object[] r : resultList) {
			logger.warn("Found duplicate access tokens: {}, {}", ((JWT)r[0]).serialize(), r[1]);
			values.add((JWT) r[0]);
		}
		if (values.size() > 0) {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaDelete<OAuth2AccessTokenEntity> criteriaDelete = cb.createCriteriaDelete(OAuth2AccessTokenEntity.class);
			Root<OAuth2AccessTokenEntity> root = criteriaDelete.from(OAuth2AccessTokenEntity.class);
			criteriaDelete.where(root.get("jwt").in(values));
			int result = manager.createQuery(criteriaDelete).executeUpdate();
			logger.warn("Deleted {} duplicate access tokens", result);
		}
	}

	@Override
	@Transactional(value="defaultTransactionManager")
	public void clearDuplicateRefreshTokens() {
		Query query = manager.createQuery("select a.jwt, count(1) as c from OAuth2RefreshTokenEntity a GROUP BY a.jwt HAVING count(1) > 1");
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = query.getResultList();
		List<JWT> values = new ArrayList<>();
		for (Object[] r : resultList) {
			logger.warn("Found duplicate refresh tokens: {}, {}", ((JWT)r[0]).serialize(), r[1]);
			values.add((JWT) r[0]);
		}
		if (values.size() > 0) {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaDelete<OAuth2RefreshTokenEntity> criteriaDelete = cb.createCriteriaDelete(OAuth2RefreshTokenEntity.class);
			Root<OAuth2RefreshTokenEntity> root = criteriaDelete.from(OAuth2RefreshTokenEntity.class);
			criteriaDelete.where(root.get("jwt").in(values));
			int result = manager.createQuery(criteriaDelete).executeUpdate();
			logger.warn("Deleted {} duplicate refresh tokens", result);
		}

	}

	@Override
	public List<OAuth2AccessTokenEntity> getAccessTokensForApprovedSite(ApprovedSite approvedSite) {
		TypedQuery<OAuth2AccessTokenEntity> queryA = manager.createNamedQuery(OAuth2AccessTokenEntity.QUERY_BY_APPROVED_SITE, OAuth2AccessTokenEntity.class);
		queryA.setParameter(OAuth2AccessTokenEntity.PARAM_APPROVED_SITE, approvedSite);
		List<OAuth2AccessTokenEntity> accessTokens = queryA.getResultList();
		return accessTokens;
	}

}
