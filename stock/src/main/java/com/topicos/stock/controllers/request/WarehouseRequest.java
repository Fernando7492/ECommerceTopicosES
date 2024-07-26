package com.topicos.stock.controllers.request;

import com.topicos.stock.config.SpringApplicationContext;
import com.topicos.stock.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class WarehouseRequest {
    private Long id;
    private String name;
    private String description;
    private String code;

    // TODO: tratar a parte de endereço

    public Warehouse convertToModel(){
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Warehouse.class);
    }

}
