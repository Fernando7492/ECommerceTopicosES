package com.topicos.price.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("policy")  // Define a tabela correspondente no banco de dados
public class Policy {
    @Id  // Define a chave primária
    private Long id;  // O ID será gerado pelo banco (R2DBC usa @Id sem geração automática como no JPA)

    private String name;
    private String description;
    private Double discount;
}