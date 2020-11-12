package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysMenu;
import com.zk.monitor.modules.sys.domain.SysRole;
import com.zk.monitor.modules.sys.dto.RoleDTO;

import java.io.Serializable;
import java.util.List;

public interface ISysRoleService extends IService<SysRole> {

    /**
     * 保存角色和菜单
     * @param roleDto
     * @return
     */
    boolean saveRoleMenu(RoleDTO roleDto);

    /**
     * 更新角色和菜单
     * @param roleDto
     * @return
     */
    boolean updateRoleMenu(RoleDTO roleDto);

    /**
     * 根据主键删除角色
     * @param id
     * @return
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 获取角色列表
     * @return
     */
    List<SysRole> selectRoleList(String roleName);

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    List<SysMenu> findMenuListByRoleId(int roleId);

    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(Integer userId);
}
