package org.example.posbackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    private Long id;
    private String itemName;
    private String qty;
    private String price;

@OneToMany(mappedBy = "item",  cascade = CascadeType.ALL)
    List<OderDeatiles> oderDeatilesList;
}
