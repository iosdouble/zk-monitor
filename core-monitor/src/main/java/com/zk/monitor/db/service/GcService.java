package com.zk.monitor.db.service;

import com.zk.monitor.core.entity.KVEntity;
import com.zk.monitor.db.entity.GcEntity;

import java.util.List;

/**
 * com.zk.monitor.db.service
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public interface GcService {

    public void write(String name, String date, List<KVEntity> kvEntityList);

    public List<GcEntity> findAllByName(String name);

    public void clearAll();
}
