package com.mall.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class PriceCalculatorTest.
 */
public class PriceCalculatorTest {

    /**
     * Check effective price for arrow shirts.
     */
    @Test
    public void checkEffectivePriceForArrowShirts() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double effectivePrice = priceCalculator.calculateEffectivePrice("Arrow", "Shirts", "800");
        assertEquals(640, effectivePrice, 0);
    }

    /**
     * Check effective price for vero moda dresses.
     */
    @Test
    public void checkEffectivePriceForVeroModaDresses() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double effectivePrice = priceCalculator.calculateEffectivePrice("Vero Moda", "Dresses", "1400");
        assertEquals(560, effectivePrice, 0);
    }

    /**
     * Check effective price for provogue footwear.
     */
    @Test
    public void checkEffectivePriceForProvogueFootwear() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double effectivePrice = priceCalculator.calculateEffectivePrice("Provogue", "Footwear", "1800");
        assertEquals(900, effectivePrice, 0);
    }

    /**
     * Check effective price for wrangler jeans.
     */
    @Test
    public void checkEffectivePriceForWranglerJeans() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double effectivePrice = priceCalculator.calculateEffectivePrice("Wrangler", "Jeans", "2200");
        assertEquals(1760, effectivePrice, 0);
    }

    /**
     * Check effective price for UCB shirts.
     */
    @Test
    public void checkEffectivePriceForUCBShirts() {
        PriceCalculator priceCalculator = new PriceCalculator();
        double effectivePrice = priceCalculator.calculateEffectivePrice("UCB", "Shirts", "1500");
        assertEquals(1500, effectivePrice, 0);
    }

}
