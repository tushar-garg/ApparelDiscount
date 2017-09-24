package com.mall.category;

/**
 * The Enum Categories.
 */
public enum Categories {

    /** The apparel. */
    APPAREL(1, "Apparel", 0),
    /** The mens wear. */
    MENS_WEAR(2, "Men's Wear", 0),
    /** The shirts. */
    SHIRTS(3, "Shirts", 0),
    /** The trousers. */
    TROUSERS(4, "Trousers", 0),
    /** The casuals. */
    CASUALS(5, "Casuals", 0.3),
    /** The jeans. */
    JEANS(6, "Jeans", 0.2),
    /** The womens wear. */
    WOMENS_WEAR(7, "Women's Wear", 0.5),
    /** The dresses. */
    DRESSES(8, "Dresses", 0),
    /** The footwear. */
    FOOTWEAR(9, "Footwear", 0);

    /** The category id. */
    private int    categoryId;

    /** The category name. */
    private String categoryName = null;

    /** The discount. */
    private double discount;

    /**
     * Instantiates a new category enum.
     *
     * @param categoryId the category id
     * @param categoryName the category name
     * @param discount the discount
     */
    private Categories(int categoryId, String categoryName, double discount) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.discount = discount;
    }

    /**
     * Gets the category id.
     *
     * @return the category id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Gets the category name.
     *
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Gets the by name.
     *
     * @param categoryName the category name
     * @return the by name
     */
    public static Categories getByName(String categoryName) {
        Categories selectedCategoryEnum = null;
        for (Categories categoryEnum : Categories.values()) {
            if (categoryEnum.getCategoryName().equals(categoryName)) {
                selectedCategoryEnum = categoryEnum;
            }
        }
        return selectedCategoryEnum;
    }

    /**
     * Gets the by id.
     *
     * @param categoryId the category id
     * @return the by id
     */
    public static Categories getById(int categoryId) {
        Categories selectedCategoryEnum = null;
        for (Categories categoryEnum : Categories.values()) {
            if (categoryEnum.getCategoryId() == categoryId) {
                selectedCategoryEnum = categoryEnum;
            }
        }
        return selectedCategoryEnum;
    }

    /* (non-Javadoc) @see java.lang.Enum#toString() */
    @Override
    public String toString() {
        return "[" + this.name() + ": {" + getCategoryId() + ", " + getCategoryName() + ", " + getDiscount() + "}]";
    }

}
