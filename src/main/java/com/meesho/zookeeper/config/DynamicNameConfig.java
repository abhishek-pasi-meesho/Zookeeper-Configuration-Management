package com.meesho.zookeeper.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Data
@RefreshScope
public class DynamicNameConfig {
    @Value("${myName}")
    private String myName;

    @Value("${address}")
    private String address;
}
