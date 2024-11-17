package com.genuinecoder.springboottest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringProcessorServiceTest {

    @Autowired
    private StringProcessorService stringProcessorService;

    @Test
    public void testIsPalindrome_ValidPalindrome() {
        var result = stringProcessorService.isPalindrome("malayalam");
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPalindrome_InvalidPalindrome() {
        var result = stringProcessorService.isPalindrome("genuine-coder");
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsPalindrome_NullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            stringProcessorService.isPalindrome(null);
        });
    }
}
