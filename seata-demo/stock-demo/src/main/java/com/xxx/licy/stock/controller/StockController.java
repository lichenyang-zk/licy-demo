package com.xxx.licy.stock.controller;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.stock.model.Stock;
import com.xxx.licy.stock.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 库存管理
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @GetMapping("/getByProductId")
    QueryReap<Stock> getByProductId(Integer productId) {
        return stockService.getByProductId(productId);
    }

    @PostMapping("/update")
    ServiceResp update(@RequestBody Stock stock) {
        return stockService.update(stock);
    }
}
