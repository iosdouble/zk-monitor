package com.zk.monitor.modules.security.social.github.connect;

import com.zk.monitor.modules.security.social.github.api.GitHub;
import com.zk.monitor.modules.security.social.github.api.GitHubImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;


public class GitHubServiceProvider extends AbstractOAuth2ServiceProvider<GitHub> {

	public GitHubServiceProvider(String clientId, String clientSecret) {
		super(new GithubOAuth2Template(clientId, clientSecret, "https://github.com/login/oauth/authorize", "https://github.com/login/oauth/access_token"));
	}

	@Override
	public GitHub getApi(String accessToken) {
		return new GitHubImpl(accessToken);
	}
}
