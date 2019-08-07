package com.trade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trade.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Integer>{

	@Query("SELECT t FROM Trade t WHERE t.user.id = ?1")
	Optional<List<Trade>> findByUserId(int id);

}
