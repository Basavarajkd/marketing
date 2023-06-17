package com.marketting.repositories;

import com.marketting.entity.TotalItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TotalItemsRepository extends JpaRepository<TotalItems, Long> {

    List<TotalItems> findByStartDateBetweenAndDepartment(Date startDate, Date endDate, String department);

}
