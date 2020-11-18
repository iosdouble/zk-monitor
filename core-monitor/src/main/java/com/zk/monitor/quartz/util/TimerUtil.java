package com.zk.monitor.quartz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.zk.monitor.quartz.util
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class TimerUtil {
    /**
     * 现在时间
     * @return
     */
    public static String time(){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");
        return format.format(new Date());
    }
}
