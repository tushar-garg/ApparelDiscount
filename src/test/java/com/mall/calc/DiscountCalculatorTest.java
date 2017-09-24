package com.mall.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class DiscountCalculatorTest.
 */
public class DiscountCalculatorTest {

    /**
     * Test discount for lesser discount on brand and higher discount on category.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDiscountForLesserDiscountOnBrandAndHigherDiscountOnCategory() throws Exception {
        DiscountCalculator discountCalculator = DiscountCalculator.createDiscountCalculator("Wrangler", "Jeans");
        assertEquals(0.2, discountCalculator.calculateHighestDiscount(), 0);
    }

    /**
     * Test discount for higher discount on brand and lesser discount on category.
     */
    @Test
    public void testDiscountForHigherDiscountOnBrandAndLesserDiscountOnCategory() {
        DiscountCalculator discountCalculator = DiscountCalculator.createDiscountCalculator("Vero Moda", "Dresses");
        assertEquals(0.6, discountCalculator.calculateHighestDiscount(), 0);
    }

}
