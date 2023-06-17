package com.marketting.service;

import com.marketting.entity.Item;
import com.marketting.payload.ItemDTO;
import com.marketting.repositories.ItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public Item createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setQuantity(itemDTO.getQuantity());
        item.setPrice(itemDTO.getPrice());
        item.setSoldDate(itemDTO.getSoldDate());

        return itemRepository.save(item);
    }

    @Override
    public String getNthMostTotalItem(String itemBy, LocalDate startDate, LocalDate endDate, int n) {
        Sort sortBy = null;
        if ("quantity".equals(itemBy)) {
            sortBy = Sort.by(Sort.Direction.DESC, "quantity");
        } else if ("price".equals(itemBy)) {
            sortBy = Sort.by(Sort.Direction.DESC, "price");
        }

        List<Item> items = itemRepository.findBySoldDateBetween(startDate, endDate, sortBy);

        if (n <= items.size()) {
            Item item = items.get(n - 1);
            return item.getName();
        }

        return null; // Or handle the case when n exceeds the available items


    }
}
