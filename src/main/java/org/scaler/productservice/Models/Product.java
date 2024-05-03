package org.scaler.productservice.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private double price;
    private String desc;
    private String image;
    private Category category;
}
