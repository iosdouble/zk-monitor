package com.zk.monitor.modules.security.properties;

import lombok.Data;

@Data
public class GithubProperties extends SocialProperties {

    private String providerId = "github";
}
