package com.zk.monitor.modules.security.social;

import lombok.Data;

@Data
public class SocialUserInfo {

    private String providerId;
    private String providerUserId;
    private String nickname;
    private String headImg;
}
