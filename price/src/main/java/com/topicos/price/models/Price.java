package com.topicos.price.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Price {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double value;
    private long productId;

    @ManyToOne
    private long policy;
}
