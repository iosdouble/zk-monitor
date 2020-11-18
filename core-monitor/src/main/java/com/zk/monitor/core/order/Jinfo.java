package com.zk.monitor.core.order;

import com.zk.monitor.core.cmd.ExecuteCmd;
import com.zk.monitor.core.entity.JinfoEntity;
import com.zk.monitor.core.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * com.zk.monitor.core.order
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 * TODO 执行命令获取 JVM默认参数
 **/
public class Jinfo {

    /**
     * JVM默认参数与指定参数
     * @param id
     * @return
     */
    public static JinfoEntity info(String id){
        String s = ExecuteCmd.execute(new String[]{"jinfo","-flags", id});
        if (!s.contains("successfully")){
            return null;
        }
        String flags = "flags:";
        String command = "Command line:";
        //默认参数
        String[] noedefault = ArrayUtil.trim(s.substring(s.indexOf(flags)+flags.length(),s.indexOf(command)).split("\\s+"));
        String[] commandLine = null;
        s = s.substring(s.indexOf(command));
        if (!s.equals(command)){
            commandLine = s.substring(command.length()).split("\\s+");
        }
        commandLine = ArrayUtil.trim(commandLine);
        return new JinfoEntity(Arrays.stream(noedefault).collect(Collectors.toList()), Arrays.stream(commandLine).collect(Collectors.toList()) );
    }
}
