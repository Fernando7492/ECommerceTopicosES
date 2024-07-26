package com.topicos.stock.facade;

import com.topicos.stock.create.interfaces.InterfaceCreateStock;
import com.topicos.stock.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.stock.models.Stock;
import com.topicos.stock.models.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockFacade {

    @Autowired
    private InterfaceCreateStock interfaceCreateStock;

    @Autowired
    private InterfaceCreateWarehouse interfaceCreateWarehouse;

    public Stock saveStock(Stock entity) { return interfaceCreateStock.saveStock(entity); }
    public List<Stock> listStocks() { return interfaceCreateStock.listStocks(); }
    public List<Stock> listStocksByWarehouse(String name) { return interfaceCreateStock.listStocksByWarehouse(name); }
    public Optional<Stock> findStock (Long id) { return interfaceCreateStock.findByStockId(id); }
    public void deleteStock(Long id) { interfaceCreateStock.deleteStock(id); }

    // TODO: Implement update methods
    // TODO: talvez seja melhor criar uma fachada só pra Warehouse invés de ficar aqui no Stock
    public Warehouse saveWarehouse(Warehouse entity) { return interfaceCreateWarehouse.saveWarehouse(entity); }
    public List<Warehouse> listWarehouses() { return interfaceCreateWarehouse.listWarehouses(); }
    public Optional<Warehouse> findWarehouse(Long id) { return interfaceCreateWarehouse.findByWarehouseId(id); }
    public void deleteWarehouse(Long id) { interfaceCreateWarehouse.deleteWarehouse(id); }
}
