package com.xxx.licy.controller.service.impl;

import com.xxx.licy.controller.service.CloudDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lichenyang
 * @since 2023/9/3 16:23
 */
@Service
public class CloudDemoServiceImpl implements CloudDemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudDemoServiceImpl.class);

    @Override
    public String hello() {
        System.out.println("----------------------------------------------------");
        System.out.println("Hello Spring Cloud Demo!");
        return "Hello Spring Cloud Demo!";
    }
}
