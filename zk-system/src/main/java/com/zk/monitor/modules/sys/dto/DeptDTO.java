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
public class DeptDTO {

    private static final long serialVersionUID = 1L;

    private Integer deptId;

    /**
     * 部门名称
     */
    private String name;


    /**
     * 上级部门
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;


}
