package com.mateus.price_monitor.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;
    private LocalDateTime
            data;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}