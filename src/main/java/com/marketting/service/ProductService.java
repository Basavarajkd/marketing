package com.marketting.service;

import com.marketting.payload.ProductDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProductService {
    Map<String, Double> getPercentageOfDepartmentWiseSoldItems(Date startDate, Date endDate);
}

