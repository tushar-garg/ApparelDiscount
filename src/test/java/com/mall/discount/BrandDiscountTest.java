package com.mall.discount;

import static com.mall.brand.Brands.UCB;
import static com.mall.brand.Brands.VERO_MODA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class BrandDiscountTest.
 */
public class BrandDiscountTest {

    /**
     * Test brand discount.
     */
    @Test
    public void testBrandDiscount() {
        BrandDiscount veroModaBrandDiscount = new BrandDiscount(VERO_MODA);
        assertEquals(veroModaBrandDiscount.getBrandEnum().getDiscount(), veroModaBrandDiscount.calculateDiscount(), 0);

        BrandDiscount ucbBrandDiscount = new BrandDiscount(UCB);
        assertEquals(ucbBrandDiscount.getBrandEnum().getDiscount(), ucbBrandDiscount.calculateDiscount(), 0);
    }

}
