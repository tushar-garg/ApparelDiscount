package com.mall.discount;

import static com.mall.category.Categories.FOOTWEAR;
import static com.mall.category.Categories.JEANS;
import static com.mall.category.Categories.TROUSERS;
import static com.mall.category.Categories.WOMENS_WEAR;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mall.category.Categories;

/**
 * The Class CategoryDiscountTest.
 */
public class CategoryDiscountTest {

    /**
     * Test category discount for single category.
     */
    @Test
    public void testCategoryDiscountForSingleCategory() {
        CategoryDiscount jeansDiscount = new CategoryDiscount(JEANS);
        assertEquals(0.2, jeansDiscount.calculateDiscount(), 0);

        CategoryDiscount trousersDiscount = new CategoryDiscount(TROUSERS);
        assertEquals(0, trousersDiscount.calculateDiscount(), 0);
    }

    /**
     * Test category discount for multiple categories.
     */
    @Test
    public void testCategoryDiscountForMultipleCategories() {
        List<Categories> categories = new ArrayList<>();
        categories.add(FOOTWEAR);
        categories.add(WOMENS_WEAR);
        CategoryDiscount footwearDiscount = new CategoryDiscount(categories);
        assertEquals(0.5, footwearDiscount.calculateDiscount(), 0);
    }

}
