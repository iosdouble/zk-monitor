package com.zk.monitor.security.util;

import com.alibaba.fastjson.JSON;
import com.zk.monitor.common.exception.PreBaseException;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.security.PreSecurityUser;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * com.zk.monitor.security.util
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 安全服务工具类
 **/
@UtilityClass
public class SecurityUtil {

    public void writeJavaScript(AjaxResult r, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSON.toJSONString(r));
        printWriter.flush();
    }

    /**
     * 获取Authentication
     */
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


    public PreSecurityUser getUser(){
        try {
            return (PreSecurityUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new PreBaseException("登录状态过期", HttpStatus.UNAUTHORIZED.value());
        }
    }
}
