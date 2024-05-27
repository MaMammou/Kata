package com.carrefour.kata.services.interfaces;

import com.carrefour.kata.data.Product;

import java.util.List;

public interface ProductServiceInterface {

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Product findProductById(Long id);

    List<Product> findProduct();
}
