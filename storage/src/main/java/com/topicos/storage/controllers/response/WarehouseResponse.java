package com.topicos.storage.controllers.response;

import com.topicos.storage.config.SpringApplicationContext;
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

    // Address fields
    private long addressId;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public WarehouseResponse(Warehouse warehouse) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(warehouse, this);

        if (warehouse.getAddress() != null) {
            modelMapper.map(warehouse.getAddress(), this);

            // This is necessary because modelMapper gets confused with fields with the same name
            this.id = warehouse.getId();
            this.addressId = warehouse.getAddress().getId();
            this.code = warehouse.getCode();
            this.zipCode = warehouse.getAddress().getZipCode();
        }
    }
}
