package com.zk.monitor.core.util;

import java.io.File;

/**
 * com.zk.monitor.core.util
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class JavaHome {
    public final String path = System.getenv("JAVA_HOME")+ File.separator +"bin"+File.separator;
}
