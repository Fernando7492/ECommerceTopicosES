package com.topicos.stock.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    private int quantity;
    private String code;

    @ManyToOne
    private Warehouse warehouse;
}
