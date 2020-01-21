package com.venkat.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.controller.CustomException;
import com.venkat.controller.ValueObject;

@Service
public class CalculateService {

	@Autowired
	private ValueObject valueObject;

	public ValueObject multiply(String firstInput, String secondInput) {

		Double firstValue = Double.parseDouble(firstInput);
		Double secondValue = Double.parseDouble(secondInput);
		valueObject.setFirstValue(firstValue);
		valueObject.setSecondValue(secondValue);
		valueObject.setResult(firstValue * secondValue);

		return valueObject;

	}

	public ValueObject add(String firstInput, String secondInput) {
		Double firstValue = Double.parseDouble(firstInput);
		Double secondValue = Double.parseDouble(secondInput);
		valueObject.setFirstValue(firstValue);
		valueObject.setSecondValue(secondValue);
		valueObject.setResult(firstValue + secondValue);

		return valueObject;
	}

	public ValueObject subtract(String firstInput, String secondInput) {
		Double firstValue = Double.parseDouble(firstInput);
		Double secondValue = Double.parseDouble(secondInput);
		valueObject.setFirstValue(firstValue);
		valueObject.setSecondValue(secondValue);
		valueObject.setResult(firstValue - secondValue);

		return valueObject;
	}

	public ValueObject division(String firstInput, String secondInput) {
		Double firstValue = Double.parseDouble(firstInput);
		Double secondValue = Double.parseDouble(secondInput);
		valueObject.setFirstValue(firstValue);
		valueObject.setSecondValue(secondValue);
		valueObject.setResult(firstValue / secondValue);

		return valueObject;
	}

	public ValueObject add(String[] values) {

		Double firstNumber = Double.parseDouble(values[0]);
		valueObject.setFirstValue(firstNumber);
		valueObject.setSecondValue(Double.parseDouble(values[1]));
		valueObject.isPrime(null);
		valueObject.setResult(Arrays.stream(values).mapToDouble(i -> Double.parseDouble(i)).sum());
		return valueObject;

	}

	public ValueObject calculate(String operation, String firstValue, String secondValue) {

		Double firstNumber = Double.parseDouble(firstValue);
		Double secondNumber = Double.parseDouble(secondValue);
		valueObject.setFirstValue(firstNumber);
		valueObject.setSecondValue(secondNumber);

		switch (operation) {
		case "add":
			valueObject.setResult(firstNumber + secondNumber);
		case "subtract":
			valueObject.setResult(firstNumber - secondNumber);
		case "multiply":
			valueObject.setResult(firstNumber * secondNumber);
		case "divide":
			valueObject.setResult(firstNumber / secondNumber);
			// operator doesn't match any case constant (+, -, *, /)
		default:
			System.out.printf("Error! operator is not correct");
			return valueObject;

		}
	}

	public ValueObject findSquare(String firstValue) {
		// TODO Auto-generated method stub
		Double firstNumber = Double.parseDouble(firstValue);
		valueObject.setFirstValue(firstNumber);
		valueObject.setSecondValue(null);
		valueObject.isPrime(null);
		valueObject.setResult(firstNumber * firstNumber);
		return valueObject;
	}

	public static Double getFactorialNumber(int firstValue) {

		Double result = null;
		try {
			if (firstValue <= 1)
				return (double) firstValue;
			result = firstValue * getFactorialNumber(firstValue - 1);
		} catch (Exception e) {

			throw new CustomException("Not valid format");
		}

		return result;

	}

	public ValueObject getFactorial(int firstValue) {

		Double firstNumber = (double) firstValue;
		valueObject.setFirstValue(firstNumber);
		valueObject.setSecondValue(null);
		valueObject.isPrime(null);
		valueObject.setResult(getFactorialNumber(firstValue));
		return valueObject;
	}

	public Boolean isPrime(int firstValue) {

		int remainder;
		boolean isPrime = true;
		// Loop to check whether the numberToCheckber is divisible any numberToCheckber
		// other than 1 and itself
		for (int i = 2; i <= firstValue / 2; i++) {
			remainder = firstValue % 1;
			// if remainder is 0 than number is not prime and break loop.
			// Else continue loop
			if (remainder == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

}
