package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloWorldControllerTests {
    @Autowired
    private HelloWorldController controller;

    @Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
