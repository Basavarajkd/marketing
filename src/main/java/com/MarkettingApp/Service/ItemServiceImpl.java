package com.MarkettingApp.Service;

import com.MarkettingApp.entity.Transaction;
import com.MarkettingApp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Integer getTotalItemsSold(Date startDate, Date endDate, String department) {
        List<Transaction> transactions = itemRepository.findBySoldDateBetweenAndDepartment(startDate, endDate, department);
        int totalItemsSold = 0;
        for (Transaction transaction : transactions) {
            totalItemsSold += transaction.getQuantity();
        }
        return totalItemsSold;
    }

    @Override
    public String getNthMostSoldItem(String itemBy, Date startDate, Date endDate, Integer n) {
        List<Transaction> transactions = itemRepository.findBySoldDateBetween(startDate, endDate);
        if (itemBy.equals("quantity")) {
            transactions.sort(Comparator.comparingInt(Transaction::getQuantity).reversed());
        } else if (itemBy.equals("price")) {
            transactions.sort(Comparator.comparing(Transaction::getPrice).reversed());
        } else {
            throw new IllegalArgumentException("Invalid itemBy parameter.");
        }
        if (n <= 0 || n > transactions.size()) {
            throw new IllegalArgumentException("Invalid value for n.");
        }
        return transactions.get(n - 1).getProductName();
    }

    @Override
    public Map<String, BigDecimal> getPercentageOfDepartmentWiseSoldItems(Date startDate, Date endDate) {
        List<Transaction> transactions = itemRepository.findBySoldDateBetween(startDate, endDate);
        Map<String, Integer> departmentCountMap = new HashMap<>();
        int totalItems = transactions.size();

        for (Transaction transaction : transactions) {
            String department = transaction.getDepartment();
            departmentCountMap.put(department, departmentCountMap.getOrDefault(department, 0) + 1);
        }

        Map<String, BigDecimal> departmentPercentageMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : departmentCountMap.entrySet()) {
            String department = entry.getKey();
            int count = entry.getValue();
            BigDecimal percentage = BigDecimal.valueOf(count)
                    .multiply(BigDecimal.valueOf(100))
                    .divide(BigDecimal.valueOf(totalItems), 2, RoundingMode.HALF_UP);
            departmentPercentageMap.put(department, percentage);
        }

        return departmentPercentageMap;
    }

    @Override
    public List<Double> getMonthlySales(String product, int year) {
        List<Double> monthlySales = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            Date startDate = getFirstDayOfMonth(year, month);
            Date endDate = getLastDayOfMonth(year, month);
            List<Transaction> transactions = itemRepository.findBySoldDateBetweenAndProductName(startDate, endDate, product);

            BigDecimal totalSales = BigDecimal.ZERO;
            for (Transaction transaction : transactions) {
                BigDecimal price = transaction.getPrice();
                BigDecimal quantity = BigDecimal.valueOf(transaction.getQuantity());
                BigDecimal sales = price.multiply(quantity);
                totalSales = totalSales.add(sales);
            }
            monthlySales.add(totalSales.doubleValue());
        }
        return monthlySales;
    }





    private Date getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    private Date getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
}
