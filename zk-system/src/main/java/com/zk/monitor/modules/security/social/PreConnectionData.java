package com.zk.monitor.modules.security.social;

import lombok.Data;

import java.io.Serializable;

/**
 * com.zk.monitor.modules.security.social
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 第三方数据类
 **/
@Data
public class PreConnectionData implements Serializable {
    private String providerId;
    private String providerUserId;
    private String displayName;
    private String profileUrl;
    private String imageUrl;
    private String accessToken;
    private String secret;
    private String refreshToken;
    private Long expireTime;
}

