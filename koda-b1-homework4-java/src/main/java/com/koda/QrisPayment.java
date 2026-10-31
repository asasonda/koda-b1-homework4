package com.koda;

import java.util.Scanner;

import com.koda.interfaces.Paymentable;

public class QrisPayment implements Paymentable {
    private double paidAmount;

    @Override
    public boolean pay(double total, Scanner input) {

        System.out.println("Silakan scan QRIS...");
        System.out.printf("Total pembayaran: Rp%,.0f%n", total);

        System.out.print("Konfirmasi pembayaran (Y/n): ");
        String confirmation = input.next();

        if (!confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Pembayaran dibatalkan!");
            return false;
        }

        paidAmount = total;

        System.out.println("Pembayaran QRIS berhasil!");

        return true;
    }

    @Override
    public String getPaymentName() {
        return "QRIS";
    }

    @Override
    public double getPaidAmount() {
        return paidAmount;
    }

    @Override
    public double getChange() {
        return 0;
    }
}
