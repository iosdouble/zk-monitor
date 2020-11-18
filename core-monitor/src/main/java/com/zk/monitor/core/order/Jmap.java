package com.zk.monitor.core.order;

import com.zk.monitor.core.cmd.ExecuteCmd;
import com.zk.monitor.core.util.PathUtil;

import java.io.File;

/**
 * com.zk.monitor.core.order
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 * TODO Dump信息
 **/
public class Jmap {
    /**
     * 导出堆快照
     * @param id
     * @return
     */
    public static String dump(String id){
        String path = PathUtil.getRootPath("dump/"+id+"_heap.txt");
        File file = new File(PathUtil.getRootPath("dump/"));
        if (!file.exists()){
            file.mkdirs();
        }
        ExecuteCmd.execute(new String[]{"jmap","-dump:format=b,file="+path, id});
        return path;
    }

}
