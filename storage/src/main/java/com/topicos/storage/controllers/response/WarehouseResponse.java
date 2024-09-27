package com.topicos.storage.controllers.response;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Address;
import com.topicos.storage.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class WarehouseResponse {
    private long id;
    private String name;
    private String description;
    private String code;

    private Address address;

    public WarehouseResponse(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.name = warehouse.getName();
        this.description = warehouse.getDescription();
        this.code = warehouse.getCode();
    }
}
