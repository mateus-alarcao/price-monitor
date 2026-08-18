package com.mateus.price_monitor.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GenericScraper implements ProductScraper {

    @Override
    public BigDecimal buscarPreco(String url, String seletorPreco) {
        try {
            Document documento = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .get();

            Element elementoPreco = documento.selectFirst(seletorPreco);

            if (elementoPreco == null) {
                throw new RuntimeException("Preço não encontrado usando o seletor: " + seletorPreco);
            }

            String texto = elementoPreco.text();

            texto = texto
                    .replace("R$", "")
                    .trim()
                    .replace(".", "")
                    .replace(",", ".");

            return new BigDecimal(texto);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar preço: " + e.getMessage(), e);
        }
    }
}