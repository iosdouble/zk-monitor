package com.zk.monitor.modules.security.code.sms;

import java.util.Map;

public interface SmsCodeService {

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    Map<String, Object> sendCode(String phone);
}
