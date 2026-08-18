package com.mateus.price_monitor.scraper;

import java.math.BigDecimal;

public interface ProductScraper {

    BigDecimal buscarPreco(String url, String seletorPreco);
}