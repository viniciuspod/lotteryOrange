package com.br.lottery.lotteryOrange.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
@Table(name= "T_BET")
@SequenceGenerator(name = "bet_seq", sequenceName = "bet_seq", allocationSize = 1, initialValue = 1)
public class BetDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bet_seq")
	@Column(name="BET_ID")
	private Long id;
	
	@Column(name="BET_NUMBER1")
	private String bet1;
	
	@Column(name="BET_NUMBER2")
	private String bet2;
	
	@Column(name="BET_NUMBER3")
	private String bet3;
	
	@Column(name="BET_NUMBER4")
	private String bet4;

	@OneToOne(targetEntity = BettorDTO.class)
	@JoinColumn(name = "BETTOR_ID", foreignKey = @ForeignKey(name = "BETTOR_FK"))
	private BettorDTO bettor;	
	

	public BetDTO(Integer bet1, Integer bet2, Integer bet3, Integer bet4, BettorDTO bettor) {
		this.bet1 = bet1.toString();
		this.bet2 = bet2.toString();
		this.bet3 = bet3.toString();
		this.bet4 = bet4.toString();
		this.bettor = bettor;
	}	
	
	public BetDTO() {}
}
