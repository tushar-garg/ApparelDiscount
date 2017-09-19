package com.mall.category;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

    APPAREL("Apparel", 0), MENS_WEAR("Men's Wear", 0), SHIRTS("Shirts", 0), TROUSERS("Trousers", 0), CASUALS("Casuals",
            0.3), JEANS("Jeans", 0.2), WOMENS_WEAR("Women's Wear", 0.5), DRESSES("Dresses", 0), FOOTWEAR("Footwear", 0);

    private static final Map<String, CategoryEnum> LOOKUP_MAP;
    private String                                 categoryName = null;
    private double                                 discount;

    static {
        HashMap<String, CategoryEnum> lookupMap = new HashMap<>();
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            lookupMap.put(categoryEnum.getCategoryName(), categoryEnum);
        }
        LOOKUP_MAP = Collections.unmodifiableMap(lookupMap);
    }

    private CategoryEnum(String categoryName, double discount) {
        this.categoryName = categoryName;
        this.discount = discount;
    }

    public static CategoryEnum getByName(String categoryName) {
        return LOOKUP_MAP.get(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "[" + this.name() + ": {" + getCategoryName() + ", " + getDiscount() + "}]";
    }

}
