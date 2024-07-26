package com.topicos.stock.controllers;

import com.topicos.stock.controllers.request.WarehouseRequest;
import com.topicos.stock.controllers.response.StockResponse;
import com.topicos.stock.controllers.response.WarehouseResponse;
import com.topicos.stock.facade.StockFacade;
import com.topicos.stock.models.Stock;
import com.topicos.stock.models.Warehouse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class WarehouseController {
    @Autowired
	private StockFacade stockFacade;

	@Autowired
	private ModelMapper modelMapper;

    @PostMapping("/warehouse")
    Warehouse saveWarehouse(@Validated @RequestBody WarehouseRequest newObj) {
        return stockFacade.saveWarehouse(newObj.convertToModel());
    }

    @GetMapping("/warehouse")
    List<WarehouseResponse> listWarehouse() {
        List<WarehouseResponse> response = new ArrayList<>();

        for (Warehouse warehouse : stockFacade.listWarehouses()) {
            response.add(new WarehouseResponse(warehouse));
        }

        return response;
    }

    @GetMapping("/warehouse/{id}")
    WarehouseResponse listWarehouse(@PathVariable long id) {
        Optional<Warehouse> warehouse = stockFacade.findWarehouse(id);
        return warehouse.map(WarehouseResponse::new).orElse(null);
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@PathVariable long id) {
        stockFacade.deleteWarehouse(id);
    }

// TODO: Implement updateWarehouse. Precisa adicionar na fachada e no CreateWarehouse
//    @PutMapping("/warehouse/{id}")
//    Warehouse updateWarehouse(@PathVariable long id, @Validated @RequestBody WarehouseRequest newObj) {
//        return stockFacade.updateWarehouse(id, newObj.convertToModel());
//    }
}
