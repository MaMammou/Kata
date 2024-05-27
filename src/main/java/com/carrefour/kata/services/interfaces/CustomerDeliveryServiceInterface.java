package com.carrefour.kata.services.interfaces;

import com.carrefour.kata.data.CustomerDelivery;

import java.util.List;

public interface CustomerDeliveryServiceInterface {


     CustomerDelivery addCustomerDelivery(CustomerDelivery customerDelivery);

     CustomerDelivery updateCustomerDelivery(CustomerDelivery customerDelivery);

     void deleteCustomerDelivery(CustomerDelivery customerDelivery);

     CustomerDelivery findCustomerDeliveryById(Long id);

     List<CustomerDelivery> findCustomerDeliveries();

}
