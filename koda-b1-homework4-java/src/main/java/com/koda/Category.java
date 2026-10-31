package com.koda;

public class Category extends Menu{
    private String categoryName;

    public Category(String menuId, String name, double price, int stock, String categoryName){
        if(categoryName == null){
            throw new IllegalArgumentException("CategoryName is required");
        }

        super(menuId, name, price, stock);
        this.categoryName = categoryName;
    }

    @Override 
    public String getCategoryName(){
        return categoryName;
    }
}
