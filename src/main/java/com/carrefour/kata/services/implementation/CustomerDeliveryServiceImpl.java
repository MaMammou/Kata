package com.carrefour.kata.services.implementation;

import com.carrefour.kata.data.CustomerDelivery;
import com.carrefour.kata.repositories.CustomerDeliveryRepository;
import com.carrefour.kata.services.interfaces.CustomerDeliveryServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDeliveryServiceImpl implements CustomerDeliveryServiceInterface {
    @Autowired
    private CustomerDeliveryRepository customerDeliveryRepository;

    @Override
    @Transactional
    public CustomerDelivery addCustomerDelivery(CustomerDelivery customerDelivery) {
        return customerDeliveryRepository.save(customerDelivery);
    }

    @Override
    @Transactional
    public CustomerDelivery updateCustomerDelivery(CustomerDelivery customerDelivery) {
        if (customerDelivery == null ) {
            throw new RuntimeException("The provided entry is null");
        }
        Optional<CustomerDelivery> existingCustomerDelivery = customerDeliveryRepository.findById(customerDelivery.getId());
        if (existingCustomerDelivery.isPresent()){
            CustomerDelivery delivery = existingCustomerDelivery.get();
            delivery.setCustomer(customerDelivery.getCustomer());
            delivery.setDeliveryMethod(customerDelivery.getDeliveryMethod());
            delivery.setProduct(customerDelivery.getProduct());
            return customerDeliveryRepository.save(customerDelivery);
        }else{
            throw new RuntimeException("Delivery with id : "+customerDelivery.getId() +" does not exist");
        }

    }

    @Override
    public void deleteCustomerDelivery(CustomerDelivery customerDelivery) {
        customerDeliveryRepository.deleteById(customerDelivery.getId());
    }

    @Override
    public CustomerDelivery findCustomerDeliveryById(Long id) {
        Optional<CustomerDelivery> customerDelivery = customerDeliveryRepository.findById(id);
        return customerDelivery.orElseThrow(() -> new RuntimeException("CustomerDelivery not found with id: " + id));
    }

    @Override
    public List<CustomerDelivery> findCustomerDeliveries() {
        return customerDeliveryRepository.findAll();
    }
}
