package com.meesho.zookeeper.service;

import com.meesho.zookeeper.config.DynamicConfig;
import com.meesho.zookeeper.model.UserDetails;
import com.meesho.zookeeper.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.meesho.zookeeper.constant.Constants.GET_USER_DETAILS;

@Service
public class DynamicConfigService {
    private final Logger logger = LoggerFactory.getLogger(DynamicConfigService.class);

    @Autowired
    private DynamicConfig dynamicConfig;

    public UserDetails getUserDetails() {
        UserDetails userDetails = new UserDetails();
        userDetails.setName(dynamicConfig.getMyName());
        userDetails.setAddress(dynamicConfig.getAddress());
        return userDetails;
    }

    public UserDetails getUserDetailsUsingBeans() {
        UserDetails userDetailsBean = (UserDetails) BeanUtil.getBean(GET_USER_DETAILS);
        UserDetails userDetails = new UserDetails(userDetailsBean.getName(), userDetailsBean.getAddress());
        return userDetails;
    }

}
