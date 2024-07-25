package com.topicos.price.create.interfaces;

import java.util.List;

import com.topicos.price.models.Price;

public interface InterfaceCreatePrice {
    Price savePrice(Price entity);
    Price updatePrice(Long id, Price entity);
    Price findPrice(Long id);
    void deletePrice(Long id);
    void deletePrice(Price entity);
    List<Price> listPrices();
}
