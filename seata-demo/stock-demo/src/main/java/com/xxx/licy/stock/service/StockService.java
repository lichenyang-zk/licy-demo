package com.xxx.licy.stock.service;

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
     * 更新库存
     *
     * @param stock 库存数据
     * @return 服务响应
     */
    ServiceResp update(Stock stock);
}
