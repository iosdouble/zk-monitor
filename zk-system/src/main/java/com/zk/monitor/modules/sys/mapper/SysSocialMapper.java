package com.zk.monitor.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.monitor.modules.sys.domain.SysSocial;
import org.apache.ibatis.annotations.Select;

public interface SysSocialMapper extends BaseMapper<SysSocial> {

    /**
     * 获取rank的最大值加1
     * @param userId
     * @param providerId
     * @return
     */
    @Select("select coalesce(max(`rank`) + 1, 1) as `rank` from social_UserConnection where userId = #{userId} and providerId = #{providerId}")
    int getRank(String userId, String providerId);


}
