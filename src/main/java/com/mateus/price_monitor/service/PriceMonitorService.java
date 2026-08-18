package com.mateus.price_monitor.service;

import com.mateus.price_monitor.model.Offer;
import com.mateus.price_monitor.model.PriceHistory;
import com.mateus.price_monitor.repository.OfferRepository;
import com.mateus.price_monitor.repository.PriceHistoryRepository;
import com.mateus.price_monitor.scraper.GenericScraper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PriceMonitorService {

    private final OfferRepository offerRepository;
    private final PriceHistoryRepository priceHistoryRepository;
    private final GenericScraper genericScraper;

    public PriceMonitorService(
            OfferRepository offerRepository,
            PriceHistoryRepository priceHistoryRepository,
            GenericScraper genericScraper) {

        this.offerRepository = offerRepository;
        this.priceHistoryRepository = priceHistoryRepository;
        this.genericScraper = genericScraper;
    }

    public void verificarOferta(Long offerId) {

        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Oferta não encontrada"));

        BigDecimal precoAntigo = offer.getPrecoAtual();

        BigDecimal precoNovo = genericScraper.buscarPreco(
                offer.getLink(),
                offer.getSeletorPreco()
        );

        if (precoAntigo != null && precoNovo.compareTo(precoAntigo) < 0) {
            System.out.println("PREÇO CAIU!");
            System.out.println("Produto: " + offer.getProduct().getNome());
            System.out.println("Loja: " + offer.getLoja());
            System.out.println("De: R$ " + precoAntigo);
            System.out.println("Para: R$ " + precoNovo);
        }

        offer.setPrecoAtual(precoNovo);
        offer.setUltimaVerificacao(LocalDateTime.now());

        offerRepository.save(offer);

        PriceHistory history = new PriceHistory();
        history.setPreco(precoNovo);
        history.setDataVerificacao(LocalDateTime.now());
        history.setOffer(offer);

        priceHistoryRepository.save(history);
    }
}