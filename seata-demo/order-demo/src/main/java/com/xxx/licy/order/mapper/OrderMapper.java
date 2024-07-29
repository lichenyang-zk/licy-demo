package com.xxx.licy.order.mapper;

import com.xxx.licy.common.model.QueryReap;
import com.xxx.licy.order.model.Order;

import java.util.List;

/**
 * $DESCRIPTION
 *
 * @author lichenyang
 * @since 2024/7/29 16:02
 */
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> getList();
}