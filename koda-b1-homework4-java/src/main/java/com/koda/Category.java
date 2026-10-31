package com.koda;

public class Category extends Menu{
    private String categoryName;

    public Category(String menuId, String name, double price, String categoryName){
        if(categoryName == null){
            throw new IllegalArgumentException("CategoryName is required");
        }

        super(menuId, name, price);
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }
}
