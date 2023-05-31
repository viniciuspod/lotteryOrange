package com.br.lottery.lotteryOrange.Repositories;

import org.springframework.stereotype.Repository;

import com.br.lottery.lotteryOrange.model.dto.BettorDTO;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BettorRepository extends CrudRepository<BettorDTO, Long>{

	BettorDTO findByEmail(String email);

}
