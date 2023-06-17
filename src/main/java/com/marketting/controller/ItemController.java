package com.marketting.controller;

import com.marketting.entity.Item;
import com.marketting.payload.ItemDTO;
import com.marketting.service.ItemService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemDTO itemDTO) {
        Item createdItem = itemService.createItem(itemDTO);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/nth_most_total_item")
    public ResponseEntity<String> getNthMostTotalItem(
            @RequestParam("item_by") String itemBy,
            @RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("n") int n) {
        String result = itemService.getNthMostTotalItem(itemBy, startDate, endDate, n);

        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
