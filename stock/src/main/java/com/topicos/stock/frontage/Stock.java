package com.topicos.stock.frontage;

import com.topicos.stock.create.interfaces.InterfaceCreateWarehouse;
import com.topicos.stock.models.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stock {

    @Autowired
    private InterfaceCreateWarehouse interfaceCreateWarehouse;

    public Warehouse saveWarehouse(Warehouse entity) { return interfaceCreateWarehouse.saveWarehouse(entity); }
    public List<Warehouse> listWarehouses() { return interfaceCreateWarehouse.listWarehouses(); }
    public void deleteWarehouse(Warehouse entity) { interfaceCreateWarehouse.deleteWarehouse(entity); }
    public void deleteWarehouse(Long id) { interfaceCreateWarehouse.deleteWarehouse(id); }
    public Warehouse findWarehouse (Long id) { return interfaceCreateWarehouse.findCategory(id); }

}
