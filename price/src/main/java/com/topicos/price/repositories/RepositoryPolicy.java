package com.topicos.price.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topicos.price.models.Policy;

public interface RepositoryPolicy extends JpaRepository<Policy,String>{
    List<Policy> findByNameContainingIgnoreCase(String name);
    List<Policy> findByDescriptionContainingIgnoreCase(String description);
    List<Policy> findByDiscount(double discount);

    Policy updatePolicy(String id, Policy entity);
}
