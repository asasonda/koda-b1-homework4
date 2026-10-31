package com.koda;

public class Menu {
    private String menuId;
    private String name;
    private double price;


    public Menu(String menuId, String name, double price){
        if(menuId.isBlank() || menuId == null){
            throw new IllegalArgumentException("Id is required");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("ProductName is required");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price tidak valid");
        }

        this.menuId = menuId;
        this.name = name;
        this.price = price;
    }

    public String getMenuId(){
        return menuId;
    }

    public String getMenuName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void showMenu(){
        System.out.println(menuId + ". "+ name + " Rp." + price);
    }
}
