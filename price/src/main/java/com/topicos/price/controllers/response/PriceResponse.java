package com.topicos.price.controllers.response;

import com.topicos.price.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponse {

    private long id;
    private double value;
    private Long productId;
    private Long policyId;

    public PriceResponse(Price price) {
        this.id = price.getId();
        this.value = price.getValue();
        this.productId = price.getProductId();
        this.policyId = price.getPolicyId(); 
    }
}
