package com.topicos.price.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("price")  // Define a tabela correspondente no banco de dados
public class Price {

    @Id
    private long id;  // O ID será gerado pelo banco (R2DBC usa @Id sem estratégia de geração como no JPA)

    private Double value;
    private Long productId;

    private Long policyId;  // Relacionamento gerenciado manualmente com o ID da Policy
}
