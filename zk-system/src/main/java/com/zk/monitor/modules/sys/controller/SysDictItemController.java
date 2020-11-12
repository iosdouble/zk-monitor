package com.zk.monitor.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.domain.SysDictItem;
import com.zk.monitor.modules.sys.service.ISysDictItemService;
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
@RequestMapping("/dictItem")
public class SysDictItemController {


    @Autowired
    private ISysDictItemService dictItemService;

    /**
     * 分页查询字典详情内容
     *
     * @param page        分页对象
     * @param sysDictItem
     * @return
     */
    @SysOperaLog(descrption = "查询字典详情集合")
    @GetMapping
    public AjaxResult getDictItemPage(Page page, SysDictItem sysDictItem) {
        return AjaxResult.ok(dictItemService.page(page, Wrappers.query(sysDictItem)));
    }

    /**
     * 添加字典详情
     * @param sysDictItem
     * @return
     */
    @SysOperaLog(descrption = "添加字典详情")
    @PreAuthorize("hasAuthority('sys:dictItem:add')")
    @PostMapping
    public AjaxResult add(@RequestBody SysDictItem sysDictItem) {
        return AjaxResult.ok(dictItemService.save(sysDictItem));
    }

    /**
     * 更新字典详情
     * @param sysDictItem
     * @return
     */
    @SysOperaLog(descrption = "更新字典详情")
    @PreAuthorize("hasAuthority('sys:dictItem:edit')")
    @PutMapping
    public AjaxResult update(@RequestBody SysDictItem sysDictItem) {
        return AjaxResult.ok(dictItemService.updateById(sysDictItem));
    }

    /**
     * 删除字典详情
     * @param id
     * @return
     */
    @SysOperaLog(descrption = "删除字典详情")
    @PreAuthorize("hasAuthority('sys:dictItem:del')")
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable("id") String id) {
        return AjaxResult.ok(dictItemService.removeById(id));
    }


}

