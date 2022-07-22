package com.teddy.springbootmall.dao;

public interface OrderDao {
    Integer createOrder(Integer userId, int totalAmount);
}
