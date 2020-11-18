package com.zk.monitor.db.service;

import com.zk.monitor.core.entity.KVEntity;
import com.zk.monitor.db.entity.ClassLoadEntity;

import java.util.List;

/**
 * com.zk.monitor.db.service
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public interface ClassService {

    public List<ClassLoadEntity> findAllByName(String name);

    public void write(String name, String date, List<KVEntity> jstatClass);

    public void clear();

    public void clearAll();
}
