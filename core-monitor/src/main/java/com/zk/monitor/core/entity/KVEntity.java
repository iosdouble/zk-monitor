package com.zk.monitor.core.entity;

/**
 * com.zk.monitor.core.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class KVEntity {
    private String key;
    private String value;

    public KVEntity() {
    }

    public KVEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
