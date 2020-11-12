package com.zk.monitor.generator.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.generator.domain.CodeGenConfig;
import com.zk.monitor.generator.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * com.zk.monitor.generator.controller
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@RestController
@RequestMapping("/codegen")
public class SysCodeGenController {

    @Autowired
    private SysCodeService sysCodeService;

    /**
     * 获取数据库的所有表
     *
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableList")
    public AjaxResult getTableList(@RequestParam String tableSchema) {
        return AjaxResult.ok(sysCodeService.findTableList(tableSchema));
    }

    /**
     * 获取表中的所有字段以及列属性
     *
     * @param tableName
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableColumnList")
    public AjaxResult getTableColumnList(@RequestParam String tableName, @RequestParam String tableSchema) {
        return AjaxResult.ok(sysCodeService.findColumnList(tableName, tableSchema));
    }

    @PreAuthorize("hasAuthority('sys:codegen:codegen')")
    @PostMapping("/codegen")
    public AjaxResult generatorCode(@RequestBody CodeGenConfig codeGenConfig) {
        return AjaxResult.ok(sysCodeService.generatorCode(codeGenConfig));
    }
}
