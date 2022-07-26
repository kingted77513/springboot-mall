package com.teddy.springbootmall.dao;

import com.teddy.springbootmall.model.OrderItem;
import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, int totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
