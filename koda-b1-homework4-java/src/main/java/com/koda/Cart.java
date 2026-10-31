package com.koda;

public class Cart {
    private Menu menu;
    private int quantity;

    public Cart(Menu menu, int quantity){
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu(){
        return menu;
    }

    public void addQuantity(int jumlah){
        quantity += jumlah;
    }

    public void showCart(){
        System.out.println(menu.getMenuName() + " (x" + quantity + ") Rp." + menu.getPrice());
    }
}
