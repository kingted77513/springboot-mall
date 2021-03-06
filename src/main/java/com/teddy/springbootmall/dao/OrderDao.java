package com.teddy.springbootmall.dao;

import com.teddy.springbootmall.dto.OrderQueryParams;
import com.teddy.springbootmall.model.Order;
import com.teddy.springbootmall.model.OrderItem;
import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, int totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
