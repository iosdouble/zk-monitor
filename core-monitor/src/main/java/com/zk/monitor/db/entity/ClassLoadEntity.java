package com.zk.monitor.db.entity;

/**
 * com.zk.monitor.db.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class ClassLoadEntity {

    private Integer id;
    private String name; //进程ID
    private String date; //x：时间
    private String Loaded;
    private String Bytes1;
    private String Unloaded;
    private String Bytes2;
    private String Time1;
    private String Compiled;
    private String Failed;
    private String Invalid;
    private String Time2;

    public ClassLoadEntity() {
    }

    public ClassLoadEntity(Integer id, String name, String date, String loaded, String bytes1, String unloaded, String bytes2, String time1, String compiled, String failed, String invalid, String time2) {
        this.id = id;
        this.name = name;
        this.date = date;
        Loaded = loaded;
        Bytes1 = bytes1;
        Unloaded = unloaded;
        Bytes2 = bytes2;
        Time1 = time1;
        Compiled = compiled;
        Failed = failed;
        Invalid = invalid;
        Time2 = time2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoaded() {
        return Loaded;
    }

    public void setLoaded(String loaded) {
        Loaded = loaded;
    }

    public String getBytes1() {
        return Bytes1;
    }

    public void setBytes1(String bytes1) {
        Bytes1 = bytes1;
    }

    public String getUnloaded() {
        return Unloaded;
    }

    public void setUnloaded(String unloaded) {
        Unloaded = unloaded;
    }

    public String getBytes2() {
        return Bytes2;
    }

    public void setBytes2(String bytes2) {
        Bytes2 = bytes2;
    }

    public String getTime1() {
        return Time1;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public String getCompiled() {
        return Compiled;
    }

    public void setCompiled(String compiled) {
        Compiled = compiled;
    }

    public String getFailed() {
        return Failed;
    }

    public void setFailed(String failed) {
        Failed = failed;
    }

    public String getInvalid() {
        return Invalid;
    }

    public void setInvalid(String invalid) {
        Invalid = invalid;
    }

    public String getTime2() {
        return Time2;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }
}
