package com.mateus.price_monitor.repository;

import com.mateus.price_monitor.model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {

}