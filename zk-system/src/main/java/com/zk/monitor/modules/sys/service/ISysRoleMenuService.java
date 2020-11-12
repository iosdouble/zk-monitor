package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysRoleMenu;

import java.util.List;

public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    List<Integer> getMenuIdByUserId(Integer userId);


}
