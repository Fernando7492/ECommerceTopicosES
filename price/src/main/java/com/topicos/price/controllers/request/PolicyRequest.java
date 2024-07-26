package com.topicos.price.controllers.request;

import org.modelmapper.ModelMapper;

import com.topicos.price.config.SpringApplicationContext;
import com.topicos.price.models.Policy;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PolicyRequest {
    private String name;
    private String description;
    private Double discount;

    public Policy convertModel(){
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Policy policy = modelMapper.map(this, Policy.class);
        return policy;
    }
}
