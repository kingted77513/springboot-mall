package com.teddy.springbootmall.service;

import com.teddy.springbootmall.dto.ProductRequest;
import com.teddy.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
