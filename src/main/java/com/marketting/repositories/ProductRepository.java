package com.marketting.repositories;

import com.marketting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDepartmentAndDateBetween(String department, Date startDate, Date endDate);

    List<String> findDistinctDepartment();

    double countByDepartment(String department);
}
