package com.mateus.price_monitor.scheduler;

import com.mateus.price_monitor.model.Offer;
import com.mateus.price_monitor.repository.OfferRepository;
import com.mateus.price_monitor.service.PriceMonitorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceScheduler {

    private final OfferRepository offerRepository;
    private final PriceMonitorService priceMonitorService;

    public PriceScheduler(
            OfferRepository offerRepository,
            PriceMonitorService priceMonitorService) {

        this.offerRepository = offerRepository;
        this.priceMonitorService = priceMonitorService;
    }

    @Scheduled(fixedRate = 60000)
    public void verificarOfertas() {

        List<Offer> ofertas = offerRepository.findAll();

        for (Offer oferta : ofertas) {
            if (oferta.getSeletorPreco() == null ||
                    oferta.getSeletorPreco().isBlank()) {
                continue;
            }

            priceMonitorService.verificarOferta(oferta.getId());
        }
    }
}