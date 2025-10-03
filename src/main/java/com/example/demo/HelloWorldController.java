package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name,
                       @RequestParam(defaultValue = "Hello") String greeting) {
        return concatenateStrings(greeting, name);
    }

    @GetMapping("/hello/concatenate")
    public String concatenate(@RequestParam String first,
                             @RequestParam String second,
                             @RequestParam(defaultValue = " ") String separator) {
        return concatenateStrings(first, separator, second);
    }

    /**
     * Helper method to concatenate strings with a separator
     * @param parts the strings to concatenate
     * @return concatenated string
     */
    private String concatenateStrings(String... parts) {
        if (parts == null || parts.length == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] != null) {
                result.append(parts[i]);
            }
            if (i < parts.length - 1) {
                // Add separator between parts (except for the last part)
                result.append(" ");
            }
        }
        return result.toString();
    }
}
