package com.xxx.licy.stock.model;

import lombok.Data;

/**
 * 库存
 *
 * @author lichenyang
 * @since 2024/7/29 16:02
 */
@Data
public class Stock {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品主键
     */
    private Integer productId;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品价格
     */
    private Long money;
}