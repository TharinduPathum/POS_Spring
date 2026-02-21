package org.example.posbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OderDeatiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderDeatiles_id;

    @ManyToOne
    private Oder oder;

    @ManyToOne
    Item item;

    private  String qty;

    private  String totlePrice;

}
