package com.carrefour.kata.controllers;

import com.carrefour.kata.data.Product;
import com.carrefour.kata.services.interfaces.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {


    private final ProductServiceInterface productService;


    @Autowired
    public ProductController(ProductServiceInterface productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findProducts() {
        List<Product> products = productService.findProduct();
        return ResponseEntity.ok(products);
    }
}
