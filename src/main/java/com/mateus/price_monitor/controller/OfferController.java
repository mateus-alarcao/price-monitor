package com.mateus.price_monitor.controller;

import com.mateus.price_monitor.model.Offer;
import com.mateus.price_monitor.service.OfferService;
import com.mateus.price_monitor.service.PriceMonitorService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final PriceMonitorService priceMonitorService;
    private final OfferService offerService;

    public OfferController(
            OfferService offerService,
            PriceMonitorService priceMonitorService) {

        this.offerService = offerService;
        this.priceMonitorService = priceMonitorService;
    }

    @GetMapping
    public List<Offer> listarOfertas() {
        return offerService.listar();
    }

    @GetMapping("/quedas")
    public List<Offer> listarQuedas(){
        return offerService.listar().stream().filter(Offer::isPrecoCaiu).toList();
    }

    @PostMapping
    public Offer cadastrarOferta(@RequestBody Offer offer) {
        return offerService.salvar(offer);
    }

    @PostMapping("/{id}/check")
    public void verificarPreco(@PathVariable Long id) {
        priceMonitorService.verificarOferta(id);
    }
}