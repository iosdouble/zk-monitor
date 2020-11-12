package com.zk.monitor.modules.security.handle;

import cn.hutool.http.HttpStatus;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.security.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class PreAccessDeineHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        log.error("请求访问: " + request.getRequestURI() + " 接口， 没有访问权限");
        SecurityUtil.writeJavaScript(AjaxResult.error(HttpStatus.HTTP_UNAUTHORIZED, "请求访问:" + request.getRequestURI() + "接口,没有访问权限"), response);
    }
}
