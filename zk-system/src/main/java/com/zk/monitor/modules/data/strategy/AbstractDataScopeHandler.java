package com.zk.monitor.modules.data.strategy;

import com.zk.monitor.modules.data.enums.DataScopeTypeEnum;
import com.zk.monitor.modules.sys.dto.RoleDTO;

import java.util.List;

/**
 * com.zk.monitor.modules.data.strategy
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
public interface AbstractDataScopeHandler {
    /**
     * @param roleDto
     * @param dataScopeTypeEnum
     * @return
     */
    List<Integer> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum);
}
