package com.topicos.storage.create;

import com.topicos.storage.create.exception.DuplicateRecordException;
import com.topicos.storage.create.exception.RecordNotFoundException;
import com.topicos.storage.create.interfaces.InterfaceCreateStock;
import com.topicos.storage.models.Stock;
import com.topicos.storage.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateStock implements InterfaceCreateStock {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock saveStock(Stock entity) {
        String code = entity.getCode();

        if (stockRepository.findByCodeIgnoreCase(code) == null) {
            return stockRepository.save(entity);
        } else {
            throw new DuplicateRecordException("Stock with code " + code + " already exists");
        }
    }

    @Override
    public List<Stock> listStocksByWarehouse(String name) {
        return stockRepository.findByWarehouse_nameIgnoreCase(name);
    }

    @Override
    public List<Stock> listStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> findByStockId(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);

        if (stock.isPresent()) {
            return stock;
        } else {
            throw new RecordNotFoundException("Stock with id " + id + " not found");
        }
    }

    @Override
    public void deleteStock(Long id) {
        Optional<Stock> stock = stockRepository.findById(id);

        if (stock.isPresent()) {
            stockRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Stock with id " + id + " not found");
        }
    }

    @Override
    public Stock updateStock(Long id, Stock entity) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Stock not found"));

        stock.setCode(entity.getCode());
        stock.setQuantity(entity.getQuantity());
        stock.setProductId(entity.getProductId());
        stock.setWarehouse(entity.getWarehouse());

        return stockRepository.save(stock);
    }
}
