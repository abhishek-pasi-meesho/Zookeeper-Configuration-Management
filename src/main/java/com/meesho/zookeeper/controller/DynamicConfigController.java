package com.meesho.zookeeper.controller;

import com.meesho.zookeeper.model.UserDetails;
import com.meesho.zookeeper.service.DynamicConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user/details")
public class DynamicConfigController {

    @Autowired
    private DynamicConfigService dynamicConfigService;

    @ResponseBody
    @RequestMapping(method= RequestMethod.GET, value="/get")
    public ResponseEntity<UserDetails> getUserDetails() {
        return new ResponseEntity<>(dynamicConfigService.getUserDetails(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method= RequestMethod.GET, value="/beans/get")
    public ResponseEntity<UserDetails> getUserDetailsUsingBeans() {
        return new ResponseEntity<>(dynamicConfigService.getUserDetailsUsingBeans(), HttpStatus.OK);
    }

}
