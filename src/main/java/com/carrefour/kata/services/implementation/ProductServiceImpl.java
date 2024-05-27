package com.carrefour.kata.services.implementation;

import com.carrefour.kata.data.Product;
import com.carrefour.kata.repositories.ProductRepository;
import com.carrefour.kata.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if (product == null) {
            throw new RuntimeException("The provided product is null");
        }
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setCustomerDeliveries(product.getCustomerDeliveries());
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + product.getId());
        }
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product findProductById(Long id) {
        Optional<Product> existingProduct=  productRepository.findById(id);

        if (existingProduct.isPresent()) {
            return existingProduct.get();
        } else {
            throw new RuntimeException("Product with id: " + id + " does not exist");
        }
    }

    @Override
    public List<Product> findProduct() {
        return productRepository.findAll();
    }

}
