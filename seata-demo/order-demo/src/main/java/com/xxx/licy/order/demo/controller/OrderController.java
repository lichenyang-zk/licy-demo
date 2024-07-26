package com.xxx.licy.order.demo.controller;

import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单管理
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/update")
    ServiceResp update() {
        return orderService.update();
    }
}
