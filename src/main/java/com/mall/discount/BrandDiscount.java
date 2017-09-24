package com.mall.discount;

import com.mall.brand.Brands;

/**
 * The Class BrandDiscount.
 */
public class BrandDiscount implements IDiscount {

    /** The brand enum. */
    private final Brands brandEnum;

    /**
     * Instantiates a new brand discount.
     *
     * @param brandEnum the brand enum
     */
    public BrandDiscount(Brands brandEnum) {
        this.brandEnum = brandEnum;
    }

    /**
     * Gets the brand enum.
     *
     * @return the brand enum
     */
    public Brands getBrandEnum() {
        return brandEnum;
    }

    /* (non-Javadoc) @see com.mall.discount.IDiscount#calculateDiscount() */
    @Override
    public double calculateDiscount() {
        return getBrandEnum().getDiscount();
    }

}
