package com.zk.monitor.generator.service;

import com.zk.monitor.generator.domain.CodeGenConfig;
import com.zk.monitor.generator.domain.SysColumnEntity;
import com.zk.monitor.generator.domain.SysTableEntity;

import java.util.List;

/**
 * com.zk.monitor.generator.service
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 *
 * TODO 代码生成服务类
 **/
public interface SysCodeService {
    List<SysTableEntity> findTableList(String tableSchema);

    List<SysColumnEntity> findColumnList(String tableName, String tableSchema);

    /**
     * 代码生成
     * @param codeGenConfig
     * @return
     */
    boolean generatorCode(CodeGenConfig codeGenConfig);;
}
