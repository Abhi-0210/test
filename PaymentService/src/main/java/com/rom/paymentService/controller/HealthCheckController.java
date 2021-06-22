package com.rom.paymentService.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * HealthCheckController - It checks for the health of the application 
 * runs at the rest end point "/"
 * 
 * @author eluri
 *
 */
@RestController
public class HealthCheckController{

	/**
	 * Sends Health status of the application
	 * @return ResponseEntity - HttpStatus
	 */
    @GetMapping(path = "/")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("Health is OK", HttpStatus.OK);
    }
}

