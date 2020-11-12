package com.zk.monitor.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.log.domain.SysLog;

/**
 * com.zk.monitor.log.service
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 日志服务 系统类
 **/
public interface ISysLogService extends IService<SysLog> {
    /**
     * 分页查询日志
     * @param page
     * @param pageSize
     * @param type
     * @return
     */
    IPage<SysLog> selectLogList(Integer page, Integer pageSize, Integer type, String userName);

}
