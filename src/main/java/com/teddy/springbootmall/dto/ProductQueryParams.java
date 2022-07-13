package com.teddy.springbootmall.dto;

import com.teddy.springbootmall.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    private String search;
}
