package com.MarkettingApp.repository;

import com.MarkettingApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findBySoldDateBetweenAndDepartment(Date startDate, Date endDate, String department);

    List<Transaction> findBySoldDateBetween(Date startDate, Date endDate);

    List<Transaction> findBySoldDateBetweenAndProductName(Date startDate, Date endDate, String productName);
}
