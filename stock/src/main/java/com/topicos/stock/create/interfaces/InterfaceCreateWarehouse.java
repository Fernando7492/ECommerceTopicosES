package com.topicos.stock.create.interfaces;

import com.topicos.stock.models.Warehouse;

import java.util.List;

public interface InterfaceCreateWarehouse {

    Warehouse saveWarehouse(Warehouse entity);

    List<Warehouse> listWarehouses();

    void deleteWarehouse(Long id);

    void deleteWarehouse(Warehouse entity);

    Warehouse findCategory(Long id);

}
