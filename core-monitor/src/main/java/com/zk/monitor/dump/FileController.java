package com.zk.monitor.dump;

import com.zk.monitor.core.order.Jmap;
import com.zk.monitor.core.order.Jstack;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * com.zk.monitor.dump
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
@RestController
public class FileController {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @RequestMapping("/heap")
    public ResponseEntity<byte[]> heapDump(String id) throws IOException {
        assert id!=null&&id!="";
        String dump = Jmap.dump(id);
        File file = new File(dump);
        logger.debug("DownLoad Dump:"+dump);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

    @RequestMapping("/thread")
    public ResponseEntity<byte[]> threadDump(String id) throws IOException {
        assert id!=null&&id!="";
        String dump = Jstack.dump(id);
        File file = new File(dump);
        logger.debug("DownLoad Dump:"+dump);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
