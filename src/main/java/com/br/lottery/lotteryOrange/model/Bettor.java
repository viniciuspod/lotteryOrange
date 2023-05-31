package com.br.lottery.lotteryOrange.model;

import com.br.lottery.lotteryOrange.model.dto.BettorDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Bettor {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("email")
	private String email;

	public Bettor(BettorDTO bettor) {
		this.id = bettor.getId();
		this.email = bettor.getEmail();
	}
	
	public Bettor() {}

}
