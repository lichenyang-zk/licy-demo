package com.xxx.licy.user.service.impl;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.order.client.OrderClient;
import com.xxx.licy.order.model.Order;
import com.xxx.licy.stock.client.StockClient;
import com.xxx.licy.stock.model.Stock;
import com.xxx.licy.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务接口实现类
 *
 * @author lichenyang
 * @since 2024/7/29 17:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private OrderClient orderClient;
    @Resource
    private StockClient stockClient;

    @Override
    public ServiceResp buy() {
        int count = 1;
        // 新增订单
        Order order = new Order(1, count);
        orderClient.insert(order);
        // 查询库存
        QueryReap<Stock> stockResp = stockClient.getByProductId(1);
        Stock stock = stockResp.getResultObject();
        // 减库存
        int newCount = stock.getCount() - count;
        Stock updateStock = new Stock(1, newCount);
        stockClient.update(updateStock);
        return new ServiceResp();
    }
}
