package com.venkat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.service.CalculateService;

@RestController
public class CalculateController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CalculateService calculateService;

	/*
	 * This method will handle multiple values for addition EndPoint example:
	 * http://localhost:8080/add/3,3,4,5,6
	 */
	@GetMapping("/standard/add/{operands}")
	public ResponseEntity<ValueObject> add(@PathVariable String[] operands) {

		return new ResponseEntity<ValueObject>(calculateService.add(operands), new HttpHeaders(), HttpStatus.ACCEPTED);

	}

	/**
	 * @param firstValue
	 * @param secondValue
	 * @return subtract
	 */

	@GetMapping("/standard/subtract/{firstValue}/{secondValue}")
	public ResponseEntity<ValueObject> subtract(@PathVariable String firstValue, @PathVariable String secondValue) {

		return new ResponseEntity<ValueObject>(calculateService.subtract(firstValue, secondValue), new HttpHeaders(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/standard/multiply/{firstValue}/{secondValue}")
	@ResponseBody
	public ResponseEntity<ValueObject> multiply(@PathVariable String firstValue, @PathVariable String secondValue) {

		// return calculateService.multiply(firstValue, secondValue);

		return new ResponseEntity<ValueObject>(calculateService.multiply(firstValue, secondValue), new HttpHeaders(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/standard/divide/{firstValue}/{secondValue}")
	public ResponseEntity<ValueObject> division(@PathVariable String firstValue, @PathVariable String secondValue) {

		return new ResponseEntity<ValueObject>(calculateService.division(firstValue, secondValue), new HttpHeaders(),
				HttpStatus.ACCEPTED);

	}

	/*
	 * This method alone can suffice any operation with two values like firstValue +
	 * secondValue, firstValue - secondValue,etc.. But i am commenting it as i dont
	 * wont to include everything in single method.
	 */

	/*
	 * @GetMapping("/standard/{operation}/{firstValue}/{secondValue}") public Double
	 * calculate(@PathVariable String operation, @PathVariable String firstValue,
	 * 
	 * @PathVariable String secondValue) { return
	 * calculateService.calculate(operation, firstValue, secondValue);
	 * 
	 * }
	 */
}
