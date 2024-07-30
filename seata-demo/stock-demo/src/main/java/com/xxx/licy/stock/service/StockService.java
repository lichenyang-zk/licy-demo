package com.xxx.licy.stock.service;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.stock.model.Stock;

/**
 * 库存服务接口
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
public interface StockService {

    /**
     * 根据productId查询库存
     *
     * @param productId 产品ID
     * @return 库存信息
     */
    QueryReap<Stock> getByProductId(Integer productId);

    /**
     * 更新库存
     *
     * @param stock 库存数据
     * @return 服务响应
     */
    ServiceResp update(Stock stock);
}
