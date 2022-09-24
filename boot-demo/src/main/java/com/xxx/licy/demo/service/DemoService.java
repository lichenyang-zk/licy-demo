package com.xxx.licy.demo.service;

import com.xxx.licy.demo.model.User;

import java.util.List;

/**
 * DemoService
 *
 * @author lichenyang
 * @version 1.0.0 2022/7/5 22:59
 */
public interface DemoService {

    /**
     * Hello
     *
     * @return Hello World！
     */
    String hello();

    /**
     * 获取学生列表
     *
     * @return 学生列表
     */
    List<User> getUsers();
}
