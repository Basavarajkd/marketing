package com.marketting.controller;

import com.marketting.service.MonthlySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MonthlySalesController {
    private final MonthlySalesService monthlySalesService;

    @Autowired
    public MonthlySalesController(MonthlySalesService monthlySalesService) {
        this.monthlySalesService = monthlySalesService;
    }

    @GetMapping("/monthly_sales")
    public double[] getMonthlySales(@RequestParam("product") String product, @RequestParam("year") int year) {
        return monthlySalesService.getMonthlySalesByProductAndYear(product, year);
    }
}
