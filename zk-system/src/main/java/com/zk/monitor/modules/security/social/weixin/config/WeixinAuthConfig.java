package com.zk.monitor.modules.security.social.weixin.config;


import com.zk.monitor.modules.security.properties.PreSecurityProperties;
import com.zk.monitor.modules.security.properties.WeiXinProperties;
import com.zk.monitor.modules.security.social.SocialAutoConfigurerAdapter;
import com.zk.monitor.modules.security.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;



@Configuration
@EnableSocial
@ConditionalOnProperty(prefix = "pre.security.social.weixin", name = "app-id")
public class WeixinAuthConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private PreSecurityProperties preSecurityProperties;


    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeiXinProperties weiXin = preSecurityProperties.getSocial().getWeiXin();
        String providerId = weiXin.getProviderId();
        String appId = weiXin.getAppId();
        String appSecret = weiXin.getAppSecret();
        return new WeixinConnectionFactory(providerId, appId, appSecret);
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }


}
