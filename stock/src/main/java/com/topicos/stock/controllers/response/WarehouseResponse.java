package com.topicos.stock.controllers.response;

import com.topicos.stock.config.SpringApplicationContext;
import com.topicos.stock.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class WarehouseResponse {

    private long id;
    private String name;
    private String description;
    private String code;

    // TODO: tratar a parte de endereço

    public WarehouseResponse(Warehouse warehouse) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(warehouse, this);
    }
}
