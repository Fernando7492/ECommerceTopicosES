package com.topicos.storage.controllers.response;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Stock;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class StockResponse {

    private long id;
    private int quantity;
    private String code;

    private long productId;
    private long warehouseId;

    public StockResponse(Stock stock) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(stock, this);
    }
}
