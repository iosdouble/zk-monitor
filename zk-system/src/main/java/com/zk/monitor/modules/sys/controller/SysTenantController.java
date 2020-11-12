package com.zk.monitor.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.domain.SysTenant;
import com.zk.monitor.modules.sys.service.ISysTenantService;
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
@RequestMapping("/tenant")
public class SysTenantController {

    @Autowired
    private ISysTenantService sysTenantService;

    /**
     * 分页查询
     *
     * @param page      分页对象
     * @param sysTenant 租户对象
     * @return
     */
    @GetMapping("/page")
    public AjaxResult getSysTenantPage(Page page, SysTenant sysTenant) {
        return AjaxResult.ok(sysTenantService.page(page, Wrappers.query(sysTenant)));
    }

    /**
     * 查询全部有效的租户
     *
     * @return
     */
    @GetMapping("/list")
    public AjaxResult list() {
        return AjaxResult.ok(sysTenantService.getNormalTenant());
    }


    /**
     * 新增租户
     *
     * @param sysTenant 租户
     * @return R
     */
    @SysOperaLog(descrption = "新增租户")
    @PostMapping
    @PreAuthorize("hasAuthority('sys:tenant:add')")
    public AjaxResult save(@RequestBody SysTenant sysTenant) {
        return AjaxResult.ok(sysTenantService.saveTenant(sysTenant));
    }

    /**
     * 修改租户
     *
     * @param sysTenant 租户
     * @return R
     */
    @SysOperaLog(descrption = "修改租户")
    @PutMapping
    @PreAuthorize("hasAuthority('sys:tenant:update')")
    public AjaxResult updateById(@RequestBody SysTenant sysTenant) {
        return AjaxResult.ok(sysTenantService.updateById(sysTenant));
    }


    /**
     * 通过id删除租户
     *
     * @param id id
     * @return R
     */
    @SysOperaLog(descrption = "删除租户")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:tenant:del')")
    public AjaxResult removeById(@PathVariable Integer id) {
        return AjaxResult.ok(sysTenantService.removeById(id));
    }

    /**
     * 设置租户id -- 主要是第三方登录使用 目的需要发送请求 看看后面有没有办法解决
     *
     * @param tenantId
     */
    @PostMapping("/setting/{tenantId}")
    public AjaxResult setting(@PathVariable Integer tenantId) {
        return AjaxResult.ok();
    }


}


