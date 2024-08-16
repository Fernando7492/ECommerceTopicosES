package com.topicos.storage.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String code;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Address address;
}
