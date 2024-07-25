package com.topicos.stock.repository;

import com.topicos.stock.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreetIgnoreCase(String street);
    Address findByNeighborhoodIgnoreCase(String neighborhood);
    Address findByCityIgnoreCase(String city);
    Address findByStateIgnoreCase(String state);
    Address findByCountryIgnoreCase(String country);
    Address findByZipCode(String zipCode);
}
