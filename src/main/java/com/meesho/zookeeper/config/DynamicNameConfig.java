package com.meesho.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource("classpath:application.properties")
@Data
@RefreshScope
public class DynamicNameConfig {
    private String myName;

    private String address;
}
