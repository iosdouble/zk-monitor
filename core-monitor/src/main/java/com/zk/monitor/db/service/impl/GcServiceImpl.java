package com.zk.monitor.db.service.impl;

import com.zk.monitor.core.entity.KVEntity;
import com.zk.monitor.db.entity.GcEntity;
import com.zk.monitor.db.service.GcService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.zk.monitor.db.service.impl
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@Service
public class GcServiceImpl implements GcService {
    @Override
    public void write(String name, String date, List<KVEntity> kvEntityList) {

    }

    @Override
    public List<GcEntity> findAllByName(String name) {
        return null;
    }

    @Override
    public void clearAll() {

    }
}
