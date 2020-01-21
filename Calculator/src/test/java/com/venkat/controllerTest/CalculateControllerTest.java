package com.venkat.controllerTest;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.venkat.controller.CalculateController;

//@RunWith(SpringRunner.class)
@WebMvcTest(value = CalculateController.class, secure = false)
public class CalculateControllerTest {

	@LocalServerPort
	private int port = 8080;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testMultiply() throws JSONException {
		// fail("Not yet implemented");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/standard/multiply/7/3"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + "\"firstValue\": 7.0,\n" + "\"secondValue\": 3.0,\n" + "\"result\": 21.0\n" + "}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void testsubtract() throws JSONException {
		// fail("Not yet implemented");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/standard/subtract/4/3"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + "\"firstValue\": 4.0,\n" + "\"secondValue\": 3.0,\n" + "\"result\": 1.0\n" + "}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void testadd() throws JSONException {
		// fail("Not yet implemented");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/standard/add/7,3"), HttpMethod.GET,
				entity, String.class);

		String expected = "{\n" + "\"firstValue\": 7.0,\n" + "\"secondValue\": 3.0,\n" + "\"result\": 10.0\n" + "}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void factorial() throws JSONException {
		// fail("Not yet implemented");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("scientific/factorial/7"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + "\"firstValue\": 7.0,\n" + "\"result\": 5040.0\n" + "}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void square() throws JSONException {
		// fail("Not yet implemented");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("scientific/square/4"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + "\"firstValue\": 4.0,\n" + "\"result\": 16.0\n" + "}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(final String uri) {
		return "http://localhost:" + port + uri;
	}
}
