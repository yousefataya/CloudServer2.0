

package org.mitre.jwt.signer.service.impl;

import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import org.mitre.jose.keystore.JWKSetKeyStore;
import org.mitre.jwt.encryption.service.JWTEncryptionAndDecryptionService;
import org.mitre.jwt.encryption.service.impl.DefaultJWTEncryptionAndDecryptionService;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class ClientKeyCacheService {

	private static Logger logger = LoggerFactory.getLogger(ClientKeyCacheService.class);

	@Autowired
	private JWKSetCacheService jwksUriCache = new JWKSetCacheService();

	@Autowired
	private SymmetricKeyJWTValidatorCacheService symmetricCache = new SymmetricKeyJWTValidatorCacheService();

	// cache of validators for by-value JWKs
	private LoadingCache<JWKSet, JWTSigningAndValidationService> jwksValidators;

	// cache of encryptors for by-value JWKs
	private LoadingCache<JWKSet, JWTEncryptionAndDecryptionService> jwksEncrypters;

	public ClientKeyCacheService() {
		this.jwksValidators = CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.HOURS) // expires 1 hour after fetch
				.maximumSize(100)
				.build(new JWKSetVerifierBuilder());
		this.jwksEncrypters = CacheBuilder.newBuilder()
				.expireAfterWrite(1, TimeUnit.HOURS) // expires 1 hour after fetch
				.maximumSize(100)
				.build(new JWKSetEncryptorBuilder());
	}


	public JWTSigningAndValidationService getValidator(ClientDetailsEntity client, JWSAlgorithm alg) {

		try {
			if (alg.equals(JWSAlgorithm.RS256)
					|| alg.equals(JWSAlgorithm.RS384)
					|| alg.equals(JWSAlgorithm.RS512)
					|| alg.equals(JWSAlgorithm.ES256)
					|| alg.equals(JWSAlgorithm.ES384)
					|| alg.equals(JWSAlgorithm.ES512)
					|| alg.equals(JWSAlgorithm.PS256)
					|| alg.equals(JWSAlgorithm.PS384)
					|| alg.equals(JWSAlgorithm.PS512)) {

				// asymmetric key
				if (client.getJwks() != null) {
					return jwksValidators.get(client.getJwks());
				} else if (!Strings.isNullOrEmpty(client.getJwksUri())) {
					return jwksUriCache.getValidator(client.getJwksUri());
				} else {
					return null;
				}

			} else if (alg.equals(JWSAlgorithm.HS256)
					|| alg.equals(JWSAlgorithm.HS384)
					|| alg.equals(JWSAlgorithm.HS512)) {

				// symmetric key

				return symmetricCache.getSymmetricValidtor(client);

			} else {

				return null;
			}
		} catch (UncheckedExecutionException | ExecutionException e) {
			logger.error("Problem loading client validator", e);
			return null;
		}

	}

	public JWTEncryptionAndDecryptionService getEncrypter(ClientDetailsEntity client) {

		try {
			if (client.getJwks() != null) {
				return jwksEncrypters.get(client.getJwks());
			} else if (!Strings.isNullOrEmpty(client.getJwksUri())) {
				return jwksUriCache.getEncrypter(client.getJwksUri());
			} else {
				return null;
			}
		} catch (UncheckedExecutionException | ExecutionException e) {
			logger.error("Problem loading client encrypter", e);
			return null;
		}

	}


	private class JWKSetEncryptorBuilder extends CacheLoader<JWKSet, JWTEncryptionAndDecryptionService> {

		@Override
		public JWTEncryptionAndDecryptionService load(JWKSet key) throws Exception {
			return new DefaultJWTEncryptionAndDecryptionService(new JWKSetKeyStore(key));
		}

	}

	private class JWKSetVerifierBuilder extends CacheLoader<JWKSet, JWTSigningAndValidationService> {

		@Override
		public JWTSigningAndValidationService load(JWKSet key) throws Exception {
			return new DefaultJWTSigningAndValidationService(new JWKSetKeyStore(key));
		}

	}


}
