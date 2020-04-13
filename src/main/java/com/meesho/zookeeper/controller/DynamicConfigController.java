package com.meesho.zookeeper.controller;

import com.meesho.zookeeper.service.DynamicConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/config")
public class DynamicConfigController {

    @Autowired
    private DynamicConfigService dynamicConfigService;

    @ResponseBody
    @RequestMapping(method= RequestMethod.GET, value="/get")
    public ResponseEntity<String> getConfig() {
        return new ResponseEntity<>(dynamicConfigService.getConfig(), HttpStatus.OK);
    }

}
