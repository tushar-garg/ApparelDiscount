package com.mall.calc;

import static com.mall.calc.DiscountCalculator.createDiscountCalculator;

/**
 * The Class PriceCalculator.
 */
public class PriceCalculator {

    /**
     * Calculate effective price by using a discount calculator.
     *
     * @param brandName the brand name
     * @param categoryName the category name
     * @param price the price
     * @return the double
     */
    public double calculateEffectivePrice(String brandName, String categoryName, String price) {
        DiscountCalculator discountCalculator = createDiscountCalculator(brandName, categoryName);
        double highestDiscount = discountCalculator.calculateHighestDiscount();
        return Integer.valueOf(price) * (1 - highestDiscount);
    }

}
