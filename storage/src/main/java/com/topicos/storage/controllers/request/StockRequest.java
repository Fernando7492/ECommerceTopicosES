package com.topicos.storage.controllers.request;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Stock;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class StockRequest {
    private long productId;
    private int quantity;
    private String code;

    private long warehouseId;

    public Stock convertToModel() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Stock.class);
    }
}
