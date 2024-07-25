package com.topicos.stock.repository;

import com.topicos.stock.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse findByNameIgnoreCase(String name);
    Warehouse findByAddress_cityIgnoreCase(String number);
    Warehouse findByAddress_stateIgnoreCase(String name);
    Warehouse findByAddress_countryIgnoreCase(String name);
    Warehouse findByAddress_zipCodeIgnoreCase(String name);
}
