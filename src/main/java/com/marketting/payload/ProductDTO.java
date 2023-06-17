package com.marketting.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String department;
    private boolean isSold;

    public void setPercentage(double v) {
    }

    public void setSoldQuantity(int i) {
    }
}
