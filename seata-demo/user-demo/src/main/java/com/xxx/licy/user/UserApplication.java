package com.xxx.licy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户服务启动类
 *
 * @author lichenyang
 * @since 2024/7/29 17:46
 */
@SpringBootApplication
@ComponentScan("com.xxx.licy.*.client")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
