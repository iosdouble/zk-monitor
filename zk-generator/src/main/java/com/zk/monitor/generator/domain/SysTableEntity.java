package com.zk.monitor.generator.domain;

import lombok.Data;

/**
 * com.zk.monitor.generator.domain
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
public class SysTableEntity {

    /**
     * 名称
     */
    private String tableName;
    /**
     * 备注
     */
    private String comments;
    /**
     * 归属库
     */
    private String tableSchema;
    /**
     * 创建时间
     */
    private String createTime;
}
