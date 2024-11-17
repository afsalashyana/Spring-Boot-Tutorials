package com.genuinecoder.springboottest.service;

import org.springframework.stereotype.Service;

@Service
public class StringProcessorService {

    public boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed.equals(input);
    }

}
