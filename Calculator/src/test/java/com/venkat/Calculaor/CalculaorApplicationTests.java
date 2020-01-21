package com.venkat.Calculaor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venkat.service.CalculateService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculaorApplicationTests {

	@InjectMocks
	CalculatorApplication app;

	@Autowired
	private CalculateService calculateService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void main() {
		String array[] = { "start" };

		app.main(array);
	}

	@Test
	public void multiplyTest() {

		calculateService.multiply("2", "3");

		assertEquals(6, calculateService.multiply("2", "3").getResult(), 0);
	}

	@Test
	public void addTest() {

		calculateService.add("2", "3");

		assertEquals(6, calculateService.add("2", "3").getResult(), 1);
	}

	@Test
	public void subtractTest() {

		calculateService.subtract("2", "3");

		assertEquals(-1, calculateService.subtract("2", "3").getResult(), 0);
	}

	@Test
	public void division() {

		assertEquals(1, calculateService.division("3", "3").getResult(), 0);
	}

	@Test
	public void otherTests() {

		assertEquals(120, calculateService.findSquare("5").getResult(), 0);

		assertEquals(120, calculateService.getFactorial(5).getResult(), 0);

		assertTrue(calculateService.isPrime(34));

	}
}
