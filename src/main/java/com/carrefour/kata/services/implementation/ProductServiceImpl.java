package com.carrefour.kata.services.implementation;

import com.carrefour.kata.data.Product;
import com.carrefour.kata.services.interfaces.ProductServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> findProduct() {
        return List.of();
    }
}
