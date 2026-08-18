package com.mateus.price_monitor.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestScraper {

    public static void main(String[] args) throws Exception {

        String url = "https://www.amazon.com.br/Teclado-Gamer-Redragon-Karura-Silencioso/dp/B07Y5MWJPK/ref=sr_1_18?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&sr=8-18";

        Document documento = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .get();

        Element elementoPreco = documento.selectFirst(".a-offscreen");

        System.out.println("Preço encontrado: " + elementoPreco.text());
    }
}