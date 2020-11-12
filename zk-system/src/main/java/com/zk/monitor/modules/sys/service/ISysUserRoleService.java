package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysUserRole;

import java.util.List;

public interface ISysUserRoleService extends IService<SysUserRole> {


    /**
     * 根据用户id查询用户角色关系
     * @param userId
     * @return
     */
    List<SysUserRole> selectUserRoleListByUserId(Integer userId);
}
