package com.topicos.storage.create;

import com.topicos.storage.create.exception.DuplicateRecordException;
import com.topicos.storage.create.exception.RecordNotFoundException;
import com.topicos.storage.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.storage.models.Warehouse;
import com.topicos.storage.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreateWarehouse implements InterfaceCreateWarehouse {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public Mono<Object> saveWarehouse(Warehouse entity) {
        String code = entity.getCode();

        return warehouseRepository.findByCodeIgnoreCase(code)
                .flatMap(existingWarehouse -> Mono.error(new DuplicateRecordException("Warehouse with code " + code + " already exists")))
                .switchIfEmpty(warehouseRepository.save(entity))
                .onErrorResume(Mono::error);
    }

    public Flux<Warehouse> listWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Mono<Warehouse> findByWarehouseId(Long id) {
        return warehouseRepository.findById(id)
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Warehouse with id " + id + " not found")))
                .onErrorResume(Mono::error);
    }

    public Mono<Void> deleteWarehouse(Long id) {
        return warehouseRepository.findById(id)
                .flatMap(warehouse -> warehouseRepository.deleteById(id))
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Warehouse with id " + id + " not found")))
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<Warehouse> updateWarehouse(Long id, Warehouse entity) {
        return warehouseRepository.findById(id)
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Warehouse not found")))
                .flatMap(existingWarehouse -> {
                    existingWarehouse.setName(entity.getName());
                    existingWarehouse.setDescription(entity.getDescription());
                    existingWarehouse.setCode(entity.getCode());
                    existingWarehouse.setAddressId(entity.getAddressId());

                    return warehouseRepository.save(existingWarehouse);
                })
                .onErrorResume(Mono::error);
    }
}
