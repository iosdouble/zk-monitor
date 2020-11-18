package com.zk.monitor.core.order;

import com.zk.monitor.core.cmd.ExecuteCmd;
import com.zk.monitor.core.entity.JstackEntity;
import com.zk.monitor.core.util.ArrayUtil;
import com.zk.monitor.core.util.PathUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * com.zk.monitor.core.order
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class Jstack {
    private final static String prefix = "java.lang.Thread.State: ";
    /**
     * 该进程的线程信息
     * X轴为时间，Y轴为值的变化
     * @param id
     * @return
     */
    public static JstackEntity jstack(String id) {
        String s = ExecuteCmd.execute(new String[]{"jstack", id});
        int total= ArrayUtil.appearNumber(s, "nid=");
        int RUNNABLE = ArrayUtil.appearNumber(s, prefix+"RUNNABLE");
        int TIMED_WAITING = ArrayUtil.appearNumber(s,prefix+"TIMED_WAITING");
        int WAITING = ArrayUtil.appearNumber(s,prefix+"WAITING");
        return new JstackEntity(id,total,RUNNABLE,TIMED_WAITING,WAITING);
    }

    /**
     * 导出线程快照
     * @param id
     * @return
     */
    public static String dump(String id) throws IOException {
        String path = PathUtil.getRootPath("dump/"+id+"_thread.txt");
        String s = ExecuteCmd.execute(new String[]{"jstack", id});
        File file = new File(path);
        FileUtils.write(file,s, Charset.forName("UTF-8"));
        return path;
    }
}
