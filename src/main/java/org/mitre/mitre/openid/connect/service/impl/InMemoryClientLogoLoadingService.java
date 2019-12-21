

package org.mitre.mitre.openid.connect.service.impl;

import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.openid.connect.model.CachedImage;
import org.mitre.openid.connect.service.ClientLogoLoadingService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service("inMemoryClientLogoLoadingService")
public class InMemoryClientLogoLoadingService implements ClientLogoLoadingService {

	private LoadingCache<ClientDetailsEntity, CachedImage> cache;

	public InMemoryClientLogoLoadingService() {
		this(HttpClientBuilder.create().useSystemProperties().build());
	}

	/**
	 *
	 */
	public InMemoryClientLogoLoadingService(HttpClient httpClient) {

		cache = CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(14, TimeUnit.DAYS)
				.build(new ClientLogoFetcher(httpClient));

	}

	@Override
	public CachedImage getLogo(ClientDetailsEntity client) {
		try {
			if (client != null && !Strings.isNullOrEmpty(client.getLogoUri())) {
				return cache.get(client);
			} else {
				return null;
			}
		} catch (UncheckedExecutionException | ExecutionException e) {
			return null;
		}
	}

	/**
	 * @author jricher
	 *
	 */
	public class ClientLogoFetcher extends CacheLoader<ClientDetailsEntity, CachedImage> {
		private HttpClient httpClient;

		public ClientLogoFetcher() {
			this(HttpClientBuilder.create().useSystemProperties().build());
		}

		public ClientLogoFetcher(HttpClient httpClient) {
			this.httpClient = httpClient;
		}

		/* (non-Javadoc)
		 * @see com.google.common.cache.CacheLoader#load(java.lang.Object)
		 */
		@Override
		public CachedImage load(ClientDetailsEntity key) throws Exception {
			try {
				HttpResponse response = httpClient.execute(new HttpGet(key.getLogoUri()));

				HttpEntity entity = response.getEntity();

				CachedImage image = new CachedImage();

				image.setContentType(entity.getContentType().getValue());
				image.setLength(entity.getContentLength());
				image.setData(IOUtils.toByteArray(entity.getContent()));

				return image;
			} catch (IOException e) {
				throw new IllegalArgumentException("Unable to load client image.");
			}
		}

	}


}
