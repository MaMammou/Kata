package com.carrefour.kata.services.interfaces;

import com.carrefour.kata.data.CustomerDelivery;

import java.util.List;

public interface CustomerDeliveryServiceInterface {


     void addCustomerDelivery(CustomerDelivery customerDelivery);

     void updateCustomerDelivery(CustomerDelivery customerDelivery);

     void deleteCustomerDelivery(CustomerDelivery customerDelivery);

     CustomerDelivery findCustomerDeliveryById(Long id);

     List<CustomerDelivery> findCustomerDeliveries();

}
