package com.topicos.price.controllers.request;

import org.modelmapper.ModelMapper;
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
        Price price = new Price();
        price.setValue(this.value);
        price.setProductId(this.productId);
        price.setPolicyId(this.policyId);  // Relacionamento manual com Policy usando policyId

        return price;
    }
}
