package com.zk.monitor.socket.controller;

import com.zk.monitor.db.entity.ClassLoadEntity;
import com.zk.monitor.db.entity.GcEntity;
import com.zk.monitor.db.entity.ThreadEntity;
import com.zk.monitor.db.service.ClassService;
import com.zk.monitor.db.service.GcService;
import com.zk.monitor.db.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.zk.monitor.socket.controller
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@RestController
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private GcService gcService;
    @Autowired
    private ClassService classService;
    @Autowired
    private ThreadService threadService;

    @MessageMapping("/gc")
    @SendTo("/topic/gc")
    public List<GcEntity> socketGc(String name){
        return gcService.findAllByName(name);
    }

    @MessageMapping("/cl")
    @SendTo("/topic/cl")
    public List<ClassLoadEntity> socketCl(String name){
        return classService.findAllByName(name);
    }

    @MessageMapping("/thread")
    @SendTo("/topic/thread")
    public List<ThreadEntity> socketThread(String name){
        return threadService.findAllByName(name);
    }
}
