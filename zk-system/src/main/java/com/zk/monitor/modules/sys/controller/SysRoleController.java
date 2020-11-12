package com.zk.monitor.modules.sys.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.dto.RoleDTO;
import com.zk.monitor.modules.sys.service.ISysRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * com.zk.monitor.modules.sys.controller
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Resource
    private ISysRoleService roleService;

    /**
     * 获取角色列表
     *
     * @return
     */
    @GetMapping
    @PreAuthorize("hasAuthority('sys:role:view')")
    public AjaxResult getRoleList(@RequestParam String roleName) {
        return AjaxResult.ok(roleService.selectRoleList(roleName));
    }

    /**
     * 保存角色以及菜单权限
     *
     * @param roleDto
     * @return
     */
    @SysOperaLog(descrption = "保存角色以及菜单权限")
    @PostMapping
    @PreAuthorize("hasAuthority('sys:role:add')")
    public AjaxResult save(@RequestBody RoleDTO roleDto) {
        return AjaxResult.ok(roleService.saveRoleMenu(roleDto));
    }

    /**
     * 根据角色id获取菜单
     *
     * @param roleId
     * @return
     */
    @SysOperaLog(descrption = "据角色id获取菜单")
    @GetMapping("/findRoleMenus/{roleId}")
    public AjaxResult findRoleMenus(@PathVariable("roleId") Integer roleId) {
        return AjaxResult.ok(roleService.findMenuListByRoleId(roleId));
    }


    /**
     * 更新角色以及菜单权限
     * @param roleDto
     * @return
     */
    @SysOperaLog(descrption = "更新角色以及菜单权限")
    @PutMapping
    @PreAuthorize("hasAuthority('sys:role:update')")
    public AjaxResult update(@RequestBody RoleDTO roleDto) {
        return AjaxResult.ok(roleService.updateRoleMenu(roleDto));
    }

    /**
     * 删除角色以及权限
     * @param roleId
     * @return
     */
    @SysOperaLog(descrption = "删除角色以及权限")
    @DeleteMapping("/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public AjaxResult delete(@PathVariable("roleId") Integer roleId) {
        return AjaxResult.ok(roleService.removeById(roleId));
    }



}


