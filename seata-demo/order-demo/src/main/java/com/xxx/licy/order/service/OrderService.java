package com.xxx.licy.order.service;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.model.Order;

/**
 * 订单服务接口
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
public interface OrderService {

    /**
     * 查询订单列表
     *
     * @return 订单列表
     */
    QueryReap<Order> getList();

    /**
     * 新增订单
     *
     * @param order 订单数据
     * @return 服务响应
     */
    ServiceResp insert(Order order);

    /**
     * 更新订单
     *
     * @param order 订单实体
     * @return 服务响应
     */
    ServiceResp update(Order order);
}
