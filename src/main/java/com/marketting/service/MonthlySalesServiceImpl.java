package com.marketting.service;

import com.marketting.entity.MonthlySales;
import com.marketting.repositories.MonthlySalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthlySalesServiceImpl implements MonthlySalesService {
    private final MonthlySalesRepository monthlySalesRepository;

    @Autowired
    public MonthlySalesServiceImpl(MonthlySalesRepository monthlySalesRepository) {
        this.monthlySalesRepository = monthlySalesRepository;
    }

    @Override
    public double[] getMonthlySalesByProductAndYear(String product, int year) {
        MonthlySales monthlySales = monthlySalesRepository.findByProductAndYear(product, year);
        if (monthlySales != null) {
            return monthlySales.getSales();
        }
        return new double[0]; // Return an empty array if no sales data found
    }
}

