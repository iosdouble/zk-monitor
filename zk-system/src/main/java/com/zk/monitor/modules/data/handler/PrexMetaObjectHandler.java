package com.zk.monitor.modules.data.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * com.zk.monitor.modules.data.handler
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 字段自动填充
 **/
@Slf4j
@Component
public class PrexMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        //避免使用metaObject.setValue()
        this.setFieldValByName("delFlag", "0", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("operator", "Tom", metaObject);
    }
}
