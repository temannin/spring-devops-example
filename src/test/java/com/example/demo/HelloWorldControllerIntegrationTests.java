package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
    "server.port=0"  // Use random port for testing
})
class HelloWorldControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloEndpointWithDefaults() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void helloEndpointWithName() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Alice"));
    }

    @Test
    void helloEndpointWithGreeting() throws Exception {
        mockMvc.perform(get("/hello")
                .param("greeting", "Hi"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi World"));
    }

    @Test
    void helloEndpointWithBothParams() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", "Bob")
                .param("greeting", "Good morning"))
                .andExpect(status().isOk())
                .andExpect(content().string("Good morning Bob"));
    }

    @Test
    void helloEndpointWithNullName() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void helloEndpointWithNullGreeting() throws Exception {
        mockMvc.perform(get("/hello")
                .param("greeting", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void helloEndpointWithEmptyParams() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", "")
                .param("greeting", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
}
