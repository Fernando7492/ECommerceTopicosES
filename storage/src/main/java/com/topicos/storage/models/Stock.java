package com.topicos.storage.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("stock")
public class Stock {
    @Id
    private Long id;
    private int quantity;
    private String code;

    private Long productId;
    private Long warehouseId;
}
