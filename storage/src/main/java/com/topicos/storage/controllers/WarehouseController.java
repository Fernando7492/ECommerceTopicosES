package com.topicos.storage.controllers;

import com.topicos.storage.controllers.request.WarehouseRequest;
import com.topicos.storage.controllers.response.WarehouseResponse;
import com.topicos.storage.frontage.Storage;
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
public class WarehouseController {
    @Autowired
    private Storage storage;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/warehouse")
    Warehouse saveWarehouse(@Validated @RequestBody WarehouseRequest newObj) {
        return storage.saveWarehouse(newObj.convertToModel());
    }

    @GetMapping("/warehouse")
    List<WarehouseResponse> listWarehouse() {
        List<WarehouseResponse> response = new ArrayList<>();

        for (Warehouse warehouse : storage.listWarehouses()) {
            response.add(new WarehouseResponse(warehouse));
        }

        return response;
    }

    @GetMapping("/warehouse/{id}")
    WarehouseResponse listWarehouse(@PathVariable long id) {
        Optional<Warehouse> warehouse = storage.findWarehouse(id);
        return warehouse.map(WarehouseResponse::new).orElse(null);
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@PathVariable long id) {
        storage.deleteWarehouse(id);
    }

    @PutMapping("/warehouse/{id}")
    public Warehouse updateStock(@PathVariable long id, @RequestBody WarehouseRequest newObj) {
        return storage.updateWarehouse(id, newObj.convertToModel());
    }
}
