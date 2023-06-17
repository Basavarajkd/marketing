package com.marketting.service;

import com.marketting.entity.Item;
import com.marketting.payload.ItemDTO;

import java.time.LocalDate;

public interface ItemService {
    String getNthMostTotalItem(String itemBy, LocalDate startDate, LocalDate endDate, int n);
    Item createItem(ItemDTO itemDTO);
}
