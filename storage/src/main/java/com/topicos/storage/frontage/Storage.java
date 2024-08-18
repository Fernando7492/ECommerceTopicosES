package com.topicos.storage.frontage;

import com.topicos.storage.create.interfaces.InterfaceCreateStock;
import com.topicos.storage.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.storage.models.Stock;
import com.topicos.storage.models.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Storage {

    @Autowired
    private InterfaceCreateStock interfaceCreateStock;

    @Autowired
    private InterfaceCreateWarehouse interfaceCreateWarehouse;

    // ========================== STOCK ========================== //

    public Stock saveStock(Stock entity) {
        return interfaceCreateStock.saveStock(entity);
    }

    public List<Stock> listStocks() {
        return interfaceCreateStock.listStocks();
    }

    public List<Stock> listStocksByWarehouse(String name) {
        return interfaceCreateStock.listStocksByWarehouse(name);
    }

    public Optional<Stock> findStock(Long id) {
        return interfaceCreateStock.findByStockId(id);
    }

    public Stock updateStock(Long id, Stock entity) {
        return interfaceCreateStock.updateStock(id, entity);
    }

    public void deleteStock(Long id) {
        interfaceCreateStock.deleteStock(id);
    }

    // ========================== WAREHOUSE ========================== //

    public Warehouse saveWarehouse(Warehouse entity) {
        return interfaceCreateWarehouse.saveWarehouse(entity);
    }

    public List<Warehouse> listWarehouses() {
        return interfaceCreateWarehouse.listWarehouses();
    }

    public Optional<Warehouse> findWarehouse(Long id) {
        return interfaceCreateWarehouse.findByWarehouseId(id);
    }

    public Warehouse updateWarehouse(Long id, Warehouse entity) {
        return interfaceCreateWarehouse.updateWarehouse(id, entity);
    }

    public void deleteWarehouse(Long id) {
        interfaceCreateWarehouse.deleteWarehouse(id);
    }
}
