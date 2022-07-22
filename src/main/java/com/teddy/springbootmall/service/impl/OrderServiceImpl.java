package com.teddy.springbootmall.service.impl;

import com.teddy.springbootmall.dao.OrderDao;
import com.teddy.springbootmall.dao.ProductDao;
import com.teddy.springbootmall.dto.BuyItem;
import com.teddy.springbootmall.dto.CreateOrderRequest;
import com.teddy.springbootmall.model.Product;
import com.teddy.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;
        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItem();

        return orderId;
    }
}
