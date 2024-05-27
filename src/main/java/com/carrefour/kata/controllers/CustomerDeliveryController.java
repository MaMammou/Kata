package com.carrefour.kata.controllers;

import com.carrefour.kata.data.CustomerDelivery;
import com.carrefour.kata.services.interfaces.CustomerDeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customerDelivery")
public class CustomerDeliveryController {

    @Autowired
    private CustomerDeliveryServiceInterface customerDeliveryService;

    @PostMapping
    public ResponseEntity<CustomerDelivery> addCustomerDelivery(@RequestBody CustomerDelivery customerDelivery) {
        CustomerDelivery savedDelivery = customerDeliveryService.addCustomerDelivery(customerDelivery);
        return ResponseEntity.ok(savedDelivery);
    }

    @PutMapping()
    public ResponseEntity<CustomerDelivery> updateCustomerDelivery(@RequestBody CustomerDelivery customerDelivery) {
        CustomerDelivery updatedDelivery = customerDeliveryService.updateCustomerDelivery(customerDelivery);
        return ResponseEntity.ok(updatedDelivery);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomerDelivery(@RequestBody CustomerDelivery customerDelivery) {
        customerDeliveryService.deleteCustomerDelivery(customerDelivery);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDelivery> getCustomerDeliveryById(@PathVariable Long id) {
        CustomerDelivery customerDelivery = customerDeliveryService.findCustomerDeliveryById(id);
        return ResponseEntity.ok(customerDelivery);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDelivery>> getAllCustomerDeliveries() {
        List<CustomerDelivery> customerDeliveries = customerDeliveryService.findCustomerDeliveries();
        return ResponseEntity.ok(customerDeliveries);
    }
}
