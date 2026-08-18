package com.mateus.price_monitor.service;

import com.mateus.price_monitor.model.Product;
import com.mateus.price_monitor.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product salvar(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listar() {
        return productRepository.findAll();
    }
}