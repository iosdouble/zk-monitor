package com.zk.monitor.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.sys.domain.SysDict;
import com.zk.monitor.modules.sys.dto.DictDTO;
import com.zk.monitor.modules.sys.service.ISysDictService;
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
@RequestMapping("/dict")
public class SysDictController {

    @Autowired
    private ISysDictService dictService;

    /**
     * 添加字典信息
     *
     * @param sysDict
     * @return
     */
    @SysOperaLog(descrption = "添加字典信息")
    @PreAuthorize("hasAuthority('sys:dict:add')")
    @PostMapping
    public AjaxResult add(@RequestBody SysDict sysDict) {
        return AjaxResult.ok(dictService.save(sysDict));
    }

    /**
     * 获取字典列表集合
     *
     * @param page
     * @param sysDict
     * @return
     */
    @SysOperaLog(descrption = "查询字典集合")
    @GetMapping
    @PreAuthorize("hasAuthority('sys:dipt:view')")
    public AjaxResult getList(Page page, SysDict sysDict) {
        return AjaxResult.ok(dictService.page(page, Wrappers.query(sysDict)));
    }


    /**
     * 更新字典
     *
     * @param dictDto
     * @return
     */
    @SysOperaLog(descrption = "更新字典")
    @PreAuthorize("hasAuthority('sys:dict:edit')")
    @PutMapping
    public AjaxResult update(@RequestBody DictDTO dictDto) {
        return AjaxResult.ok(dictService.updateDict(dictDto));
    }


    /**
     * 根据id删除字典
     *
     * @param id
     * @return //
     */
    @SysOperaLog(descrption = "根据id删除字典")
    @PreAuthorize("hasAuthority('sys:dict:del')")
    @DeleteMapping("{id}")
    public AjaxResult delete(@PathVariable("id") int id) {
        return AjaxResult.ok(dictService.removeById(id));
    }


    /**
     * 根据字典名称查询字段详情
     * @param dictName
     * @return
     */
    @GetMapping("/queryDictItemByDictName/{dictName}")
    public AjaxResult queryDictItemByDictName(@PathVariable("dictName") String dictName) {
        return AjaxResult.ok(dictService.queryDictItemByDictName(dictName));
    }

}


