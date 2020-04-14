package com.meesho.zookeeper.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:application.properties")
@RefreshScope
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicConfig {
    private String myName;

    private String address;
}
