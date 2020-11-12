package com.zk.monitor.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.log.annotation.SysOperaLog;
import com.zk.monitor.modules.security.social.SocialRedisHelper;
import com.zk.monitor.modules.sys.domain.SysSocial;
import com.zk.monitor.modules.sys.service.ISysSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.zk.monitor.modules.sys.controller
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@RestController
@RequestMapping("/social")
public class SysSocialController {

    @Autowired
    private SocialRedisHelper socialRedisHelper;
    @Autowired
    private ISysSocialService socialService;


    /**
     * 社交查询列表
     *
     * @param page
     * @return
     */
    @PreAuthorize("hasAuthority('sys:social:view')")
    @GetMapping
    public AjaxResult selectSocial(Page page, SysSocial sysSocial) {
        return AjaxResult.ok(socialService.selectSocialList(page,sysSocial));
    }

    /**
     * 社交登录解绑
     * @param userId
     * @param providerId
     * @return
     */
    @SysOperaLog(descrption = "解绑社交账号")
    @PostMapping("/untied")
    @PreAuthorize("hasAuthority('sys:social:untied')")
    public AjaxResult untied(Integer userId, String providerId) {
        //将业务系统的用户与社交用户绑定
        socialRedisHelper.doPostSignDown(userId, providerId);
        return AjaxResult.ok();
    }


}

