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
public class DictDTO {


    private Integer id;

    private String dictName;

    private String dictCode;

    private String description;

    private Integer sort;

    private String remark;
}
