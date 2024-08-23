package com.topicos.storage.controllers;

import com.topicos.storage.controllers.request.StockRequest;
import com.topicos.storage.controllers.response.StockResponse;
import com.topicos.storage.create.exception.RecordNotFoundException;
import com.topicos.storage.frontage.Storage;
import com.topicos.storage.models.Stock;
import com.topicos.storage.models.Warehouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/storage")
public class StockController {
    @Autowired
    private Storage storage;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/stock")
    public Stock saveStock(@Validated @RequestBody StockRequest newObj) {
        Warehouse warehouse = storage.findWarehouse(newObj.getWarehouse()).orElse(null);

        if (warehouse == null) {
            throw new RecordNotFoundException("Warehouse with id " + newObj.getWarehouse() + " not found");
        }

        Stock stock = newObj.convertToModel();
        stock.setWarehouse(warehouse);

        return storage.saveStock(stock);
    }

    @GetMapping("/stock")
    public List<StockResponse> listStocks() {
        List<StockResponse> response = new ArrayList<>();

        for (Stock stock : storage.listStocks()) {
            response.add(new StockResponse(stock));
        }

        return response;
    }

    @GetMapping("/stock/{id}")
    public StockResponse listStock(@PathVariable long id) {
        Optional<Stock> stock = storage.findStock(id);
        return stock.map(StockResponse::new).orElse(null);
    }

    @GetMapping("/stock/warehouse/{name}")
    public List<StockResponse> listStocksByWarehouse(@PathVariable String name) {
        List<StockResponse> response = new ArrayList<>();

        for (Stock stock : storage.listStocksByWarehouse(name)) {
            response.add(new StockResponse(stock));
        }

        return response;
    }

    @DeleteMapping("/stock/{id}")
    public void deleteStock(@PathVariable long id) {
        storage.deleteStock(id);
    }

    @PutMapping("/stock/{id}")
    Stock updateStock(@PathVariable long id, @RequestBody StockRequest newObj) {
        Warehouse warehouse = storage.findWarehouse(newObj.getWarehouse()).orElse(null);

        if (warehouse == null) {
            throw new RecordNotFoundException("Warehouse with id " + newObj.getWarehouse() + " not found");
        }

        Stock stock = newObj.convertToModel();
        stock.setWarehouse(warehouse);

        return storage.updateStock(id, stock);
    }
}
