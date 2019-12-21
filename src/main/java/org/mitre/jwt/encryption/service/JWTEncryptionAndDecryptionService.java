
package org.mitre.jwt.encryption.service;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.jwk.JWK;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

public interface JWTEncryptionAndDecryptionService {

	/**
	 * Encrypts the JWT in place with the default encrypter.
	 * If an arbitrary payload is used, then pass in a JWEObject.
	 * Otherwise, if JWT claims are the payload, then use the JWEObject subclass EncryptedJWT instead.
	 * @param jwt
	 */
	public void encryptJwt(JWEObject jwt);

	/**
	 * Decrypts the JWT in place with the default decrypter.
	 *  If an arbitrary payload is used, then pass in a JWEObject.
	 *  Otherwise, if JWT claims are the payload, then use the JWEObject subclass EncryptedJWT instead.
	 * @param jwt
	 */
	public void decryptJwt(JWEObject jwt);

	/**
	 * Get all public keys for this service, mapped by their Key ID
	 */
	public Map<String, JWK> getAllPublicKeys();

	/**
	 * Get the list of all encryption algorithms supported by this service.
	 * @return
	 */
	public Collection<JWEAlgorithm> getAllEncryptionAlgsSupported();

	/**
	 * Get the list of all encryption methods supported by this service.
	 * @return
	 */
	public Collection<EncryptionMethod> getAllEncryptionEncsSupported();

	/**
	 * TODO add functionality for encrypting and decrypting using a specified key id.
	 * Example: public void encryptJwt(EncryptedJWT jwt, String kid);
	 */
}
