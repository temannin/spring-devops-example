package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_WithDefaultParameters_ShouldReturnDefaultGreeting() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void hello_WithCustomName_ShouldReturnCustomGreeting() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Alice"));
    }

    @Test
    void hello_WithCustomGreetingAndName_ShouldReturnCustomGreeting() throws Exception {
        mockMvc.perform(get("/hello")
                .param("greeting", "Hi")
                .param("name", "Bob"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi Bob"));
    }

    @Test
    void hello_WithEmptyName_ShouldReturnGreetingWithEmptyName() throws Exception {
        mockMvc.perform(get("/hello")
                .param("name", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello "));
    }

    @Test
    void concatenate_WithTwoStrings_ShouldConcatenateWithDefaultSeparator() throws Exception {
        mockMvc.perform(get("/hello/concatenate")
                .param("first", "Hello")
                .param("second", "World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void concatenate_WithCustomSeparator_ShouldConcatenateWithCustomSeparator() throws Exception {
        mockMvc.perform(get("/hello/concatenate")
                .param("first", "Hello")
                .param("second", "World")
                .param("separator", "-"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello-World"));
    }

    @Test
    void concatenate_WithEmptySeparator_ShouldConcatenateWithoutSeparator() throws Exception {
        mockMvc.perform(get("/hello/concatenate")
                .param("first", "Hello")
                .param("second", "World")
                .param("separator", ""))
                .andExpect(status().isOk())
                .andExpect(content().string("HelloWorld"));
    }

    @Test
    void concatenate_WithSpecialCharacters_ShouldHandleSpecialCharacters() throws Exception {
        mockMvc.perform(get("/hello/concatenate")
                .param("first", "Hello@")
                .param("second", "#World!")
                .param("separator", "***"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello@***#World!"));
    }

    @Test
    void concatenate_WithNumbers_ShouldConcatenateNumbers() throws Exception {
        mockMvc.perform(get("/hello/concatenate")
                .param("first", "123")
                .param("second", "456")
                .param("separator", "+"))
                .andExpect(status().isOk())
                .andExpect(content().string("123+456"));
    }
}
