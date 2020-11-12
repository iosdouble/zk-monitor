package com.zk.monitor.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.monitor.common.utils.AjaxResult;
import com.zk.monitor.modules.sys.domain.SysMenu;
import com.zk.monitor.modules.sys.dto.MenuDTO;

import java.io.Serializable;
import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 更新菜单信息
     * @param entity
     * @return
     */
    boolean updateMenuById(MenuDTO entity);

    /**
     * 删除菜单信息
     * @param id
     * @return
     */
    AjaxResult removeMenuById(Serializable id);

    /**
     * 根据用户id查找菜单树
     * @return
     */
    List<SysMenu> selectMenuTree(Integer uid);

    /**
     * @Author 李号东
     * @Description 根据父id查询菜单
     * @Date 18:43 2019-05-12
     **/
    SysMenu getMenuById(Integer parentId);

    /**
     * @Description 根据用户id查询权限
     **/
    List<String> findPermsByUserId(Integer userId);
}
