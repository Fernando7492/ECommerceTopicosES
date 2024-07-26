package com.topicos.stock.controllers;

import com.topicos.stock.controllers.request.StockRequest;
import com.topicos.stock.controllers.response.StockResponse;
import com.topicos.stock.facade.StockFacade;
import com.topicos.stock.models.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StockController {
    @Autowired
	private StockFacade stockFacade;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/stock")
	public Stock saveStock(@Validated @RequestBody StockRequest newObj) {
		return stockFacade.saveStock(newObj.convertToModel());
	}

	@GetMapping("/stock")
	public List<StockResponse> listStocks() {
		List<StockResponse> response = new ArrayList<>();

		for (Stock stock : stockFacade.listStocks()) {
			response.add(new StockResponse(stock));
		}

		return response;
	}

	@GetMapping("/stock/{id}")
	public StockResponse listStock(@PathVariable long id) {
		Optional<Stock> stock = stockFacade.findStock(id);
        return stock.map(StockResponse::new).orElse(null);
	}

	@GetMapping("/stock/warehouse/{name}")
	public List<StockResponse> listStocksByWarehouse(@PathVariable String name) {
		List<StockResponse> response = new ArrayList<>();

		for (Stock stock : stockFacade.listStocksByWarehouse(name)) {
			response.add(new StockResponse(stock));
		}

		return response;
	}

	@DeleteMapping("/stock/{id}")
	public void deleteStock(@PathVariable long id) {
		stockFacade.deleteStock(id);
	}
}
