package com.xxx.licy.user.controller;

import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户服务管理
 *
 * @author lichenyang
 * @since 2024/7/29 17:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/buy")
    ServiceResp buy() {
        return userService.buy();
    }
}
