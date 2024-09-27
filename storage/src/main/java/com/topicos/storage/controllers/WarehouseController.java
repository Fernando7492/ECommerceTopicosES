package com.topicos.storage.controllers;

import com.topicos.storage.controllers.request.WarehouseRequest;
import com.topicos.storage.controllers.response.WarehouseResponse;
import com.topicos.storage.frontage.Storage;
import com.topicos.storage.models.Warehouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/storage")
public class WarehouseController {
    @Autowired
    private Storage storage;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/warehouse")
    Mono<Object> saveWarehouse(@Validated @RequestBody WarehouseRequest newObj) {
        return storage.saveWarehouse(newObj.convertToModel());
    }

    @GetMapping("/warehouse")
    Flux<WarehouseResponse> listWarehouse() {
        return storage.listWarehouses().map(WarehouseResponse::new);
    }

    @GetMapping("/warehouse/{id}")
    Mono<WarehouseResponse> listWarehouse(@PathVariable long id) {
        return storage.findWarehouse(id).map(WarehouseResponse::new);
    }

    @DeleteMapping("/warehouse/{id}")
    public Mono<ResponseEntity<Void>> deleteWarehouse(@PathVariable long id) {
        return storage.deleteWarehouse(id).then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));
    }

    @PutMapping("/warehouse/{id}")
    public Mono<Warehouse> updateStock(@PathVariable long id, @RequestBody WarehouseRequest newObj) {
        return storage.updateWarehouse(id, newObj.convertToModel());
    }
}
