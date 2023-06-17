package com.marketting.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ItemDTO {
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private LocalDate soldDate;

}

