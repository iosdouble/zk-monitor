package com.zk.monitor.common.utils;

import cn.hutool.core.util.PageUtil;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zk.monitor.common.utils
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 * TODO 分页工具类
 **/
@UtilityClass
public class PrePageUtil extends PageUtil {
    /**
     * List 分页
     * @param page
     * @param size
     * @param list
     * @return
     */
    public List toPage(int page, int size , List list) {
        int fromIndex = page * size;
        int toIndex = page * size + size;

        if(fromIndex > list.size()){
            return new ArrayList();
        } else if(toIndex >= list.size()) {
            return list.subList(fromIndex,list.size());
        } else {
            return list.subList(fromIndex,toIndex);
        }
    }
}
