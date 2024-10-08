package com.topicos.storage.controllers.request;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Stock;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class StockRequest {
    private int quantity;
    @NotBlank(message = "Code is mandatory")
    private String code;

    private Long productId;
    private long warehouse;

    public Stock convertToModel() {
        Stock stock = new Stock();
        stock.setQuantity(this.quantity);
        stock.setCode(this.code);
        stock.setProductId(this.productId);
        stock.setWarehouseId(this.warehouse);

        return stock;
    }
}
