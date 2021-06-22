package com.rom.paymentService.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rom.paymentService.dao.CardRepo;
import com.rom.paymentService.exception.CardNotFoundException;
import com.rom.paymentService.model.CreditCard;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class - provides the service of processing payment
 * Uses Slf4j for logging
 * 
 * @author eluri
 *
 */
@Slf4j
@Service
public class CardService {
	
	//static Logger logger = LoggerFactory.getLogger(CardService.class);

	@Autowired
	CardRepo cardRepo;
	
	/**
	 * processPayment - checks if a card is valid using the autowired CardRepo and 
	 * processes the payment by deducting the charge from the card limit.
	 *  
	 * @param cardNumber - CreditCard Number
	 * @param charge - Payment Charge
	 * @return balance - CreditCard balance
	 * @throws NoSuchElementException
	 * @throws CardNotFoundException
	 */
	@Transactional
	public double processPayment(long cardNumber,double charge) throws NoSuchElementException, CardNotFoundException {
	
		log.info("Processing payment");
		
		CreditCard card=cardRepo.findByCardNumber(cardNumber);
	
		double balance= card.getCardLimit()-charge;
		if(balance>0) {
			card.setCardLimit(balance);
			cardRepo.save(card);
			return balance;
		}
		else {
			return -1;
		}
	}
}
