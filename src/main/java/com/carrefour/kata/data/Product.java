package com.carrefour.kata.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CustomerDelivery> customerDeliveries;
}
