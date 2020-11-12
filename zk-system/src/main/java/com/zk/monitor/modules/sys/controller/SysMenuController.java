package com.zk.monitor.modules.sys.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.domain.SysMenu;
import com.zk.monitor.modules.sys.dto.MenuDTO;
import com.zk.monitor.modules.sys.service.ISysMenuService;
import com.zk.monitor.modules.sys.util.PreUtil;
import com.zk.monitor.security.PreSecurityUser;
import com.zk.monitor.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * com.zk.monitor.modules.sys.controller
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private ISysMenuService menuService;

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    @PreAuthorize("hasAuthority('sys:menu:add')")
    @SysOperaLog(descrption = "添加菜单")
    @PostMapping
    public AjaxResult save(@RequestBody SysMenu menu) {
        return AjaxResult.ok(menuService.save(menu));
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @GetMapping
    public AjaxResult getMenuTree() {
        PreSecurityUser securityUser = SecurityUtil.getUser();
        return AjaxResult.ok(menuService.selectMenuTree(securityUser.getUserId()));
    }


    /**
     * 获取所有菜单
     *
     * @return
     */
    @GetMapping("/getMenus")
    public AjaxResult getMenus() {
        return AjaxResult.ok(menuService.selectMenuTree(0));
    }

    /**
     * 修改菜单
     *
     * @param menuDto
     * @return
     */
    @PreAuthorize("hasAuthority('sys:menu:update')")
    @SysOperaLog(descrption = "修改菜单")
    @PutMapping
    public AjaxResult updateMenu(@RequestBody MenuDTO menuDto) {
        return AjaxResult.ok(menuService.updateMenuById(menuDto));
    }

    /**
     * 根据id删除菜单
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    @SysOperaLog(descrption = "删除菜单")
    @DeleteMapping("/{id}")
    public AjaxResult deleteMenu(@PathVariable("id") Integer id) {
        return menuService.removeMenuById(id);
    }

    /**
     * 获取路由
     *
     * @return
     */
    @GetMapping("/getRouters")
    public AjaxResult getRouters() {
        PreSecurityUser securityUser = SecurityUtil.getUser();
//        List<MenuVo> menuVos = PreUtil.buildMenus(menuService.selectMenuTree(securityUser.getUserId()));
        return AjaxResult.ok(PreUtil.buildMenus(menuService.selectMenuTree(securityUser.getUserId())));
    }

}


