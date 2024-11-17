package com.genuinecoder.springboottest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Year;

@SpringBootTest
public class DiscountServiceTest {

    @SpyBean
    private DiscountService discountService;

    @Test
    public void testCalculateDiscount_ValidPromoCode() {
        var discount = discountService.calculateDiscount(10, "THANKSGIVING");
        Assertions.assertEquals(1f, discount);
    }

    @Test
    public void testCalculateDiscount_ValidPromoCodeForYear2025() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2025));
        var discount = discountService.calculateDiscount(20, "XMAS");
        Assertions.assertEquals(5f, discount);
    }

    @Test
    public void testCalculateDiscount_ValidPromoCodeForYear2024() {
        Mockito.when(discountService.getCurrentYear()).thenReturn(Year.of(2024));
        var discount = discountService.calculateDiscount(20, "XMAS");
        Assertions.assertEquals(0f, discount);
    }

    @Test
    public void testCalculateDiscount_NullPromoCode() {
        var discount = discountService.calculateDiscount(20, null);
        Assertions.assertEquals(0f, discount);
    }
}
