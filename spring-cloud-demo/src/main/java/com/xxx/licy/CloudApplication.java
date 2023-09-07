package com.xxx.licy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud服务启动类
 *
 * @author lichenyang
 * @since 2023/9/3 16:10
 */
@SpringCloudApplication
@EnableDiscoveryClient
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }
}
