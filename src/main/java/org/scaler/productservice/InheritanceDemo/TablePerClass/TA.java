package org.scaler.productservice.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;
@Entity(name = "TPC_TA")

@Data
public class TA extends User {
    private int noOfSession;
    private double rating;
}
