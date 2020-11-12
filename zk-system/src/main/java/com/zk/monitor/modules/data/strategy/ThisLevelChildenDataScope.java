package com.zk.monitor.modules.data.strategy;

import com.zk.monitor.modules.data.enums.DataScopeTypeEnum;
import com.zk.monitor.modules.sys.dto.RoleDTO;
import com.zk.monitor.modules.sys.service.ISysDeptService;
import com.zk.monitor.modules.sys.service.ISysUserService;
import com.zk.monitor.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.zk.monitor.modules.data.strategy
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Component("3")
public class ThisLevelChildenDataScope implements AbstractDataScopeHandler {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysDeptService deptService;


    @Override
    public List<Integer> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
        Integer deptId = userService.findByUserInfoName(SecurityUtil.getUser().getUsername()).getDeptId();
        return deptService.selectDeptIds(deptId);
    }
}