package com.mall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mall.brand.BrandEnum;
import com.mall.category.CategoryEnum;
import com.mall.category.CategoryTree;
import com.mall.category.CategoryTree.Category;

public class PriceCalculator {

    public static Map<String, String[]> getInventoryDetails() {
        String[] inventoryList = new String[5];
        inventoryList[0] = "1, Arrow, Shirts, 800";
        inventoryList[1] = "2, Vero Moda, Dresses, 1400";
        inventoryList[2] = "3, Provogue, Footwear, 1800";
        inventoryList[3] = "4, Wrangler, Jeans, 2200";
        inventoryList[4] = "5, UCB, Shirts, 1500";

        Map<String, String[]> inventoryMap = new HashMap<>();
        for (String inventory : inventoryList) {
            String[] inventoryOptions = inventory.split(",");
            String[] inventoryDetail = Arrays.copyOfRange(inventoryOptions, 1, inventoryOptions.length);
            inventoryMap.put(inventoryOptions[0].trim(), inventoryDetail);
        }
        return inventoryMap;
    }

    public static String[] getCustomerOptions() {
        String[] customerOptions = new String[2];
        customerOptions[0] = "1,2,3,4";
        customerOptions[1] = "1,5";
        return customerOptions;
    }

    public static void main(String[] args) {
        Map<String, String[]> inventoryMap = getInventoryDetails();
        String[] customerOptions = getCustomerOptions();
        for (String customerOption : customerOptions) {
            double totalPrice = 0;
            String[] customerOptionArr = customerOption.split(",");
            for (String customOptionArrValue : customerOptionArr) {
                String[] inventoryDetails = inventoryMap.get(customOptionArrValue.trim());
                if (inventoryDetails != null) {
                    totalPrice += calculateEffectivePrice(inventoryDetails[0].trim(), inventoryDetails[1].trim(),
                            inventoryDetails[2].trim());
                }
            }
            System.out.println(totalPrice);
        }
    }

    private static double calculateEffectivePrice(String brandName, String categoryName, String price) {
        BrandEnum brand = BrandEnum.getByName(brandName);
        Category categoryObject = CategoryTree.findCategoryNodeByName(categoryName);
        List<CategoryEnum> hierarchy = categoryObject.getHierarchy();
        double highestDiscount = getHighestDiscount(brand, hierarchy);
        return Integer.valueOf(price) * (1 - highestDiscount);
    }

    private static double getHighestDiscount(BrandEnum brand, List<CategoryEnum> hierarchy) {
        double highestDiscount = 0;
        for (Iterator<CategoryEnum> iterator = hierarchy.iterator() ; iterator.hasNext() ;) {
            CategoryEnum categoryEnum = iterator.next();
            double categoryDiscount = categoryEnum.getDiscount();
            if (highestDiscount < categoryDiscount) {
                highestDiscount = categoryDiscount;
            }
        }
        double brandDiscount = brand.getDiscount();
        highestDiscount = highestDiscount > brandDiscount ? highestDiscount : brandDiscount;
        return highestDiscount;
    }
}
