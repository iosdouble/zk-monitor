package com.zk.monitor.modules.data.strategy;

import com.zk.monitor.modules.data.enums.DataScopeTypeEnum;
import com.zk.monitor.modules.sys.domain.SysDept;
import com.zk.monitor.modules.sys.dto.RoleDTO;
import com.zk.monitor.modules.sys.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.zk.monitor.modules.data.strategy
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Component("1")
public class AllDataScope implements AbstractDataScopeHandler {
    @Autowired
    private ISysDeptService deptService;


    @Override
    public List<Integer> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
        List<SysDept> sysDepts = deptService.list();
        return sysDepts.stream().map(SysDept::getDeptId).collect(Collectors.toList());
    }
}
