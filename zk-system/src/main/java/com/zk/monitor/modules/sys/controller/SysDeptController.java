package com.zk.monitor.modules.sys.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.domain.SysDept;
import com.zk.monitor.modules.sys.dto.DeptDTO;
import com.zk.monitor.modules.sys.service.ISysDeptService;
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
@RequestMapping("/dept")
public class SysDeptController {

    @Autowired
    private ISysDeptService deptService;

    /**
     * 保存部门信息
     *
     * @param sysDept
     * @return
     */
    @SysOperaLog(descrption = "保存部门信息")
    @PostMapping
    @PreAuthorize("hasAuthority('sys:dept:add')")
    public AjaxResult save(@RequestBody SysDept sysDept) {
        return AjaxResult.ok(deptService.save(sysDept));
    }

    /**
     * 获取部门信息
     *
     * @return
     */
    @GetMapping
    @PreAuthorize("hasAuthority('sys:dept:view')")
    public AjaxResult getDeptList() {
        return AjaxResult.ok(deptService.selectDeptList());
    }

    /**
     * 获取部门树
     * @return
     */
    @GetMapping("/tree")
    public AjaxResult getDeptTree() {
        return AjaxResult.ok(deptService.getDeptTree());
    }


    /**
     * 更新部门信息
     *
     * @return
     */
    @SysOperaLog(descrption = "更新部门信息")
    @PutMapping
    @PreAuthorize("hasAuthority('sys:dept:update')")
    public AjaxResult update(@RequestBody DeptDTO deptDto) {
        return AjaxResult.ok(deptService.updateDeptById(deptDto));
    }

    /**
     * 根据id删除部门信息
     *
     * @return
     */
    @SysOperaLog(descrption = "根据id删除部门信息")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    public AjaxResult delete(@PathVariable("id") Integer id) {
        return AjaxResult.ok(deptService.removeById(id));
    }


}


