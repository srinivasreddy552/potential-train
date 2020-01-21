package com.venkat.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValueObject {

	Double firstValue;
	Double secondValue;
	Double result;
	Boolean isPrime;

	public ValueObject(Double firstValue, Double secondValue) {
		super();
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.result = result;
	}

	public ValueObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Double firstValue) {
		this.firstValue = firstValue;
	}

	public Double getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Double secondValue) {
		this.secondValue = secondValue;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public Boolean isPrime() {
		return isPrime;
	}

	public void isPrime(Boolean isPrime) {
		this.isPrime = isPrime;
	}

}
