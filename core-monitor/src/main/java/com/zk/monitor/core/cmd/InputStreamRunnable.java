package com.zk.monitor.core.cmd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * com.zk.monitor.core
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class InputStreamRunnable implements Runnable {
    private BufferedReader bReader = null;

    InputStreamRunnable(InputStream is, String type) {
        try {
            bReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(is), "UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        String line;
        int num = 1;
        try {
            while ((line = bReader.readLine()) != null) {
                System.out.println("---->"+String.format("%02d",num++)+" "+line);
            }
            bReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
