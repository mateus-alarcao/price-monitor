package com.mateus.price_monitor;

import com.mateus.price_monitor.model.Product;
import com.mateus.price_monitor.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceMonitorApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void salvarProduto() {
		Product product = new Product();
		product.setNome("RTX 5070");

		Product salvo = productRepository.save(product);

		System.out.println("Produto salvo: " + salvo.getId());
	}
}