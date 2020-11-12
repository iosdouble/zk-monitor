package com.zk.monitor.modules.sys.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * com.zk.monitor.modules.sys.dto
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
public class UserDTO implements Serializable {

    private Integer userId;
    private String username;
    private String password;
    private Integer deptId;
    private String phone;
    private String email;
    private String avatar;
    private String lockFlag;
    private String delFlag;
    private List<Integer> roleList;
    private List<Integer> deptList;
    /**
     * 新密码
     */
    private String newPassword;
    private String smsCode;
}
