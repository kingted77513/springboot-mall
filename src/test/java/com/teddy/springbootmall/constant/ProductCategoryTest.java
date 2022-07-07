package com.teddy.springbootmall.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryTest {

    @Test
    void test() {
        ProductCategory productCategory = ProductCategory.FOOD;
        Assertions.assertEquals("FOOD", productCategory.name());
        Assertions.assertNotNull(ProductCategory.valueOf("CAR"));
    }

}