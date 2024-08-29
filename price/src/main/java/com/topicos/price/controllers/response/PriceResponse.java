package com.topicos.price.controllers.response;

import com.topicos.price.config.SpringApplicationContext;
import com.topicos.price.models.Price;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class PriceResponse {
    private long id;
    private double value;
    private Long productId;
    private Long policyId;

    public PriceResponse(Price price) {
//        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
//        modelMapper.map(price, this);

        this.id = price.getId();
        this.value = price.getValue();
        this.productId = price.getProductId();
        if (price.getPolicy() != null) {
            this.policyId = price.getPolicy().getId();
        } else {
            this.policyId = null;
        }
    }
}
