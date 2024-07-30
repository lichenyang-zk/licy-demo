package com.xxx.licy.stock.mapper;

import com.xxx.licy.stock.model.Stock;

/**
 * $DESCRIPTION
 *
 * @author lichenyang
 * @since 2024/7/29 16:02
 */
public interface StockMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    Stock getByProductId(Integer productId);
}