package com.mall.discount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.mall.category.Categories;

/**
 * The Class CategoryDiscount.
 */
public class CategoryDiscount implements IDiscount {

    /** The categories. */
    private final List<Categories> categories;

    /**
     * Instantiates a new category discount.
     *
     * @param categoryEnum the category enum
     */
    public CategoryDiscount(Categories categoryEnum) {
        categories = new ArrayList<>();
        categories.add(categoryEnum);
    }

    /**
     * Instantiates a new category discount.
     *
     * @param categories the categories
     */
    public CategoryDiscount(List<Categories> categories) {
        this.categories = (categories == null ? Collections.emptyList() : categories);
    }

    /**
     * Gets the categories.
     *
     * @return the categories
     */
    public List<Categories> getCategories() {
        return categories;
    }

    /* (non-Javadoc) @see com.mall.discount.IDiscount#calculateDiscount() */
    @Override
    public double calculateDiscount() {
        double highestDiscount = 0;
        for (Iterator<Categories> iterator = getCategories().iterator() ; iterator.hasNext() ;) {
            Categories categoryEnum = iterator.next();
            double categoryDiscount = categoryEnum.getDiscount();
            if (categoryDiscount > highestDiscount) {
                highestDiscount = categoryDiscount;
            }
        }
        return highestDiscount;
    }

}
