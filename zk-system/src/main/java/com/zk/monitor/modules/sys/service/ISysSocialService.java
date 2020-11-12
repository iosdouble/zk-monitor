package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysSocial;

public interface ISysSocialService extends IService<SysSocial> {

    /**
     * 分页查询社区账号绑定集合
     * @param page
     * @return
     */
    IPage<SysSocial> selectSocialList(Page page, SysSocial sysSocial);

}
