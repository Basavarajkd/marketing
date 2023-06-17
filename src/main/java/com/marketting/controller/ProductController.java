package com.marketting.controller;

import com.marketting.entity.SoldItemsPercentageRequest;
import com.marketting.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/percentage_of_department_wise_sold_items")
    public ResponseEntity<Map<String, Double>> getPercentageOfDepartmentWiseSoldItems(
            @RequestBody SoldItemsPercentageRequest request) {
        Map<String, Double> departmentPercentageMap =
                productService.getPercentageOfDepartmentWiseSoldItems(request.getStart_date(), request.getEnd_date());

        return ResponseEntity.ok(departmentPercentageMap);
    }
}
