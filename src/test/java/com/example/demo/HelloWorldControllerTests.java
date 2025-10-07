package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = {
    "server.port=0"  // Use random port for testing
})
class HelloWorldControllerTests {
    
    @Autowired
    private HelloWorldController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void helloWithDefaultParameters() {
        // Test /hello endpoint with default parameters
        String result = controller.hello("World", "Hello");
        assertThat(result).isEqualTo("Hello World");
    }

    @Test
    void helloWithCustomName() {
        // Test /hello endpoint with custom name
        String result = controller.hello("Alice", "Hello");
        assertThat(result).isEqualTo("Hello Alice");
    }

    @Test
    void helloWithCustomGreeting() {
        // Test /hello endpoint with custom greeting
        String result = controller.hello("World", "Hi");
        assertThat(result).isEqualTo("Hi World");
    }

    @Test
    void helloWithBothCustom() {
        // Test /hello endpoint with both custom greeting and name
        String result = controller.hello("Bob", "Good morning");
        assertThat(result).isEqualTo("Good morning Bob");
    }

    @Test
    void helloWithNullName() {
        // Test /hello endpoint with null name
        String result = controller.hello(null, "Hello");
        assertThat(result).isEqualTo("Hello ");
    }

    @Test
    void helloWithNullGreeting() {
        // Test /hello endpoint with null greeting
        String result = controller.hello("World", null);
        assertThat(result).isEqualTo(" World");
    }

    @Test
    void helloWithEmptyStrings() {
        // Test /hello endpoint with empty strings
        String result = controller.hello("", "");
        assertThat(result).isEqualTo(" ");
    }
}
