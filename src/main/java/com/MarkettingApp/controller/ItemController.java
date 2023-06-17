package com.MarkettingApp.controller;

import com.MarkettingApp.Service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    // Constructor injection
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/total_items")
    public Integer getTotalItemsSold(
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String department) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedStartDate = formatter.parse(startDate);
            Date parsedEndDate = formatter.parse(endDate);
            // Use the parsedStartDate and parsedEndDate in your logic
        } catch (ParseException e) {
            // Handle the exception appropriately
        }
        return null;
    }

    @GetMapping("/nth_most_total_item")
    public String getNthMostSoldItem(
            @RequestParam("item_by") String itemBy,
            @RequestParam("start_date") Date startDate,
            @RequestParam("end_date") Date endDate,
            @RequestParam("n") Integer n) {
        return itemService.getNthMostSoldItem(itemBy, startDate, endDate, n);
    }

    @GetMapping("/percentage_of_department_wise_sold_items")
    public Map<String, BigDecimal> getPercentageOfDepartmentWiseSoldItems(
            @RequestParam("start_date") Date startDate,
            @RequestParam("end_date") Date endDate) {
        return itemService.getPercentageOfDepartmentWiseSoldItems(startDate, endDate);
    }

    @GetMapping("/monthly_sales")
    public List<Double> getMonthlySales(
            @RequestParam("product") String product,
            @RequestParam("year") int year) {
        return itemService.getMonthlySales(product, year);
    }
}

