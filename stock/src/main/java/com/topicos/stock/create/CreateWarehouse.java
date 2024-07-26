package com.topicos.stock.create;

import com.topicos.stock.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.stock.models.Warehouse;
import com.topicos.stock.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateWarehouse implements InterfaceCreateWarehouse {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse saveWarehouse(Warehouse entity) {
        String code = entity.getCode();

        if (warehouseRepository.findByCodeIgnoreCase(code) == null) {
            return warehouseRepository.save(entity);
        } else {
            throw new DuplicateRecordException("Warehouse with code " + code + " already exists");
        }
    }

    public List<Warehouse> listWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Warehouse> findByWarehouseId(Long id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);

        if (warehouse.isPresent()) {
            return warehouse;
        } else {
            throw new RecordNotFoundException("Warehouse with id " + id + " not found");
        }
    }

    public void deleteWarehouse(Long id) {
        if (warehouseRepository.findById(id).isPresent()) {
            warehouseRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Warehouse with id " + id + " not found");
        }
    }
}
