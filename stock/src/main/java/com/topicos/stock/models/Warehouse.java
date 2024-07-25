package com.topicos.stock.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "warehouse")
    private List<Stock> stocks;
}
