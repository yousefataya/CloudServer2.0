package org.mitre.mitre.openid.connect.repository.impl;

import org.mitre.openid.connect.model.DefaultUserInfo;
import org.mitre.openid.connect.model.UserInfo;
import org.mitre.openid.connect.repository.UserInfoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import static org.mitre.util.jpa.JpaUtil.getSingleResult;

@Repository("jpaUserInfoRepository")
public class JpaUserInfoRepository implements UserInfoRepository {

	@PersistenceContext(unitName="EXPERTS-MYSQL")
	private EntityManager manager;

	/**
	 * Get a single UserInfo object by its username
	 */
	@Override
	public UserInfo getByUsername(String username) {
		TypedQuery<DefaultUserInfo> query = manager.createNamedQuery(DefaultUserInfo.QUERY_BY_USERNAME, DefaultUserInfo.class);
		query.setParameter(DefaultUserInfo.PARAM_USERNAME, username);

		return getSingleResult(query.getResultList());

	}

	/**
	 * Get a single UserInfo object by its email address
	 */
	@Override
	public UserInfo getByEmailAddress(String email) {
		TypedQuery<DefaultUserInfo> query = manager.createNamedQuery(DefaultUserInfo.QUERY_BY_EMAIL, DefaultUserInfo.class);
		query.setParameter(DefaultUserInfo.PARAM_EMAIL, email);

		return getSingleResult(query.getResultList());
	}

}
