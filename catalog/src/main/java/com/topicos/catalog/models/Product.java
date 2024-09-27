package com.topicos.catalog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("product")
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private String image;

    @Column("category_id")
    private long categoryId;
}
