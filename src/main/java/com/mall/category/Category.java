package com.mall.category;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class Category.
 */
public class Category {

    /** The category id. */
    private final int            categoryId;

    /** The parent. */
    private Category             parent;

    /** The children. */
    private final List<Category> children;

    /**
     * Instantiates a new category.
     *
     * @param categoryId the category id
     */
    public Category(int categoryId) {
        this.categoryId = categoryId;
        this.children = new LinkedList<>();
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
     * Gets the parent.
     *
     * @return the parent
     */
    public Category getParent() {
        return this.parent;
    }

    /**
     * Gets the children.
     *
     * @return the children
     */
    public List<Category> getChildren() {
        return this.children;
    }

    /**
     * Adds the child.
     *
     * @param categoryId the category id
     * @return the category
     */
    public Category addChild(int categoryId) {
        Category childNode = new Category(categoryId);
        childNode.parent = this;
        this.getChildren().add(childNode);
        return childNode;
    }

    /**
     * Gets the hierarchy traversing up the current node.
     *
     * @return the hierarchy
     */
    public List<Categories> getHierarchy() {
        List<Categories> hierarchy = new LinkedList<>();
        hierarchy.add(Categories.getById(getCategoryId()));
        Category parent = getParent();
        while (parent != null) {
            hierarchy.add(Categories.getById(parent.getCategoryId()));
            parent = parent.getParent();
        }
        return hierarchy;
    }

    /* (non-Javadoc) @see java.lang.Object#hashCode() */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + categoryId;
        return result;
    }

    /* (non-Javadoc) @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Category other = (Category) obj;
        if (categoryId != other.categoryId) {
            return false;
        }
        return true;
    }

}