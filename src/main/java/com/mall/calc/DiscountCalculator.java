package com.mall.calc;

import java.util.ArrayList;
import java.util.List;

import com.mall.brand.Brands;
import com.mall.category.Categories;
import com.mall.category.Category;
import com.mall.category.CategoryTree;
import com.mall.discount.BrandDiscount;
import com.mall.discount.CategoryDiscount;
import com.mall.discount.IDiscount;

/**
 * The Class DiscountCalculator.
 */
public class DiscountCalculator {

    /** The discounts. */
    private final List<IDiscount> discounts;

    /**
     * Instantiates a new discount calculator.
     */
    private DiscountCalculator() {
        discounts = new ArrayList<>();
    }

    /**
     * Gets the discounts.
     *
     * @return the discounts
     */
    public List<IDiscount> getDiscounts() {
        return discounts;
    }

    /**
     * Adds the discount.
     *
     * @param discount the discount
     */
    public void addDiscount(IDiscount discount) {
        this.getDiscounts().add(discount);
    }

    /**
     * Calculate highest discount.
     *
     * @return the double
     */
    public double calculateHighestDiscount() {
        double highestDiscount = 0;
        for (IDiscount discount : discounts) {
            double discountAmount = discount.calculateDiscount();
            if (discountAmount > highestDiscount) {
                highestDiscount = discountAmount;
            }
        }
        return highestDiscount;
    }

    /**
     * Creates the discount calculator.
     *
     * @param brandName the brand name
     * @param categoryName the category name
     * @return the discount calculator
     */
    public static DiscountCalculator createDiscountCalculator(String brandName, String categoryName) {
        Brands brand = Brands.getByName(brandName);
        Category categoryObject = CategoryTree.findCategoryNodeByName(categoryName);
        List<Categories> categories = categoryObject.getHierarchy();
        DiscountCalculator discountCalculator = new DiscountCalculator();
        BrandDiscount brandDiscount = new BrandDiscount(brand);
        CategoryDiscount categoryDiscount = new CategoryDiscount(categories);
        discountCalculator.addDiscount(brandDiscount);
        discountCalculator.addDiscount(categoryDiscount);
        return discountCalculator;
    }

}
