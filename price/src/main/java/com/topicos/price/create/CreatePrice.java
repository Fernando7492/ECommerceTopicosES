package com.topicos.price.create;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.price.create.exception.DuplicatedRegisterException;
import com.topicos.price.create.interfaces.InterfaceCreatePrice;
import com.topicos.price.models.Price;
import com.topicos.price.repositories.RepositoryPrice;

@Service
public class CreatePrice implements InterfaceCreatePrice {
    @Autowired
    private RepositoryPrice repositoryPrice;

    @Override
    public Price savePrice(Price entity) {
        if(repositoryPrice.findByProductId(entity.getProductId()) == null) {
            return repositoryPrice.save(entity);
        } else {
            throw new DuplicatedRegisterException("A política ["+ entity.getProductId() + "] já se encontra cadastrada no sistema.");
        }
    }

    @Override
    public Price updatePrice(Long id, Price entity) {
        Price price = findPrice(id);
        price.setProductId(entity.getProductId());
        price.setPolicy(entity.getPolicy());
        price.setValue(entity.getValue());
        return repositoryPrice.save(price);
    }

    @Override
    public Price findPrice(Long id) {
        return repositoryPrice.findById(id).get();
    }

    @Override
    public void deletePrice(Long id) {
        repositoryPrice.deleteById(id);
    }

    @Override
    public void deletePrice(Price entity) {
        repositoryPrice.delete(entity);
    }

    @Override
    public List<Price> listPrices() {
        return repositoryPrice.findAll();
    }

}
