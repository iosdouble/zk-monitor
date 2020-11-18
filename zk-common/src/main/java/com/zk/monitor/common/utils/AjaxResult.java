package com.zk.monitor.common.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * com.zk.monitor.common.utils
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 响应消息体封装
 **/
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AjaxResult {
    private int code = 200;
    private String msg;
    private Object data;

    public static AjaxResult ok() {
        AjaxResult r = new AjaxResult();
        r.setMsg("操作成功");
        return r;
    }

    public static AjaxResult ok(Object data) {
        AjaxResult r = new AjaxResult();
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public static AjaxResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static AjaxResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult r = new AjaxResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
