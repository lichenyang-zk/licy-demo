package com.xxx.licy.stock.service.impl;

import com.xxx.licy.common.constant.RespStatus;
import com.xxx.licy.common.exception.BusinessException;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.stock.mapper.StockMapper;
import com.xxx.licy.stock.model.Stock;
import com.xxx.licy.stock.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lichenyang
 * @since 2024/7/29 16:21
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public ServiceResp update(Stock stock) {
        int result = stockMapper.updateByPrimaryKeySelective(stock);
        if (result < 0) {
            throw new BusinessException(RespStatus.FAILED);
        }
        return new ServiceResp();
    }
}
