package com.xxx.licy.order.demo.service.impl;

import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.demo.service.OrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ServiceResp update() {
        return new ServiceResp();
    }
}
