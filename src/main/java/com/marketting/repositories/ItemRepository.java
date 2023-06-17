package com.marketting.repositories;

import com.marketting.entity.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySoldDateBetween(LocalDate startDate, LocalDate endDate, Sort sort);
}
