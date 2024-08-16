package com.topicos.storage.create.interfaces;

import com.topicos.storage.models.Warehouse;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateWarehouse {

    Warehouse saveWarehouse(Warehouse entity);

    List<Warehouse> listWarehouses();

    Optional<Warehouse> findByWarehouseId(Long id);

    void deleteWarehouse(Long id);

    Warehouse updateWarehouse(Long id, Warehouse entity);
}
