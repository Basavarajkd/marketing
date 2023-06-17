package com.MarkettingApp.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ItemService {
    Integer getTotalItemsSold(Date startDate, Date endDate, String department);
    String getNthMostSoldItem(String itemBy, Date startDate, Date endDate, Integer n);
    Map<String, BigDecimal> getPercentageOfDepartmentWiseSoldItems(Date startDate, Date endDate);
    List<Double> getMonthlySales(String product, int year);
}

