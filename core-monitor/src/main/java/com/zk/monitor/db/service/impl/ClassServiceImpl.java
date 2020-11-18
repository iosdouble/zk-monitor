package com.zk.monitor.db.service.impl;

import com.zk.monitor.core.entity.KVEntity;
import com.zk.monitor.db.entity.ClassLoadEntity;
import com.zk.monitor.db.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.zk.monitor.db.service.impl
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@Service
public class ClassServiceImpl implements ClassService {
    @Override
    public List<ClassLoadEntity> findAllByName(String name) {
        return null;
    }

    @Override
    public void write(String name, String date, List<KVEntity> jstatClass) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void clearAll() {

    }
}
