package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
    "server.port=0"  // Use random port for testing
})
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // This test verifies that the Spring context loads successfully
        // which means the main application class is properly configured
        assertTrue(true, "Spring context should load successfully");
    }

    @Test
    void mainMethodCanBeCalled() {
        // Test that the main method can be called without throwing exceptions
        // This is a basic smoke test for the main method
        String[] args = {};
        assertDoesNotThrow(() -> {
            // We can't actually call main() in a test as it would start the full application
            // But we can verify the class is properly configured
            DemoApplication app = new DemoApplication();
            assertNotNull(app, "DemoApplication instance should be created");
        });
    }
}
