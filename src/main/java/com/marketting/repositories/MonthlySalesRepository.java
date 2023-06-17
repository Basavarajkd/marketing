package com.marketting.repositories;

import com.marketting.entity.MonthlySales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlySalesRepository extends JpaRepository<MonthlySales, Long> {

    MonthlySales findByProductAndYear(String product, int year);
}

