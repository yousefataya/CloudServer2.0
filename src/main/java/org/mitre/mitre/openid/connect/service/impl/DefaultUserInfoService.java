
package org.mitre.mitre.openid.connect.service.impl;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.ClientDetailsEntity.SubjectType;
import org.mitre.oauth2.service.ClientDetailsEntityService;
import org.mitre.openid.connect.model.UserInfo;
import org.mitre.openid.connect.repository.UserInfoRepository;
import org.mitre.openid.connect.service.PairwiseIdentiferService;
import org.mitre.openid.connect.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserInfoService implements UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ClientDetailsEntityService clientService;

	@Autowired
	private PairwiseIdentiferService pairwiseIdentifierService;

	@Override
	public UserInfo getByUsername(String username) {
		return userInfoRepository.getByUsername(username);
	}

	@Override
	public UserInfo getByUsernameAndClientId(String username, String clientId) {

		ClientDetailsEntity client = clientService.loadClientByClientId(clientId);

		UserInfo userInfo = getByUsername(username);

		if (client == null || userInfo == null) {
			return null;
		}

		if (SubjectType.PAIRWISE.equals(client.getSubjectType())) {
			String pairwiseSub = pairwiseIdentifierService.getIdentifier(userInfo, client);
			userInfo.setSub(pairwiseSub);
		}

		return userInfo;

	}

	@Override
	public UserInfo getByEmailAddress(String email) {
		return userInfoRepository.getByEmailAddress(email);
	}

}
