package com.mateus.price_monitor.controller;

import com.mateus.price_monitor.model.PriceHistory;
import com.mateus.price_monitor.service.PriceHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price-history")
public class PriceHistoryController {

    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }

    @GetMapping
    public List<PriceHistory> listarHistorico() {
        return priceHistoryService.listar();
    }

    @PostMapping
    public PriceHistory cadastrarHistorico(@RequestBody PriceHistory priceHistory) {
        return priceHistoryService.salvar(priceHistory);
    }
}