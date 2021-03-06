package com.teddy.springbootmall.controller;

import com.teddy.springbootmall.constant.ProductCategory;
import com.teddy.springbootmall.dto.ProductQueryParams;
import com.teddy.springbootmall.dto.ProductRequest;
import com.teddy.springbootmall.model.Product;
import com.teddy.springbootmall.service.ProductService;
import com.teddy.springbootmall.util.Page;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if (Objects.nonNull(product)){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductRequest productRequest){

        // ?????? prodcut ????????????
        Product product = productService.getProductById(productId);
        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // ?????????????????????
        productService.updateProduct(productId, productRequest);
        Product updatedProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
        // ???????????? Filter
        @RequestParam(required = false) ProductCategory category,
        @RequestParam(required = false) String search,

        // ?????? Sorting
        @RequestParam(defaultValue = "created_date") String orderBy,
        @RequestParam(defaultValue = "desc") String sort,

        // ?????? Pagination
        @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
        @RequestParam(defaultValue = "0") @Min(0) Integer offset){

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // ?????? product list
        List<Product> products = productService.getProducts(productQueryParams);

        // ?????? product ??????
        Integer total = productService.countProducts(productQueryParams);

        // ??????
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(products);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }
}
