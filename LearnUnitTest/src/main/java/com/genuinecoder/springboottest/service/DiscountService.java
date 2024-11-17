package com.genuinecoder.springboottest.service;

import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class DiscountService {

    public float calculateDiscount(float amount, String promoCode) {
        if (promoCode == null) {
            return 0;
        }
        if (promoCode.equals("THANKSGIVING")) {
            return amount * 0.1f;
        }
        if (promoCode.equals("XMAS") && getCurrentYear().getValue() == 2025) {
            return amount * 0.25f;
        }
        return 0;
    }

    Year getCurrentYear() {
        return Year.now();
    }
}
