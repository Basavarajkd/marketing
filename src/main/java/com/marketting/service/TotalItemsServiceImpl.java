package com.marketting.service;

import com.marketting.entity.TotalItems;
import com.marketting.payload.TotalItemsDTO;
import com.marketting.repositories.TotalItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TotalItemsServiceImpl implements TotalItemsService {

    private final TotalItemsRepository totalItemsRepository;

    @Autowired
    public TotalItemsServiceImpl(TotalItemsRepository totalItemsRepository) {
        this.totalItemsRepository = totalItemsRepository;
    }

    @Override
    public int getTotalItemsSold(String department, Date startDate, Date endDate) {
        List<TotalItems> totalItemsList = totalItemsRepository.findByStartDateBetweenAndDepartment(startDate, endDate, department);

        int totalSold = 0;
        for (TotalItems totalItems : totalItemsList) {
            totalSold += totalItems.getTotalSeats();
        }

        return totalSold;
    }

    @Override
    public TotalItemsDTO createTotalItems(TotalItemsDTO totalItemsDTO) {
        TotalItems totalItems = convertToEntity(totalItemsDTO);
        TotalItems savedTotalItems = totalItemsRepository.save(totalItems);
        return convertToDTO(savedTotalItems);
    }

    private TotalItems convertToEntity(TotalItemsDTO dto) {
        TotalItems totalItems = new TotalItems();
        totalItems.setStartDate(dto.getStartDate());
        totalItems.setEndDate(dto.getEndDate());
        totalItems.setDepartment(dto.getDepartment());
        totalItems.setTotalSeats(dto.getTotalSeats());
        return totalItems;
    }

    private TotalItemsDTO convertToDTO(TotalItems entity) {
        TotalItemsDTO dto = new TotalItemsDTO();
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setDepartment(entity.getDepartment());
        dto.setTotalSeats(entity.getTotalSeats());
        return dto;
    }
}
