package com.koda.services;

import java.util.List;
import java.util.Scanner;

import com.koda.Cart;
import com.koda.CashPayment;
import com.koda.QrisPayment;
import com.koda.interfaces.Paymentable;

public class CheckoutService {
    
    public void checkout(List<Cart> cart, Scanner input){
        if(cart.isEmpty()){
            System.out.println("Cart is Empty");
            return;
        }

        double total = cart.stream()
                .mapToDouble(Cart::getSubtotal)
                .sum();

        System.out.println();

        System.out.println("Metode Pembayaran: ");
        System.out.println("1. Cash");
        System.out.println("2. QRIS");

        System.out.println();
        System.out.print("Pilih metode: ");
        int metode = input.nextInt();

        double uang = 0;

        Paymentable payment;

        switch (metode) {
            case 1:
                payment = new CashPayment();
                break;
        
            case 2:
                payment = new QrisPayment();
                break;

            default:
                System.out.println("Metode tidak valid");
                return;
        }

        boolean success = payment.pay(total, input);
        if (!success) {
            System.out.println("Checkout gagal!");
            return;
        }

        showReceipt(cart, total, payment);
        cart.clear();
    }

    public void showReceipt(List<Cart> cart, double total, Paymentable payment){
        System.out.println("=============== RECEIPT =============== ");
        for (Cart cartReceipt : cart) {
            System.out.println(cartReceipt.getMenu().getMenuName()+ " (x" + cartReceipt.getQuantity() + ") Rp." + cartReceipt.getMenu().getPrice());
        }

        System.out.println("---------------------------------------");
        System.out.println("Total: Rp."+ total);
        System.out.println("Bayar: Rp."+ payment.getPaidAmount());
        System.out.println("kemalian: Rp." + payment.getChange());
        System.out.println("Metode Pembayaran: "+ payment.getPaymentName());

        System.out.println();
        System.out.println("Terima kasih sudah membeli!");
        System.out.println();
    }
}
