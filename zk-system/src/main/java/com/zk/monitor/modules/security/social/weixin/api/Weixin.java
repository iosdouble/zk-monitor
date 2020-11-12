package com.zk.monitor.modules.security.social.weixin.api;



public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);
}
