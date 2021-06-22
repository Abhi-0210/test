package com.rom.paymentService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rom.paymentService.exception.CardNotFoundException;
import com.rom.paymentService.service.CardService;

import io.swagger.annotations.ApiOperation;

/**
 * CardController - Entry of the Rest End Point
 * Entry from ComponentProcessingModule call
 * 
 * @author eluri
 *
 */
@ApiOperation(value="/card", tags="Card Controller")
@RestController
public class CardController {
	
	static Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;
	
	/**
	 * Entry to rest End Point
	 * 
	 * @param cardNumber - CreditCard Number
	 * @param charge - Payment Charge
	 * @return balance - Creditcard Balance
	 * @throws CardNotFoundException
	 */
	@GetMapping("/card/{cardNumber}/{charge}")
	@ResponseStatus(code=HttpStatus.OK)
	public double getBalance(@PathVariable long cardNumber,@PathVariable double charge) throws CardNotFoundException {
		logger.info("Handling /card/{cardNumber}/{charge}");
		try {
			return cardService.processPayment(cardNumber,charge);
		}
		catch(CardNotFoundException ex){
			throw new CardNotFoundException();
		}
		
	}
}
