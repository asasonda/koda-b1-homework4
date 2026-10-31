package com.koda.services;

import java.util.List;
import java.util.Scanner;

import com.koda.Cart;

public class CheckoutService {
    
    public void checkout(List<Cart> cart, Scanner input){
        if(cart.isEmpty()){
            System.out.println("Cart is Empty");
            return;
        }

        double total = 0;
        for (Cart keranjang : cart) {
            total += keranjang.getSubtotal();
        }

        System.out.println();

        System.out.println("Metode Pembayaran: ");
        System.out.println("1. Cash");
        System.out.println("2. QRIS");

        System.out.println();
        System.out.print("Pilih metode: ");
        int metode = input.nextInt();

        double uang = 0;
        boolean successCheckout = false;

        switch (metode) {
            case 1:
                System.out.print("Masukan uang: ");
                uang = input.nextDouble();

                if(uang < total){
                    System.out.println("Uang tidak cukup!");
                    return ;
                }

                System.out.println();
                successCheckout = true;
                break;
        
            default:
                System.out.println("Metode tidak valid");
                break;
        }

        if(successCheckout){
            showReceipt(cart, total, uang);
        }

    }

    public void showReceipt(List<Cart> cart, double total, double uang){
        System.out.println("=============== RECEIPT =============== ");
        for (Cart cartReceipt : cart) {
            System.out.println(cartReceipt.getMenu().getMenuName()+ " (x" + cartReceipt.getQuantity() + ") Rp." + cartReceipt.getSubtotal());
        }

        System.out.println("---------------------------------------");
        System.out.println("Total: Rp."+ total);
        System.out.println("Bayar: Rp."+ uang);

        double kembalian = uang - total;
        System.out.println("kemalian: Rp." + kembalian);

        System.out.println();
        System.out.println("Terima kasih sudah membeli!");
        System.out.println();
    }
}
