package com.xxx.licy.demo.service.impl;

import com.xxx.licy.demo.model.User;
import com.xxx.licy.demo.service.DemoService;
import com.xxx.licy.demo.util.DemoUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> getUsers() {
        return DemoUtils.createUsers(10);
    }
}
