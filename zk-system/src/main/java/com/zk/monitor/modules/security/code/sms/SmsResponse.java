package com.zk.monitor.modules.security.code.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SmsResponse {

    private String smsPhone;
    private String smsTime;
    private String smsCode;


}