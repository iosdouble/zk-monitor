package com.zk.monitor.log.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.log.service.ISysLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log")
public class SysLogController {

    @Resource
    private ISysLogService logService;

    /**
     *
     * 分页查询日志列表
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    @PreAuthorize("hasAuthority('sys:log:view')")
    public AjaxResult selectLog(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam("type") Integer type, @RequestParam String userName){
        return AjaxResult.ok(logService.selectLogList(page, pageSize,type,userName));
    }


    @SysOperaLog(descrption = "删除日志")
    @DeleteMapping("/{logId}")
    @PreAuthorize("hasAuthority('sys:log:delete')")
    public AjaxResult delete(@PathVariable("logId") Integer logId) {
        return AjaxResult.ok(logService.removeById(logId));
    }
}

