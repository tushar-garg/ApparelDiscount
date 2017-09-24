package com.mall.brand;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Brands.
 */
public enum Brands {

    /** The wrangler. */
    WRANGLER("Wrangler", 0.1),
    /** The arrow. */
    ARROW("Arrow", 0.2),
    /** The vero moda. */
    VERO_MODA("Vero Moda", 0.6),
    /** The ucb. */
    UCB("UCB", 0.0),
    /** The adidas. */
    ADIDAS("Adidas", 0.05),
    /** The provogue. */
    PROVOGUE("Provogue", 0.2);

    /** The Constant LOOKUP_MAP. */
    private static final Map<String, Brands> LOOKUP_MAP;

    /** The brand name. */
    private final String                     brandName;

    /** The discount. */
    private final double                     discount;

    static {
        HashMap<String, Brands> lookupMap = new HashMap<>();
        for (Brands brandEnum : Brands.values()) {
            lookupMap.put(brandEnum.getBrandName(), brandEnum);
        }
        LOOKUP_MAP = Collections.unmodifiableMap(lookupMap);
    }

    /**
     * Instantiates a new brand enum.
     *
     * @param brandName the brand name
     * @param discount the discount
     */
    private Brands(String brandName, double discount) {
        this.brandName = brandName;
        this.discount = discount;
    }

    /**
     * Gets the brand enum by name.
     *
     * @param brandName the brand name
     * @return the by name
     */
    public static Brands getByName(String brandName) {
        return LOOKUP_MAP.get(brandName);
    }

    /**
     * Gets the brand name.
     *
     * @return the brand name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /* (non-Javadoc) @see java.lang.Enum#toString() */
    @Override
    public String toString() {
        return "[" + this.name() + ": {" + getBrandName() + ", " + getDiscount() + "}]";
    }
}
