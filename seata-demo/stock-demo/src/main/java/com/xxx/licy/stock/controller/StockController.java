package com.xxx.licy.stock.controller;

import com.xxx.licy.common.model.ServiceResp;
import com.xxx.licy.stock.model.Stock;
import com.xxx.licy.stock.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 库存管理
 *
 * @author lichenyang
 * @since 2024/7/26 16:30
 */
@RestController
@RequestMapping("/order")
public class StockController {

    @Resource
    private StockService stockService;

    @PostMapping("/update")
    ServiceResp update(@RequestBody Stock stock) {
        return stockService.update(stock);
    }
}
