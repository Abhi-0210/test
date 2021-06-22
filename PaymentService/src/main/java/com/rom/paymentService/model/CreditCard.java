package com.rom.paymentService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * CreditCard - entity class
 * 
 * @author eluri
 *
 */
@Entity
@Data  
@ApiModel(description="Credit Card Model")
public class CreditCard {

	@Id
	private long cardNumber;
	private double cardLimit;
	
	/**
     * No-Arg Constructor
     * 
     */
	public CreditCard() {
	}
	
	/**
	 * All-Args Constructor
	 * 
	 * @param cardNumber - CreditCard number
	 * @param cardLimit - CreditCard Limit
	 */
	public CreditCard(long cardNumber, double cardLimit) {
		this.cardNumber = cardNumber;
		this.cardLimit = cardLimit;
	}
		
}
