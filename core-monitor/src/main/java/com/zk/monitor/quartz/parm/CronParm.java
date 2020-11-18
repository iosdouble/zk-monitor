package com.zk.monitor.quartz.parm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * com.zk.monitor.quartz.parm
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@Component
@ConfigurationProperties(prefix="monitor")
public class CronParm {
    private String cron;
    private Integer rate;

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
