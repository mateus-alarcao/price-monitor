package com.mateus.price_monitor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;

    private BigDecimal precoAtual;

    private String loja;

    private LocalDateTime ultimaVerificacao;

    private String seletorPreco;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}