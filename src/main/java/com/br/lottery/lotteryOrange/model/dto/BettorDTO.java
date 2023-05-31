package com.br.lottery.lotteryOrange.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "T_BETTOR")
@SequenceGenerator(name = "bettor_seq", sequenceName = "bettor_seq", allocationSize = 1, initialValue = 1)
public class BettorDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bettor_seq")
	@Column(name="BETTOR_ID")
	private Long id;
	
	@Column(name="BETTOR_EMAIL")
	private String email;
	
	public BettorDTO(String email) {
		this.email = email;
	}
	
	public BettorDTO() {}
}
