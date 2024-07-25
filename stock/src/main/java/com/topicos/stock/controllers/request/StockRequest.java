package com.topicos.stock.controllers.request;

import com.topicos.stock.config.SpringApplicationContext;
import com.topicos.stock.models.Stock;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class StockRequest {
    private long id;
    private long productId;
    private int quantity;
    private String code;

    public Stock convertToModel() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Stock stock = modelMapper.map(this, Stock.class);
        return stock;
    }
}
