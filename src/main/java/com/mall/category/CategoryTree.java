package com.mall.category;

import static com.mall.category.Categories.APPAREL;
import static com.mall.category.Categories.CASUALS;
import static com.mall.category.Categories.DRESSES;
import static com.mall.category.Categories.FOOTWEAR;
import static com.mall.category.Categories.JEANS;
import static com.mall.category.Categories.MENS_WEAR;
import static com.mall.category.Categories.SHIRTS;
import static com.mall.category.Categories.TROUSERS;
import static com.mall.category.Categories.WOMENS_WEAR;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class CategoryTree.
 */
public class CategoryTree {

    /** The root. */
    private final static Category root = buildCategoryTree();

    /**
     * Builds the category tree.
     *
     * @return the category
     */
    private static Category buildCategoryTree() {
        Category category = new Category(APPAREL.getCategoryId());
        Category mensWear = category.addChild(MENS_WEAR.getCategoryId());
        mensWear.addChild(SHIRTS.getCategoryId());
        mensWear.addChild(CASUALS.getCategoryId());
        mensWear.addChild(TROUSERS.getCategoryId()).addChild(JEANS.getCategoryId());

        Category womensWear = category.addChild(WOMENS_WEAR.getCategoryId());
        womensWear.addChild(DRESSES.getCategoryId());
        womensWear.addChild(FOOTWEAR.getCategoryId());
        return category;
    }

    /**
     * Find category node by name starting from root using BFS.
     *
     * @param categoryName the category name
     * @return the category
     */
    public static Category findCategoryNodeByName(String categoryName) {
        Categories categoryEnum = Categories.getByName(categoryName);
        Category categoryNode = null;
        LinkedList<Category> list = new LinkedList<>(root.getChildren());
        while (!list.isEmpty()) {
            Category category = list.pop();
            if (category.getCategoryId() == categoryEnum.getCategoryId()) {
                categoryNode = category;
                break;
            } else {
                List<Category> children = category.getChildren();
                if (children != null) {
                    list.addAll(children);
                }
            }
        }
        return categoryNode;
    }

}
