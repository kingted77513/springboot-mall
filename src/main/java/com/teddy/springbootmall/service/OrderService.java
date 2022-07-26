package com.teddy.springbootmall.service;

import com.teddy.springbootmall.dto.CreateOrderRequest;
import com.teddy.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
