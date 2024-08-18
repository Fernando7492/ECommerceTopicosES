package com.topicos.storage.controllers.response;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Address;
import org.modelmapper.ModelMapper;

public class AddressResponse {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public AddressResponse(Address obj) {
        if (obj == null) throw new IllegalArgumentException("Objeto nulo");
        else {
            ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
            modelMapper.map(obj, this);
        }
    }
}
