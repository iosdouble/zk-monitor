package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.modules.sys.domain.SysDict;
import com.zk.monitor.modules.sys.domain.SysDictItem;
import com.zk.monitor.modules.sys.dto.DictDTO;

import java.io.Serializable;
import java.util.List;

/**
 * com.zk.monitor.modules.sys.service
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
public interface ISysDictService extends IService<SysDict> {

    /**
     * 修改字典
     * @param dictDto
     * @return
     */
    boolean updateDict(DictDTO dictDto);


    /**
     * 根据主键Id删除字典
     * @param id
     * @return
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 根据字典名称查询字段详情
     * @param dictName
     * @return
     */
    List<SysDictItem> queryDictItemByDictName(String dictName);
}
