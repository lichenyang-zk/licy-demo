package com.xxx.licy.demo.controller;

import com.xxx.licy.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DemoController
 *
 * @author lichenyang
 * @version 1.0.0 2022/7/5 22:58
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/hello")
    public String hello() {
        return demoService.hello();
    }
}
