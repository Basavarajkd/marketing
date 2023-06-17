package com.marketting.service;

import com.marketting.payload.TotalItemsDTO;

import java.util.Date;

public interface TotalItemsService {
    int getTotalItemsSold(String department, Date startDate, Date endDate);

    TotalItemsDTO createTotalItems(TotalItemsDTO totalItemsDTO);
}
