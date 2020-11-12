package com.zk.monitor.modules.security.social.github.connect;


import com.zk.monitor.modules.security.social.github.api.GitHub;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class GitHubConnectionFactory extends OAuth2ConnectionFactory<GitHub> {

	public GitHubConnectionFactory(String providerId, String clientId, String clientSecret) {
		super(providerId, new GitHubServiceProvider(clientId, clientSecret), new GitHubAdapter());
	}
}