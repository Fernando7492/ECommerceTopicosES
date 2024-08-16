package com.topicos.storage.controllers.request;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Address;
import com.topicos.storage.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class WarehouseRequest {
    private String name;
    private String description;
    private String code;

    public Warehouse convertToModel(){
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Warehouse obj = modelMapper.map(this, Warehouse.class);
        obj.setAddress(modelMapper.map(this, Address.class));
        return obj;
    }

}
