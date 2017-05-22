package com.fann.dao;

import com.fann.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> getByOrderNoUserId(@Param("orderNo")long orderNo,@Param("userId")Integer userId);

    List<OrderItem> getByOrderNo(@Param("orderNo")long orderNo);

    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);


}