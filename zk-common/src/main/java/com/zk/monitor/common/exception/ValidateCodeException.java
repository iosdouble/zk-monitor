package com.zk.monitor.common.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * com.zk.monitor.common.exception
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 验证码异常
 **/
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 5022575393500654459L;

    public ValidateCodeException(String message) {
        super(message);
    }
}

