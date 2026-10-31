package com.koda;

public abstract class Menu {
    private String menuId;
    private String name;
    private double price;
    private int stock;


    public Menu(String menuId, String name, double price, int stock){
        if(menuId.isBlank() || menuId == null){
            throw new IllegalArgumentException("Id is required");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("ProductName is required");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price tidak valid");
        }
        if(stock < 0){
            throw new IllegalArgumentException("Stock tidak valid");
        }

        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public int getStock(){
        return stock;
    }

    public void reduceStock(int quantity){
        if(quantity <= 0 || quantity > stock){
            throw new IllegalArgumentException("stock tidak mencukupi");
        }
        this.stock -= quantity;
    }

    public void restoreStock(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            throw new IllegalArgumentException("Quantity tidak valid");
        }

        stock += quantity;
    }

    public abstract String getCategoryName();

    public void showMenu(){
        System.out.println(menuId + ". "+ name + " Rp." + price + " - " + getCategoryName() + "(stock: " + stock + ")");
    }
}