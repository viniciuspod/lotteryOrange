package com.br.lottery.lotteryOrange.model.response;

import com.br.lottery.lotteryOrange.model.Bettor;
import com.br.lottery.lotteryOrange.model.dto.BetDTO;
import com.br.lottery.lotteryOrange.model.dto.BettorDTO;
import com.br.lottery.lotteryOrange.model.request.LotteryRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LotteryReponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("bet1")
	private String bet1;
	
	@JsonProperty("bet2")
	private String bet2;
	
	@JsonProperty("bet3")
	private String bet3;
	
	@JsonProperty("bet4")
	private String bet4;
	
	@JsonProperty("bettor")
	private Bettor bettor;
	
	public LotteryReponse(BettorDTO bettor, BetDTO betDTO) {
		this.id = betDTO.getId();
		this.bet1 = betDTO.getBet1();
		this.bet2 = betDTO.getBet2();
		this.bet3 = betDTO.getBet3();
		this.bet4 = betDTO.getBet4();
		this.bettor = new Bettor(bettor);
	}
	
	public LotteryReponse() {}
}
