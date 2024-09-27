package com.topicos.storage.controllers.request;

import com.topicos.storage.config.SpringApplicationContext;
import com.topicos.storage.models.Address;
import com.topicos.storage.models.Warehouse;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class WarehouseRequest {
    private String name;
    private String description;
    private String code;

    // Address fields
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Warehouse convertToModel() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(this.name);
        warehouse.setDescription(this.description);
        warehouse.setCode(this.code);
        warehouse.setAddressId(null);

        return warehouse;
    }
}
