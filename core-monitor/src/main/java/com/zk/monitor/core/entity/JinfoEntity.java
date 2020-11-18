package com.zk.monitor.core.entity;

import java.util.List;

/**
 * com.zk.monitor.core.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class JinfoEntity {
    private List<String> noedefault;
    private List<String> commandLine;

    public JinfoEntity(List<String> noedefault, List<String> commandLine) {
        this.noedefault = noedefault;
        this.commandLine = commandLine;
    }

    public JinfoEntity() {
    }

    public List<String> getNoedefault() {
        return noedefault;
    }

    public void setNoedefault(List<String> noedefault) {
        this.noedefault = noedefault;
    }

    public List<String> getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(List<String> commandLine) {
        this.commandLine = commandLine;
    }
}
