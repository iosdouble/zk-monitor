package com.zk.monitor.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.monitor.modules.sys.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {


    @Select("select m.perms from sys_menu m, sys_user u, sys_user_role ur, sys_role_menu rm\n" +
            "        where u.user_id = #{user_id} and u.user_id = ur.user_id\n" +
            "          and ur.role_id = rm.role_id and rm.menu_id = m.menu_id")
    List<String> findPermsByUserId(Integer userId);

}
