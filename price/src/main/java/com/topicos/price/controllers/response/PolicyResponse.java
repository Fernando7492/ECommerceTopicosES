package com.topicos.price.controllers.response;

import org.modelmapper.ModelMapper;

import com.topicos.price.config.SpringApplicationContext;
import com.topicos.price.models.Policy;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PolicyResponse {
    private Long id;
    private String name;
    private String description;
    private double discount;

    public PolicyResponse(Policy policy) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(policy, this);
    }
}
