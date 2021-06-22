package com.rom.paymentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rom.paymentService.exception.CardNotFoundException;
import com.rom.paymentService.exception.Errormsg;

/**
 * GlobalExceptionhandler - Sends a ResponseEntity object with the HttpStatus of the application
 * 
 * @author eluri
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handles All exception 
	 * 
	 * @param ex - Exception
	 * @param request - WebRequest
	 * @return ResponseEntity - HttpStatus
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		Errormsg error = new Errormsg("Server Error", details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handles CardNotFoundException
	 * 
	 * @param ex - Exception
	 * @param request - WebRequest
	 * @return ResponseEntity - HttpStatus
	 */
	@ExceptionHandler(CardNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CardNotFoundException ex, WebRequest request) {
		System.out.println("IN global");
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		Errormsg error = new Errormsg("Card Not Found", details);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	
}
