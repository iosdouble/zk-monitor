package com.zk.monitor.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.monitor.modules.sys.domain.SysRoleDept;
import com.zk.monitor.modules.sys.mapper.SysRoleDeptMapper;
import com.zk.monitor.modules.sys.service.ISysRoleDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {


    @Override
    public List<SysRoleDept> getRoleDeptIds(int roleId) {
        return baseMapper.selectList(Wrappers.<SysRoleDept>lambdaQuery().select(SysRoleDept::getDeptId).eq(SysRoleDept::getRoleId,roleId));
    }
}