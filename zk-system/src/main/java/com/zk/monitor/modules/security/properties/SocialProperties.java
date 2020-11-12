package com.zk.monitor.modules.security.properties;

/**
 * com.zk.monitor.modules.security.properties
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
public abstract class SocialProperties {
    private String appId;
    private String appSecret;

    public SocialProperties() {
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
