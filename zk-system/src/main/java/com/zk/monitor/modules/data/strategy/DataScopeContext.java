package com.zk.monitor.modules.data.strategy;

import com.zk.monitor.modules.data.enums.DataScopeTypeEnum;
import com.zk.monitor.modules.sys.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.zk.monitor.modules.data.strategy
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Service
public class DataScopeContext {

    @Autowired
    private final Map<String, AbstractDataScopeHandler> strategyMap = new ConcurrentHashMap<>();

    /**
     * Component里边的1是指定其名字，这个会作为key放到strategyMap里
     * @param strategyMap
     */
    public DataScopeContext(Map<String, AbstractDataScopeHandler> strategyMap) {
        strategyMap.forEach(this.strategyMap::put);
    }

    public List<Integer> getDeptIdsForDataScope(RoleDTO roleDto, Integer type) {
        return strategyMap.get(String.valueOf(type)).getDeptIds(roleDto, DataScopeTypeEnum.valueOf(type));
    }
}
