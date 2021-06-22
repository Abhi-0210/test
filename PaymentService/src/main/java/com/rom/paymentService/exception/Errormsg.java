package com.rom.paymentService.exception;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Errormsg Entity Class
 * 
 * @author eluri
 *
 */
@Component
@Data
public class Errormsg {
	private String message;
	private List<String> details;

	/**
	 * No-Arg Constructor
	 * 
	 */
	public Errormsg() {
		super();
	}

	/**
	 * All-Args Constructor
	 * 
	 * @param message - Error message
	 * @param details - Error details
	 */
	public Errormsg(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

}