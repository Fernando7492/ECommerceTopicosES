package com.topicos.price.create.interfaces;

import java.util.List;
import java.util.Optional;

import com.topicos.price.models.Policy;

public interface InterfaceCreatePolicy {
    Policy savePolicy(Policy entity);
    Policy updatePolicy(String id, Policy entity);
    Optional<Policy> findPolicy(String id);
    void deletePolicy(String id);
    void deletePolicy(Policy entity);
    List<Policy> listPolicies();
}