package com.topicos.storage.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("warehouse")
public class Warehouse {
    @Id
    private Long id;
    private String name;
    private String description;
    private String code;

    private Long addressId;
}
