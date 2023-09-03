package com.xxx.licy.controller;

import com.xxx.licy.controller.service.CloudDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * CloudDemo接口管理
 *
 * @author lichenyang
 * @since 2023/9/3 16:20
 */
@RestController
public class CloudDemoController {

    @Resource
    private CloudDemoService cloudDemoService;

    @GetMapping("/hello")
    public String hello() {
        return cloudDemoService.hello();
    }
}
