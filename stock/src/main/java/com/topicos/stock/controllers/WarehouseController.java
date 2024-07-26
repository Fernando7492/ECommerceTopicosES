package com.topicos.stock.controllers;

import com.topicos.stock.controllers.request.WarehouseRequest;
import com.topicos.stock.controllers.response.WarehouseResponse;
import com.topicos.stock.models.Stock;
import com.topicos.stock.models.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WarehouseController {
    @Autowired
    private Stock stock;

    @PostMapping("/warehouse")
    Warehouse saveWarehouse(@Validated @RequestBody WarehouseRequest newObj) {
        return stock.saveWarehouse(newObj.convertToModel());
    }

    @GetMapping("/warehouse")
    List<WarehouseResponse> listCategories() {
        List<WarehouseResponse> response = new ArrayList<WarehouseResponse>();
        for(Warehouse c : stock.listWarehouses())
            response.add(new WarehouseResponse(c));
        return response;
    }

    @GetMapping("/warehouse/{id}")
    WarehouseResponse listWarehouse(@PathVariable long id) {
        return new WarehouseResponse(stock.findWarehouse(id));
    }

    @DeleteMapping("/warehouse/{id}")
    ResponseEntity<?> deleteWarehouse(@PathVariable long id) {
        stock.deleteWarehouse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/warehouse/{id}")
    Warehouse updateWarehouse(@PathVariable long id, @Validated @RequestBody WarehouseRequest newObj) {
        return stock.updateWarehouse(id, newObj.convertToModel());
    }
}
