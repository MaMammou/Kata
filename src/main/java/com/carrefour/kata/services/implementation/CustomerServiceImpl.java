package com.carrefour.kata.services.implementation;

import com.carrefour.kata.data.Customer;
import com.carrefour.kata.repositories.CustomerRepository;
import com.carrefour.kata.services.interfaces.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(Customer customer) {

        if (customer == null) {
            throw new RuntimeException("The provided customer is null");
        }
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());
        if (existingCustomer.isPresent()) {
            return customerRepository.save(customer);

        } else {
            throw new RuntimeException("Customer not found with id: " + customer.getId());
        }

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("The provided customer is null");
        }
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());
        if (existingCustomer.isPresent()) {
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setCustomerDeliveries(customer.getCustomerDeliveries());
            return customerRepository.save(updatedCustomer);
        } else {
            throw new RuntimeException("Customer with id: " + customer.getId() + " does not exist");
        }

    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            return existingCustomer.get();
        } else {
            throw new RuntimeException("Customer with id: " + id + " does not exist");
        }
    }

    @Override
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }
}
