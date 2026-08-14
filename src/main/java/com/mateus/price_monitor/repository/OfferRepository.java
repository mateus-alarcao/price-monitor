package com.mateus.price_monitor.repository;

import com.mateus.price_monitor.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}