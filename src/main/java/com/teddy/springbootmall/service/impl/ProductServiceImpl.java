package com.teddy.springbootmall.service.impl;

import com.teddy.springbootmall.dao.ProductDao;
import com.teddy.springbootmall.model.Product;
import com.teddy.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}