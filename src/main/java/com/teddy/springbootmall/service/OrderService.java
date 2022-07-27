package com.teddy.springbootmall.service;

import com.teddy.springbootmall.dto.CreateOrderRequest;
import com.teddy.springbootmall.dto.OrderQueryParams;
import com.teddy.springbootmall.model.Order;
import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
