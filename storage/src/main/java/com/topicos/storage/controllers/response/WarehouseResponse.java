package com.topicos.storage.controllers.response;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class WarehouseResponse {

    private long id;
    private String name;
    private String description;
    private String code;

    public WarehouseResponse(Warehouse warehouse) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(warehouse, this);
    }
}
