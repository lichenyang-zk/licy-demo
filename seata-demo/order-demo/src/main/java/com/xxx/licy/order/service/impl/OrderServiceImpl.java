package com.xxx.licy.order.service.impl;

import com.xxx.licy.common.constant.RespStatus;
import com.xxx.licy.common.exception.BusinessException;
import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.mapper.OrderMapper;
import com.xxx.licy.order.model.Order;
import com.xxx.licy.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单服务接口实现类
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public QueryReap<Order> getList() {
        return new QueryReap<>(orderMapper.getList());
    }

    @Override
    public ServiceResp insert(Order order) {
        int result = orderMapper.insertSelective(order);
        if (result <= 0) {
            throw new BusinessException(RespStatus.FAILED);
        }
        return new ServiceResp();
    }

    @Override
    public ServiceResp update(Order order) {
        int result = orderMapper.updateByPrimaryKeySelective(order);
        if (result < 0) {
            throw new BusinessException(RespStatus.FAILED);
        }
        return new ServiceResp();
    }
}
