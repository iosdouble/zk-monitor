package com.zk.monitor.generator.domain;

import lombok.Data;

/**
 * com.zk.monitor.generator.domain
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
public class CodeGenConfig {
    /**
     * 包名
     */
    private String packageName;
    /**
     * 作者
     */
    private String author;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表备注
     */
    private String comments;
}
