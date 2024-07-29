package com.xxx.licy.order.controller;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.model.Order;
import com.xxx.licy.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getList")
    QueryReap<Order> getList() {
        return orderService.getList();
    }

    @PostMapping("/insert")
    ServiceResp insert(@RequestBody Order order) {
        return orderService.insert(order);
    }

    @PostMapping("/update")
    ServiceResp update(@RequestBody Order order) {
        return orderService.update(order);
    }
}
