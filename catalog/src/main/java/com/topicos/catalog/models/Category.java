package com.topicos.catalog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("category")
public class Category {

    @Id
    private Long id;
    private String name;
    private String description;
    private String icon;

    @Column("parent_id")
    private Long parentId;
}
