package com.topicos.price.controllers.request;

import org.modelmapper.ModelMapper;

import com.topicos.price.config.SpringApplicationContext;
import com.topicos.price.models.Price;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRequest {

    private Double value;
    private Long productId;
    private Long policyId;

    public Price convertModel() {
        // ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        // return modelMapper.map(this, Price.class);

        Price price = new Price();
        price.setValue(this.value);
        price.setProductId(this.productId);
        price.setPolicy(null);

        return price;
    }
}
