package org.scaler.productservice.dtos;

import lombok.Data;
import org.scaler.productservice.Models.Category;

@Data
public class FakeStoreResponseDto {
    public long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
