package com.meesho.zookeeper.service;

import com.meesho.zookeeper.config.DynamicNameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicConfigService {
    private final Logger logger = LoggerFactory.getLogger(DynamicConfigService.class);

    @Autowired
    private DynamicNameConfig dynamicNameConfig;

    public String getConfig() {
        return "My name = " + dynamicNameConfig.getMyName();
    }

}
