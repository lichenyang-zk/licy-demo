package com.xxx.licy.demo.service.impl;

import com.xxx.licy.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * DemoServiceImpl
 *
 * @author lichenyang
 * @version 1.0.0 2022/7/5 23:00
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello() {
        return "Hello World";
    }
}
