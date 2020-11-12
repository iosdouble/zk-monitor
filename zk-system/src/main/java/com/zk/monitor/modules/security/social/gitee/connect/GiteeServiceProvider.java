package com.zk.monitor.modules.security.social.gitee.connect;

import com.zk.monitor.modules.security.social.gitee.api.Gitee;
import com.zk.monitor.modules.security.social.gitee.api.GiteeImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class GiteeServiceProvider extends AbstractOAuth2ServiceProvider<Gitee> {

	public GiteeServiceProvider(String clientId, String clientSecret) {

		super(new GiteeOAuth2Template(clientId, clientSecret, "https://gitee.com/oauth/authorize", "https://gitee.com/oauth/token"));
	}

	@Override
	public Gitee getApi(String accessToken) {
		return new GiteeImpl(accessToken);
	}
}