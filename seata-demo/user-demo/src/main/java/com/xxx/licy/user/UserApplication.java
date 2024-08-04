package com.xxx.licy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户服务启动类
 *
 * @author lichenyang
 * @since 2023/11/22 21:15
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.xxx.licy.userdb.api.client")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
