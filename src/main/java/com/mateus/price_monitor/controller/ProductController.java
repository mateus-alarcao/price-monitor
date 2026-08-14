package com.mateus.price_monitor.controller;

import com.mateus.price_monitor.model.Product;
import com.mateus.price_monitor.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> listarProdutos() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product cadastrarProduto(@RequestBody Product product){
        return productRepository.save(product);
    }
}