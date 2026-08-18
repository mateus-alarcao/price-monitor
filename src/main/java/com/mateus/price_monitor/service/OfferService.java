package com.mateus.price_monitor.service;

import com.mateus.price_monitor.model.Offer;
import com.mateus.price_monitor.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer salvar(Offer offer) {
        return offerRepository.save(offer);
    }

    public List<Offer> listar() {
        return offerRepository.findAll();
    }
}