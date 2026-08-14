package com.mateus.price_monitor.repository;

import com.mateus.price_monitor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
