package com.zk.monitor.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.monitor.modules.sys.domain.SysSocial;
import com.zk.monitor.modules.sys.domain.SysUser;
import com.zk.monitor.modules.sys.mapper.SysSocialMapper;
import com.zk.monitor.modules.sys.service.ISysSocialService;
import com.zk.monitor.modules.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SysSocialServiceImpl extends ServiceImpl<SysSocialMapper, SysSocial> implements ISysSocialService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public IPage<SysSocial> selectSocialList(Page page, SysSocial social) {
        IPage<SysSocial> socialIPage = baseMapper.selectPage(page, Wrappers.query(social));
        socialIPage.setRecords(socialIPage.getRecords().stream().peek(sysSocial -> sysSocial.setUserName(sysUserService.findSecurityUserByUser(new SysUser().setUserId(Integer.valueOf(sysSocial.getUserId()))).getUsername())).collect(Collectors.toList()));
        return socialIPage;
    }

}