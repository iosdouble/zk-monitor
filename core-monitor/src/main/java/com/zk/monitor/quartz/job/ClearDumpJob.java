package com.zk.monitor.quartz.job;

import com.zk.monitor.core.util.PathUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * com.zk.monitor.quartz.job
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@Component
public class ClearDumpJob {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    /**
     * 清理快照目录
     */
    @Scheduled(cron="0 0 0 * * ?")
    public void clearDump() {
        String path = PathUtil.getRootPath("dump/");
        File file = new File(path);
        if (!file.exists()){
            return;
        }
        try {
            FileUtils.deleteDirectory(file);
            logger.warn("Delete dump directory successful");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
