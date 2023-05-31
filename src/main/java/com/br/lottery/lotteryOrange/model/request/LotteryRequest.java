package com.br.lottery.lotteryOrange.model.request;

import com.br.lottery.lotteryOrange.model.Bettor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LotteryRequest {

	@JsonProperty("bettor")
	private Bettor bettor;
}
