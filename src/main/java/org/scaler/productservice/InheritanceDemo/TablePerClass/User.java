package org.scaler.productservice.InheritanceDemo.TablePerClass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name = "TPC_User")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;
}
