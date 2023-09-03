package com.xxx.licy.controller.service.impl;

import com.xxx.licy.controller.service.CloudDemoService;
import org.springframework.stereotype.Service;

/**
 * @author lichenyang
 * @since 2023/9/3 16:23
 */
@Service
public class CloudDemoServiceImpl implements CloudDemoService {

    @Override
    public String hello() {
        return "Hello Spring Cloud Demo!";
    }
}
