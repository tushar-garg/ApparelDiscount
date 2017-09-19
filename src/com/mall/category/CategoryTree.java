package com.mall.category;

import static com.mall.category.CategoryEnum.APPAREL;
import static com.mall.category.CategoryEnum.CASUALS;
import static com.mall.category.CategoryEnum.DRESSES;
import static com.mall.category.CategoryEnum.FOOTWEAR;
import static com.mall.category.CategoryEnum.JEANS;
import static com.mall.category.CategoryEnum.MENS_WEAR;
import static com.mall.category.CategoryEnum.SHIRTS;
import static com.mall.category.CategoryEnum.TROUSERS;
import static com.mall.category.CategoryEnum.WOMENS_WEAR;

import java.util.LinkedList;
import java.util.List;

public class CategoryTree {
    private static Category root;

    static {
        Category category = new Category(APPAREL);

        Category mensWear = category.addChild(MENS_WEAR);
        mensWear.addChild(SHIRTS);
        mensWear.addChild(CASUALS);
        mensWear.addChild(TROUSERS).addChild(JEANS);

        Category womensWear = category.addChild(WOMENS_WEAR);
        womensWear.addChild(DRESSES);
        womensWear.addChild(FOOTWEAR);

        root = category;
    }

    public static Category getRoot() {
        return root;
    }

    public static Category findCategoryNodeByName(String categoryName) {
        return Category.findCategoryNodeByName(categoryName);
    }

    public static class Category {

        CategoryEnum                 categoryEnum;
        Category                     parent;
        private final List<Category> children;

        protected Category(CategoryEnum categoryEnum) {
            this.categoryEnum = categoryEnum;
            this.children = new LinkedList<>();
        }

        protected CategoryEnum getCategoryEnum() {
            return this.categoryEnum;
        }

        protected Category getParent() {
            return this.parent;
        }

        protected List<Category> getChildren() {
            return this.children;
        }

        protected Category addChild(CategoryEnum categoryEnum) {
            Category childNode = new Category(categoryEnum);
            childNode.parent = this;
            this.getChildren().add(childNode);
            return childNode;
        }

        public List<CategoryEnum> getHierarchy() {
            List<CategoryEnum> hierarchy = new LinkedList<>();
            hierarchy.add(getCategoryEnum());
            Category parent = getParent();
            while (parent != null) {
                hierarchy.add(parent.getCategoryEnum());
                parent = parent.getParent();
            }
            return hierarchy;
        }

        protected static Category findCategoryNodeByName(String categoryName) {
            CategoryEnum categoryEnum = CategoryEnum.getByName(categoryName);
            Category categoryNode = null;
            LinkedList<Category> list = new LinkedList<>(CategoryTree.getRoot().getChildren());
            while (!list.isEmpty()) {
                Category category = list.pop();
                if (category.getCategoryEnum().equals(categoryEnum)) {
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((getCategoryEnum() == null) ? 0 : getCategoryEnum().hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Category other = (Category) obj;
            if (getCategoryEnum() != other.getCategoryEnum())
                return false;
            return true;
        }

    }

}
