package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// This test verifies that the Spring application context loads successfully
	}

	@Test
	void helloEndpoint_ShouldReturnDefaultGreeting() {
		String response = restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
		assertThat(response).isEqualTo("Hello World");
	}

	@Test
	void helloEndpoint_WithCustomName_ShouldReturnCustomGreeting() {
		String response = restTemplate.getForObject("http://localhost:" + port + "/hello?name=TestUser", String.class);
		assertThat(response).isEqualTo("Hello TestUser");
	}

	@Test
	void concatenateEndpoint_ShouldConcatenateStrings() {
		String response = restTemplate.getForObject("http://localhost:" + port + "/hello/concatenate?first=Hello&second=World", String.class);
		assertThat(response).isEqualTo("Hello World");
	}

}
