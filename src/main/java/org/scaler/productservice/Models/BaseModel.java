package org.scaler.productservice.Models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass//BaseModel will follow this type of inheritance
public abstract class BaseModel  implements Serializable {
    /*
    lets keep it PK
    to generate a auto increment value
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Date CreatedAt=Date.from(Instant.now());
    public Date UpdatedAt=Date.from(Instant.now());

}
