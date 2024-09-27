package com.topicos.storage.controllers;

import com.topicos.storage.controllers.request.StockRequest;
import com.topicos.storage.controllers.response.StockResponse;
import com.topicos.storage.frontage.Storage;
import com.topicos.storage.models.Stock;
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
public class StockController {
    @Autowired
    private Storage storage;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/stock")
    public Mono<Object> saveStock(@Validated @RequestBody StockRequest newObj) {
        return storage.saveStock(newObj.convertToModel());
    }

    @GetMapping("/stock")
    public Flux<StockResponse> listStocks() {
        return storage.listStocks().map(StockResponse::new);
    }

    @GetMapping("/stock/{id}")
    public Mono<StockResponse> listStock(@PathVariable long id) {
        return storage.findStock(id).map(StockResponse::new);
    }

    @DeleteMapping("/stock/{id}")
    public Mono<ResponseEntity<Void>> deleteStock(@PathVariable long id) {
        return storage.deleteStock(id).then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));
    }

    @PutMapping("/stock/{id}")
    Mono<Stock> updateStock(@PathVariable long id, @RequestBody StockRequest newObj) {
        return storage.updateStock(id, newObj.convertToModel());
    }
}
