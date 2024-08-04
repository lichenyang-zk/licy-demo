package com.xxx.licy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * 启动类
 * 开启注解权限控制：
 * securedEnabled = true
 * prePostEnabled = true
 */
@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
