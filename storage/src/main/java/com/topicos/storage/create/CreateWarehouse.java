package com.topicos.storage.create;

import com.topicos.storage.create.exception.DuplicateRecordException;
import com.topicos.storage.create.exception.RecordNotFoundException;
import com.topicos.storage.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.storage.models.Address;
import com.topicos.storage.models.Warehouse;
import com.topicos.storage.repository.WarehouseRepository;
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

    @Override
    public Warehouse updateWarehouse(Long id, Warehouse entity) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Warehouse not found"));

        warehouse.setName(entity.getName());
        warehouse.setDescription(entity.getDescription());
        warehouse.setCode(entity.getCode());

        if (warehouse.getAddress() != null) {
            Address existingAddress = warehouse.getAddress();
            Address newAddress = entity.getAddress();

            existingAddress.setStreet(newAddress.getStreet());
            existingAddress.setNumber(newAddress.getNumber());
            existingAddress.setNeighborhood(newAddress.getNeighborhood());
            existingAddress.setCity(newAddress.getCity());
            existingAddress.setState(newAddress.getState());
            existingAddress.setCountry(newAddress.getCountry());
            existingAddress.setZipCode(newAddress.getZipCode());
        } else {
            warehouse.setAddress(entity.getAddress());
        }

        return warehouseRepository.save(warehouse);
    }
}
