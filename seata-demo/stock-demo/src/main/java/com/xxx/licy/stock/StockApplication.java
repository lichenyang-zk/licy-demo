package com.xxx.licy.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 库存服务启动类
 *
 * @author lichenyang
 * @since 2024/7/29 16:25
 */
@SpringBootApplication
@MapperScan("com.xxx.licy.stock.mapper")
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
