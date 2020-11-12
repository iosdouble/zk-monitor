package com.zk.monitor.modules.sys.dto;

import com.zk.monitor.modules.sys.domain.SysRoleMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * com.zk.monitor.modules.sys.dto
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Setter
@Getter
public class RoleDTO {
    private static final long serialVersionUID = 1L;

    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private String delFlag;
    private int dsType;
    List<SysRoleMenu> roleMenus;
    List<Integer> roleDepts;

}
