package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysTenant;

import java.util.List;

public interface ISysTenantService extends IService<SysTenant> {

    /**
     * 保存租户
     *
     * @param sysTenant
     * @return
     */
    boolean saveTenant(SysTenant sysTenant);


    /**
     * 获取正常租户
     *
     * @return
     */
    List<SysTenant> getNormalTenant();
}
