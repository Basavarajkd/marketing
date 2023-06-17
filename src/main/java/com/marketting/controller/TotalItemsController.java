package com.marketting.controller;

import com.marketting.payload.TotalItemsDTO;
import com.marketting.service.TotalItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api/total_items")
public class TotalItemsController {

    private final TotalItemsService totalItemsService;

    @Autowired
    public TotalItemsController(TotalItemsService totalItemsService) {
        this.totalItemsService = totalItemsService;
    }

    @GetMapping("/sold")
    public ResponseEntity<Integer> getTotalItemsSold(
            @RequestParam("department") String department,
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        int totalSold = totalItemsService.getTotalItemsSold(department, startDate, endDate);
        return ResponseEntity.ok(totalSold);
    }


    @PostMapping
    public ResponseEntity<TotalItemsDTO> createTotalItems(@RequestBody @Valid TotalItemsDTO totalItemsDTO) {
        TotalItemsDTO createdTotalItems = totalItemsService.createTotalItems(totalItemsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTotalItems);
    }
}
