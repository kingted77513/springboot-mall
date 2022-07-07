package com.teddy.springbootmall.dao;

import com.teddy.springbootmall.model.Product;

public interface ProductDao  {
    Product getProductById(Integer productId);
}
