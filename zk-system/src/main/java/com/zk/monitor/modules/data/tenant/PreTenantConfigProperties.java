package com.zk.monitor.modules.data.tenant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zk.monitor.modules.data.tenant
 * create by admin nihui
 * create time 2020/11/12
 * version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "pre.tenant")
public class PreTenantConfigProperties {

    /**
     * 维护租户id
     */
    private String tenantIdColumn;

    /**
     * 多租户的数据表集合
     */
    private List<String> ignoreTenantTables = new ArrayList<>();
}
