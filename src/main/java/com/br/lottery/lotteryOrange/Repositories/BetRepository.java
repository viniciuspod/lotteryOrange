package com.br.lottery.lotteryOrange.Repositories;

import org.springframework.stereotype.Repository;

import com.br.lottery.lotteryOrange.model.dto.BetDTO;
import com.br.lottery.lotteryOrange.model.dto.BettorDTO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BetRepository extends CrudRepository<BetDTO, Long>{

	List<BetDTO> findByBettor(BettorDTO bettor);
}
