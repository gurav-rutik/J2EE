package com.jsoiders.manytoone.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bankName;
	private long accountNumber;
	private String location;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private BankAccountHolder bankAccountHolder;
}
