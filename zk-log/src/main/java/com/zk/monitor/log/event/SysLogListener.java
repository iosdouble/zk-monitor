package com.zk.monitor.log.event;

import com.zk.monitor.log.domain.SysLog;
import com.zk.monitor.log.service.ISysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * com.zk.monitor.log.event
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Slf4j
@Component
public class SysLogListener {
    @Autowired
    private ISysLogService sysLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        // 保存日志
        sysLogService.save(sysLog);
    }
}
