package com.koda;

public class Cart {
    private Menu menu;
    private int quantity;

    public Cart(Menu menu, int quantity){
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity not valid");
        }
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu(){
        return menu;
    }

    public int getQuantity(){
        return quantity;
    }

    public void addQuantity(int jumlah){
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid");
        }
        this.quantity += jumlah;
    }

    public void showCart(){
        System.out.println(menu.getMenuName() + " (x" + quantity + ") Rp." + menu.getPrice());
    }

    public double getSubtotal() {
        return menu.getPrice() * quantity;
    }
}
