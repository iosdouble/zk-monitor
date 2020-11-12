package com.zk.monitor.log.event;

import com.zk.monitor.log.domain.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * com.zk.monitor.log.event
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(SysLog sysLog) {
        super(sysLog);
    }
}
