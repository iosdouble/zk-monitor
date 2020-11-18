package com.zk.monitor.db.service;

import com.zk.monitor.core.entity.JstackEntity;
import com.zk.monitor.db.entity.ThreadEntity;

import java.util.List;

/**
 * com.zk.monitor.db.service
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public interface ThreadService {

    public List<ThreadEntity> findAllByName(String name);

    public void write(String name, String date, JstackEntity jstatk);

    public void clear();

    public void clearAll();
}
