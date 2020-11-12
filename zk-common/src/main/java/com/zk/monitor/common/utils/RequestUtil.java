package com.zk.monitor.common.utils;

import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * com.zk.monitor.common.utils
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@UtilityClass
public class RequestUtil {
    /**
     * 通过容器提供的方法获取request,也可以选择在controller方法形参上直接声明
     * 这样获取会让service方法的参数更加优雅
     *
     * @return
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }
}
