package com.zk.monitor.generator.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * com.zk.monitor.generator.domain
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
public class SysDatasource {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * jdbcurl
     */
    private String url;

    /**
     * 驱动
     */
    private String driverName;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;
    /**
     * 更新
     */
    private LocalDateTime updateDate;
}
