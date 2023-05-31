package com.br.lottery.lotteryOrange.controller;

import java.util.List;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.lottery.lotteryOrange.Service.BettorService;
import com.br.lottery.lotteryOrange.model.Bettor;
import com.br.lottery.lotteryOrange.model.dto.BettorDTO;
import com.br.lottery.lotteryOrange.model.request.LotteryRequest;
import com.br.lottery.lotteryOrange.model.response.LotteryReponse;

@RestController
public class lotteryController {
	
	@Autowired
	private BettorService bettorService;

	@PostMapping(value="/lottery_tickets", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public LotteryReponse postLottery(@RequestBody LotteryRequest lotteryRequest) {
		LotteryReponse lotteryReponse = null;
		try {
			lotteryReponse = bettorService.postBet(lotteryRequest);
		} catch (Exception e) {
			throw new BadRequestException("Erro: " + e.getMessage());
		}
		
		return lotteryReponse;
	}
	
	@GetMapping(value="/lottery_tickets", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<LotteryReponse> getLottery(@RequestBody LotteryRequest lotteryRequest){
		List<LotteryReponse> listLotteryReponse = null;
		try {
			listLotteryReponse = bettorService.getBets(lotteryRequest);
		} catch (Exception e) {
			throw new BadRequestException("Erro: " + e.getMessage());
		}
		return listLotteryReponse;
	}
	
}
