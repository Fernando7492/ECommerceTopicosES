package com.topicos.price.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.topicos.price.create.interfaces.InterfaceCreatePrice;
import com.topicos.price.models.Price;
import com.topicos.price.repositories.RepositoryPrice;

@Service
public class CreatePrice implements InterfaceCreatePrice {

    @Autowired
    private RepositoryPrice repositoryPrice;

    @Override
    public Mono<Price> savePrice(Price entity) {
        return repositoryPrice.save(entity);  // Método reativo de salvar
    }

    @Override
    public Mono<Price> updatePrice(Long id, Price entity) {
        // Busca reativa e atualização usando flatMap para manipular o resultado reativo
        return findPrice(id).flatMap(price -> {
            price.setProductId(entity.getProductId());
            price.setPolicyId(entity.getPolicyId());  // Usando policyId em vez de Policy diretamente
            price.setValue(entity.getValue());
            return repositoryPrice.save(price);  // Salva a atualização reativamente
        });
    }

    @Override
    public Mono<Price> findPrice(Long id) {
        return repositoryPrice.findById(id);  // Busca de forma reativa
    }

    @Override
    public Mono<Void> deletePrice(Long id) {
        return repositoryPrice.deleteById(id);  // Deleção reativa por ID
    }

    @Override
    public Mono<Void> deletePrice(Price entity) {
        return repositoryPrice.delete(entity);  // Deleção reativa da entidade
    }

    @Override
    public Flux<Price> listPrices() {
        return repositoryPrice.findAll();  // Listagem de múltiplos preços de forma reativa
    }

}