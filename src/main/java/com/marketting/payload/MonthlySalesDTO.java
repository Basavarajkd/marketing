package com.marketting.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySalesDTO {
    @NotBlank(message = "Product must not be blank")
    private String product;

    @Positive(message = "Year must be a positive number")
    private int year;

}

