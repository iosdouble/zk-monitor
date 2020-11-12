package com.zk.monitor.modules.sys.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.zk.monitor.modules.sys.dto
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuDTO {

    private static final long serialVersionUID = 1L;

    private Integer menuId;
    private String name;
    private String perms;
    private String path;
    private Boolean isFrame;
    private Integer parentId;
    private String component;
    private String icon;
    private Integer sort;
    private Integer type;
    private String delFlag;

}

