package com.topicos.stock.controllers.request;

import com.topicos.stock.config.SpringApplicationContext;
import com.topicos.stock.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class WarehouseRequest {
    private String name;
    private String description;
    private String code;

    // tratar a parte de endereço

    public Warehouse convertToModel(){
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Warehouse warehouse = modelMapper.map(this, Warehouse.class);
        return warehouse;
    }

}
