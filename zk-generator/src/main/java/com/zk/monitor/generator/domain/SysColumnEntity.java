package com.zk.monitor.generator.domain;

import lombok.Data;

/**
 * com.zk.monitor.generator.domain
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
public class SysColumnEntity {
    /**
     * 列表
     */
    private String columnName;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 备注
     */
    private String columnComment;
    /**
     * 字符集
     */
    private String characterSetName;
    /**
     * 列字段类型
     */
    private String columnType;
}
