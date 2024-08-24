package org.scaler.productservice.InheritanceDemo.SingleTable;


import jakarta.persistence.*;
import lombok.Data;
@Entity(name = "ST_User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data

//I want to new col which specifies the type
@DiscriminatorColumn(
        name = "User_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id//lets make Id as the primary key
    private long id;
    private String name;
    private String email;
    private String password;
}
