package com.marketting.service;

import com.marketting.entity.Product;
import com.marketting.payload.ProductDTO;
import com.marketting.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Map<String, Double> getPercentageOfDepartmentWiseSoldItems(Date startDate, Date endDate) {
        List<String> departments = productRepository.findDistinctDepartment();
        Map<String, Double> departmentPercentageMap = new HashMap<>();

        for (String department : departments) {
            List<Product> products = productRepository.findByDepartmentAndDateBetween(department, startDate, endDate);
            double soldCount = products.size();
            double totalCount = productRepository.countByDepartment(department);
            double percentage = (soldCount / totalCount) * 100;
            departmentPercentageMap.put(department, percentage);
        }

        return departmentPercentageMap;
    }
}
