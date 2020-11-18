package com.zk.monitor.core.entity;

/**
 * com.zk.monitor.core.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class JstackEntity {
    private String id;
    private int total;
    private int RUNNABLE;
    private int TIMED_WAITING;
    private int WAITING;

    public JstackEntity() {
    }

    public JstackEntity(String id, int total, int RUNNABLE, int TIMED_WAITING, int WAITING) {
        this.id = id;
        this.total = total;
        this.RUNNABLE = RUNNABLE;
        this.TIMED_WAITING = TIMED_WAITING;
        this.WAITING = WAITING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
