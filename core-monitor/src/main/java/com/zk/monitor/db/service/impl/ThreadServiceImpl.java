package com.zk.monitor.db.service.impl;

import com.zk.monitor.core.entity.JstackEntity;
import com.zk.monitor.db.entity.ThreadEntity;
import com.zk.monitor.db.service.ThreadService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.zk.monitor.db.service.impl
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@Service
public class ThreadServiceImpl implements ThreadService {
    @Override
    public List<ThreadEntity> findAllByName(String name) {
        return null;
    }

    @Override
    public void write(String name, String date, JstackEntity jstatk) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void clearAll() {

    }
}
