package com.zk.monitor.modules.security.handle;

import cn.hutool.http.HttpStatus;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.security.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Slf4j
public class PreAuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        log.error("请求访问: " + request.getRequestURI() + " 接口， 经jwt认证失败，无法访问系统资源.");
        SecurityUtil.writeJavaScript(AjaxResult.error(HttpStatus.HTTP_UNAUTHORIZED,"请求访问:" + request.getRequestURI() + "接口,经jwt 认证失败,无法访问系统资源"),response);
    }
}