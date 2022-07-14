package com.teddy.springbootmall.service;

import com.teddy.springbootmall.dto.ProductQueryParams;
import com.teddy.springbootmall.dto.ProductRequest;
import com.teddy.springbootmall.model.Product;
import java.util.List;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProducts(ProductQueryParams productQueryParams);
}
