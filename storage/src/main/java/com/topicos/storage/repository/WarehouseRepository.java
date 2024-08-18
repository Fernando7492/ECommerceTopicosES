package com.topicos.storage.repository;

import com.topicos.storage.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse findByNameIgnoreCase(String name);

    Warehouse findByCodeIgnoreCase(String code);

    List<Warehouse> findByAddress_cityIgnoreCase(String number);

    List<Warehouse> findByAddress_stateIgnoreCase(String name);

    List<Warehouse> findByAddress_countryIgnoreCase(String name);

    List<Warehouse> findByAddress_zipCodeIgnoreCase(String name);
}
