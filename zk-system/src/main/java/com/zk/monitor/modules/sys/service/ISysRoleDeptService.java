package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysRoleDept;

import java.util.List;

public interface ISysRoleDeptService extends IService<SysRoleDept> {

    /**
     * 根据角色id查询部门ids
     * @param roleId
     * @return
     */
    List<SysRoleDept> getRoleDeptIds(int roleId);
}
