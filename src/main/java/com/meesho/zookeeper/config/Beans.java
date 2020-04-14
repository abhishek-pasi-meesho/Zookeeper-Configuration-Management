package com.meesho.zookeeper.config;

import com.meesho.zookeeper.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.meesho.zookeeper.constant.Constants.*;

@Configuration

public class Beans {

    @Autowired
    private DynamicConfig dynamicConfig;

    @Bean(GET_USER_DETAILS)
    @RefreshScope
    public UserDetails getDynamicUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName(dynamicConfig.getMyName());
        userDetails.setAddress(dynamicConfig.getAddress());
        return userDetails;
    }

    @Bean(GET_USER_DETAILS_HIERARCHICAL)
    @RefreshScope
    public UserDetails getDynamicUserDetailsFromBean() {
        UserDetails userDetailsBean = getDynamicUserDetails();
        UserDetails userDetails = new UserDetails();
        userDetails.setName("My name = " + userDetailsBean.getName());
        userDetails.setAddress("My address = " + userDetailsBean.getAddress());
        return userDetails;
    }
}
