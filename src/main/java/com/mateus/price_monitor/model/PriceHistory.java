package com.mateus.price_monitor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;

    private LocalDateTime dataVerificacao;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}