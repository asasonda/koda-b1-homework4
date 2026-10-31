package com.koda.services;

import java.util.List;
import java.util.Scanner;

import com.koda.Menu;
import com.koda.Cart;

import com.koda.services.CheckoutService;

public class CartService {
    public void addCart(List<Menu> menus, List<Cart> cart, Scanner input){
        
        System.out.print("Pilih makanan: ");
        int makanan = input.nextInt();

        if(makanan < 1 || makanan > menus.size()){
            System.out.println("Input not valid");
            return;
        }

        Menu pilihanMakanan = menus.get(makanan - 1);

        System.out.print("Masukan quantity: ");
        int quantity = input.nextInt();

        if(quantity <= 0){
            System.out.println("quantity not valid");
            return;
        }

        Cart checkCart = null;

        for (Cart cek : cart) {
            if(cek.getMenu().getMenuId().equals(pilihanMakanan.getMenuId())){
                checkCart = cek;
                break;
            }
        }

        if(checkCart != null){
            checkCart.addQuantity(quantity);
        }
        else{
            cart.add(new Cart(pilihanMakanan, quantity));
        }
        System.out.println();
        System.out.println("Berhasil ditambahkan ke keranjang!");
        System.out.println();

        showCart(cart);

        System.out.print("Checkout (Y/n): ");
        String comfirmCheckOut = input.next();

        if(comfirmCheckOut.equalsIgnoreCase("Y")){
            CheckoutService checkoutService = new CheckoutService();

            checkoutService.checkout(cart, input);
        }
    }
    

    public double showCart(List<Cart> cart){
        System.out.println("============= KERANJANG ============= ");
        if(cart.isEmpty()){
            System.out.println("Cart is Empty");
            return 0;
        }

        double total = 0;
        int i = 0;
        for (Cart keranjang : cart) {
            System.out.println(i+1 + ". " + keranjang.getMenu().getMenuName() + " (x" + keranjang.getQuantity() + ") " + keranjang.getMenu().getPrice());
            total += keranjang.getSubtotal();
        }

        System.out.println();
        System.out.println("Total Belanja: Rp." +  total);
        System.out.println();
        return total;
    }
}
