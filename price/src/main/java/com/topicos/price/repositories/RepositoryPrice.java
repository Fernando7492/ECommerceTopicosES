package com.topicos.price.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topicos.price.models.Price;

public interface RepositoryPrice extends JpaRepository<Price,Long>{
    List<Price> findByProductId(Long productId);
    List<Price> findByPolicyId(Long policy);
}
