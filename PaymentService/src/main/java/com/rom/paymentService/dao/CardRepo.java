package com.rom.paymentService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rom.paymentService.exception.CardNotFoundException;
import com.rom.paymentService.model.CreditCard;

/**
 * Repository class
 * 
 * @author eluri
 *
 */
@Repository
public interface CardRepo extends JpaRepository<CreditCard, String>{

	/**
	 * Checks if a CreditCard is present or not - uses Spring Data JPA's DSL
	 * 
	 * @param cardNumber - CreditCard Number
	 * @return CreditCard - CreditCard Object
	 * @throws CardNotFoundException
	 */
	CreditCard findByCardNumber(long cardNumber)throws CardNotFoundException;

}
