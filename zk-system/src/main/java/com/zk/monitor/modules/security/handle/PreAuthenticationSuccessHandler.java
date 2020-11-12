package com.zk.monitor.modules.security.handle;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.modules.security.PreSocialUser;
import com.zk.monitor.modules.security.util.JwtUtil;
import com.zk.monitor.security.LoginType;
import com.zk.monitor.security.PreSecurityUser;
import com.zk.monitor.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PreAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${pre.url.address}")
    private String url;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Object principal = authentication.getPrincipal();
        if (principal instanceof PreSecurityUser) {
            PreSecurityUser userDetail = (PreSecurityUser) authentication.getPrincipal();
            //存储认证信息
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //生成token
            String s = JwtUtil.generateToken(userDetail);
            // 是短信登录返回token
            if (LoginType.sms.equals(userDetail.getLoginType())) {
                SecurityUtil.writeJavaScript(AjaxResult.ok(s), response);
            }
        } else if (principal instanceof PreSocialUser) {
            PreSocialUser userDetail = (PreSocialUser) authentication.getPrincipal();
            PreSecurityUser preSecurityUser = new PreSecurityUser(Integer.parseInt(userDetail.getUserId()), userDetail.getUsername(), userDetail.getPassword(), userDetail.getAuthorities(), null);
            //存储认证信息
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //生成token
            String token = JwtUtil.generateToken(preSecurityUser);
            response.sendRedirect(url + "/login?token=" + token);
        }

    }
}
