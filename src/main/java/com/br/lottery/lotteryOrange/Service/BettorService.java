package com.br.lottery.lotteryOrange.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.lottery.lotteryOrange.Repositories.BetRepository;
import com.br.lottery.lotteryOrange.Repositories.BettorRepository;
import com.br.lottery.lotteryOrange.model.Bettor;
import com.br.lottery.lotteryOrange.model.dto.BetDTO;
import com.br.lottery.lotteryOrange.model.dto.BettorDTO;
import com.br.lottery.lotteryOrange.model.request.LotteryRequest;
import com.br.lottery.lotteryOrange.model.response.LotteryReponse;

@Service
public class BettorService {

	@Autowired
	private BettorRepository bettorRepository;
	
	@Autowired
	private BetRepository betRepository;

	private BettorDTO findByEmail(Bettor bettor) {
		return bettorRepository.findByEmail(bettor.getEmail());
	}

	private BettorDTO save(BettorDTO bettor) {
		return bettorRepository.save(bettor);
	}

	public LotteryReponse postBet(LotteryRequest lotteryRequest) {
		
		BettorDTO bettor = this.findByEmail(lotteryRequest.getBettor());
		if(bettor == null) {
			bettor = new BettorDTO(lotteryRequest.getBettor().getEmail());
			bettor = this.save(bettor);
		}
		
		Random random = new Random();
		Integer bet1 = random.nextInt(101);
		Integer bet2 = random.nextInt(101);
		Integer bet3 = random.nextInt(101);
		Integer bet4 = random.nextInt(101);
		
		BetDTO betDTO = new BetDTO(bet1,bet2,bet3,bet4,bettor);
		betDTO = betRepository.save(betDTO);
		LotteryReponse lotteryReponse = new LotteryReponse(bettor,betDTO);
		return lotteryReponse;
	}

	public List<LotteryReponse> getBets(LotteryRequest lotteryRequest) {
		BettorDTO bettor = this.findByEmail(lotteryRequest.getBettor());
		if(bettor == null) {
			throw new BadRequestException("Erro: Bettor não cadastrado!! ");
		}
		List<BetDTO> betDTO = betRepository.findByBettor(bettor);
		List<LotteryReponse> listLottery = new ArrayList<>();
		betDTO.forEach(bet -> {			
			LotteryReponse lottery = new LotteryReponse(bettor,bet); 
			listLottery.add(lottery);
		});
		
		return listLottery;
	}
	
	
}
