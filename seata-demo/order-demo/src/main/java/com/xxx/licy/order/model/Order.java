package com.xxx.licy.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单
 *
 * @author lichenyang
 * @since 2024/7/29 16:02
 */
@Data
@NoArgsConstructor
public class Order {

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

    public Order(Integer productId, Integer count) {
        this.productId = productId;
        this.count = count;
    }
}