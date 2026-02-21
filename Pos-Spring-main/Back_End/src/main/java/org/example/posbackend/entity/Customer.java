package org.example.posbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@ToString
public class Customer {
    @Id
    private Long cId;
    private String cName;
    private String cAddress;

    @OneToMany(mappedBy = "customer")
    private List<Oder> oderList;

}
