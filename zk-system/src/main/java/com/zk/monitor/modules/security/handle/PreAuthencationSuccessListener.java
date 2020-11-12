package com.zk.monitor.modules.security.handle;

import com.zk.monitor.security.PreSecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreAuthencationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        PreSecurityUser xytSecurityUser = (PreSecurityUser) event.getAuthentication().getPrincipal();;
        log.info("用户名:{},成功登录", xytSecurityUser.getUsername());
    }

}
