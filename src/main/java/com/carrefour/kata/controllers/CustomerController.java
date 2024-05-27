package com.carrefour.kata.controllers;

import com.carrefour.kata.data.Customer;
import com.carrefour.kata.services.interfaces.CustomerServiceInterface;
import com.carrefour.kata.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {


    private final CustomerServiceInterface customerService;

    @Autowired
    public CustomerController(CustomerServiceInterface customerServiceInterface) {
        this.customerService = customerServiceInterface;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable Customer customer) {
        customerService.deleteCustomer(customer);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);

    }

    @GetMapping
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }
}
