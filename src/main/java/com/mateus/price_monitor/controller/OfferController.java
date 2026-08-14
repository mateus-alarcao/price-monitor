package com.mateus.price_monitor.controller;

import com.mateus.price_monitor.model.Offer;
import com.mateus.price_monitor.repository.OfferRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferRepository offerRepository;

    public OfferController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping
    public List<Offer> listarOfertas() {
        return offerRepository.findAll();
    }

    @PostMapping
    public Offer cadastrarOferta(@RequestBody Offer offer) {
        return offerRepository.save(offer);
    }
}