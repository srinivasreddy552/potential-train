package com.venkat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.service.CalculateService;

@RestController
public class ScientificCalculatorController {

	@Autowired
	private CalculateService calculateService;

	@GetMapping("/scientific/square/{firstValue}")
	public ResponseEntity<ValueObject> square(@PathVariable String firstValue) {

		return new ResponseEntity<ValueObject>(calculateService.findSquare(firstValue), new HttpHeaders(),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/scientific/factorial/{firstValue}")
	public ResponseEntity<ValueObject> factorial(@PathVariable int firstValue) {

		if (firstValue < 0)
			return ResponseEntity.noContent().build();

		return new ResponseEntity<ValueObject>(calculateService.getFactorial(firstValue), new HttpHeaders(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/scientific/isPrime/{firstValue}")
	public Boolean isPrime(@PathVariable int firstValue) {

		return calculateService.isPrime(firstValue);

	}

}
