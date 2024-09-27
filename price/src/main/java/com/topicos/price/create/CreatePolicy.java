package com.topicos.price.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.topicos.price.create.exception.DuplicatedRegisterException;
import com.topicos.price.create.interfaces.InterfaceCreatePolicy;
import com.topicos.price.models.Policy;
import com.topicos.price.repositories.RepositoryPolicy;

@Service
public class CreatePolicy implements InterfaceCreatePolicy {

    @Autowired
    private RepositoryPolicy repositoryPolicy;

    @Override
    public Mono<Policy> savePolicy(Policy entity) {
        // Usa reatividade para verificar se o nome já existe
        return repositoryPolicy.findByNameContainingIgnoreCase(entity.getName())
            .hasElements() // Verifica se já existe algum registro
            .flatMap(exists -> {
                if (exists) {
                    return Mono.error(new DuplicatedRegisterException("A política [" + entity.getName() + "] já se encontra cadastrada no sistema."));
                } else {
                    return repositoryPolicy.save(entity); // Salva a entidade
                }
            });
    }

    @Override
    public Mono<Policy> updatePolicy(Long id, Policy entity) {
        // Encontra a política e atualiza-a de forma reativa
        return findPolicy(id).flatMap(policy -> {
            policy.setName(entity.getName());
            policy.setDescription(entity.getDescription());
            policy.setDiscount(entity.getDiscount());
            return repositoryPolicy.save(policy); // Salva as alterações
        });
    }

    @Override
    public Mono<Policy> findPolicy(Long id) {
        return repositoryPolicy.findById(id); // Operação reativa
    }

    @Override
    public Mono<Void> deletePolicy(Long id) {
        return repositoryPolicy.deleteById(id); // Operação reativa para deletar pelo ID
    }

    @Override
    public Mono<Void> deletePolicy(Policy entity) {
        return repositoryPolicy.delete(entity); // Operação reativa para deletar a entidade
    }

    @Override
    public Flux<Policy> listPolicies() {
        return repositoryPolicy.findAll(); // Retorna todos os registros de forma reativa
    }

}