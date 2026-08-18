package com.mateus.price_monitor.controller;

import com.mateus.price_monitor.model.Product;
import com.mateus.price_monitor.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listarProdutos() {
        return productService.listar();
    }

    @PostMapping
    public Product cadastrarProduto(@RequestBody Product product) {
        return productService.salvar(product);
    }
}