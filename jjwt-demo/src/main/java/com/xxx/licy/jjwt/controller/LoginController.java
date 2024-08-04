package com.xxx.licy.jjwt.controller;

import com.xxx.licy.jjwt.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username) {
        return loginService.login(username);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("token") String token) {
        return loginService.hello(token);
    }
}
