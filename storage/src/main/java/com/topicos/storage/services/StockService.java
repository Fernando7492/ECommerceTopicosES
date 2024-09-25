package com.topicos.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.storage.models.Stock;
import com.topicos.storage.models.Warehouse;
import com.topicos.storage.repository.StockRepository;
import com.topicos.storage.repository.WarehouseRepository;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public void createStocksForNewProduct(long productId) {
        List<Warehouse> warehouses = warehouseRepository.findAll();

        for (Warehouse warehouse : warehouses) {
            Stock stock = new Stock();
            stock.setQuantity(0);
            stock.setCode(Long.toString(productId));
            stock.setProductId(productId);
            stock.setWarehouse(warehouse);

            stockRepository.save(stock);
        }
    }
}
