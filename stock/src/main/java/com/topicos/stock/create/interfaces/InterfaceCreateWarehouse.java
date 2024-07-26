package com.topicos.stock.create.interfaces;

import com.topicos.stock.models.Warehouse;

import java.util.List;
import java.util.Optional;

public interface InterfaceCreateWarehouse {

    Warehouse saveWarehouse(Warehouse entity);

    List<Warehouse> listWarehouses();

    Optional<Warehouse> findByWarehouseId(Long id);

    void deleteWarehouse(Long id);

}
