package com.mall.brand;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum BrandEnum {
    WRANGLER("Wrangler", 0.1), ARROW("Arrow", 0.2), VERO_MODA("Vero Moda", 0.6), UCB("UCB", 0), ADIDAS("Adidas",
            0.05), PROVOGUE("Provogue", 0.2);

    private static final Map<String, BrandEnum> LOOKUP_MAP;
    private final String                        brandName;
    private final double                        discount;

    static {
        HashMap<String, BrandEnum> lookupMap = new HashMap<>();
        for (BrandEnum brandEnum : BrandEnum.values()) {
            lookupMap.put(brandEnum.getBrandName(), brandEnum);
        }
        LOOKUP_MAP = Collections.unmodifiableMap(lookupMap);
    }

    private BrandEnum(String brandName, double discount) {
        this.brandName = brandName;
        this.discount = discount;
    }

    public static BrandEnum getByName(String brandName) {
        return LOOKUP_MAP.get(brandName);
    }

    public String getBrandName() {
        return brandName;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "[" + this.name() + ": {" + getBrandName() + ", " + getDiscount() + "}]";
    }
}
