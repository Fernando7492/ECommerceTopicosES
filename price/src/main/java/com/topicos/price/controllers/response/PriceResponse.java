package com.topicos.price.controllers.response;

import org.modelmapper.ModelMapper;

import com.topicos.price.config.SpringApplicationContext;
import com.topicos.price.models.Price;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PriceResponse {
    private long id;
    private double value;
    private Long productId;
    private Long policyId;

    public PriceResponse(Price price) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(price, this);
    }
}
