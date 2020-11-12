package com.zk.monitor.modules.sys.controller;

import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.modules.sys.util.RedisUtil;
import com.zk.monitor.modules.sys.vo.RedisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.zk.monitor.modules.sys.controller
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@RestController
@RequestMapping("/redis")
public class SysRedisController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取所有key
     * @param pageable
     * @return
     */
    @GetMapping
    public AjaxResult getAllByPage(Pageable pageable) {
        List<RedisVo> redisList = redisUtil.getAll();
        int totalElements = redisList.size();
        if (pageable == null) {
            pageable = PageRequest.of(0, 10);
        }
        int fromIndex = pageable.getPageSize() * pageable.getPageNumber();
        int toIndex = pageable.getPageSize() * (pageable.getPageNumber() + 1);
        if (toIndex > totalElements) {
            toIndex = totalElements;
        }
        List<RedisVo> indexObjects = redisList.subList(fromIndex, toIndex);
        Page<RedisVo> page = new PageImpl<>(indexObjects, pageable, totalElements);
        return AjaxResult.ok(page);
    }

    /**
     * 批量删除
     * @param keys
     * @return
     */
    @DeleteMapping("/delKeys")
    public AjaxResult delByKeys(@RequestBody List<String> keys) {
        return AjaxResult.ok(redisUtil.removeKey(keys));
    }

}


