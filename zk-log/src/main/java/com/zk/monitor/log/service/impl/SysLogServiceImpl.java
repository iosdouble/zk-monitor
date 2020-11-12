package com.zk.monitor.log.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.monitor.log.domain.SysLog;
import com.zk.monitor.log.mapper.SysLogMapper;
import com.zk.monitor.log.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * com.zk.monitor.log.service.impl
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Override
    public IPage<SysLog> selectLogList(Integer page, Integer pageSize, Integer type, String userName) {
        Page<SysLog> logPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<SysLog> sysLogLambdaQueryWrapper = Wrappers.<SysLog>lambdaQuery().eq(SysLog::getType, type).orderByDesc(SysLog::getStartTime);
        if (StrUtil.isNotEmpty(userName)) {
            sysLogLambdaQueryWrapper.like(SysLog::getUserName, userName);
        }
        return baseMapper.selectPage(logPage, sysLogLambdaQueryWrapper);
    }
}

