package org.example.posbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Oder {
    @Id
    private String oderId;

  @OneToMany(mappedBy="oder", cascade = CascadeType.ALL)
    private List<OderDeatiles>oderDeatilesLists;

  @ManyToOne
  Customer customer;

    private String date;


}
