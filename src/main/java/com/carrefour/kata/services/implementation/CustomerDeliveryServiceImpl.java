package com.carrefour.kata.services.implementation;

import com.carrefour.kata.data.CustomerDelivery;
import com.carrefour.kata.services.interfaces.CustomerDeliveryServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDeliveryServiceImpl implements CustomerDeliveryServiceInterface {
    @Override
    public void addCustomerDelivery(CustomerDelivery customerDelivery) {

    }

    @Override
    public void updateCustomerDelivery(CustomerDelivery customerDelivery) {

    }

    @Override
    public void deleteCustomerDelivery(CustomerDelivery customerDelivery) {

    }

    @Override
    public CustomerDelivery findCustomerDeliveryById(Long id) {
        return null;
    }

    @Override
    public List<CustomerDelivery> findCustomerDeliveries() {
        return List.of();
    }
}
