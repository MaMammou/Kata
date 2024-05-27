package com.carrefour.kata.services.interfaces;

import com.carrefour.kata.data.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> findCustomer();
}
