package org.scaler.productservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{

    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;
}