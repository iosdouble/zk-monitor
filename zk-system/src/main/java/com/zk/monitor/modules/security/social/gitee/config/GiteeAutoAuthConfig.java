package com.zk.monitor.modules.security.social.gitee.config;

import com.zk.monitor.modules.security.properties.GiteeProperties;
import com.zk.monitor.modules.security.properties.PreSecurityProperties;
import com.zk.monitor.modules.security.social.gitee.connect.GiteeConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;

@Configuration
@EnableSocial
@ConditionalOnProperty(prefix = "pre.security.social.gitee", name = "app-id")
public class GiteeAutoAuthConfig extends SocialConfigurerAdapter {

    @Autowired
    private PreSecurityProperties preSecurityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }
    public ConnectionFactory<?> createConnectionFactory() {
        GiteeProperties gitee = preSecurityProperties.getSocial().getGitee();
        return new GiteeConnectionFactory(gitee.getProviderId(), gitee.getAppId(), gitee.getAppSecret());
    }
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }

}