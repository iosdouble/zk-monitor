package com.zk.monitor.db.entity;

/**
 * com.zk.monitor.db.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class ThreadEntity {

    private Integer id;
    private String name; //进程ID
    private String date; //x：时间
    private int total;
    private int RUNNABLE;
    private int TIMED_WAITING;
    private int WAITING;

    public ThreadEntity() {
    }

    public ThreadEntity(Integer id, String name, String date, int total, int RUNNABLE, int TIMED_WAITING, int WAITING) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.total = total;
        this.RUNNABLE = RUNNABLE;
        this.TIMED_WAITING = TIMED_WAITING;
        this.WAITING = WAITING;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRUNNABLE() {
        return RUNNABLE;
    }

    public void setRUNNABLE(int RUNNABLE) {
        this.RUNNABLE = RUNNABLE;
    }

    public int getTIMED_WAITING() {
        return TIMED_WAITING;
    }

    public void setTIMED_WAITING(int TIMED_WAITING) {
        this.TIMED_WAITING = TIMED_WAITING;
    }

    public int getWAITING() {
        return WAITING;
    }

    public void setWAITING(int WAITING) {
        this.WAITING = WAITING;
    }
}
