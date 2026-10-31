package com.koda;

import java.util.Scanner;

import com.koda.interfaces.Paymentable;

public class CashPayment implements Paymentable {
    private double paidAmount;
    private double change;

    @Override
    public boolean pay(double total, Scanner input) {

        System.out.print("Masukkan uang: ");
        paidAmount = input.nextDouble();

        if (paidAmount < total) {
            System.out.println("Uang tidak mencukupi!");
            return false;
        }

        change = paidAmount - total;

        System.out.println("Pembayaran Cash berhasil!");

        return true;
    }

    @Override
    public String getPaymentName() {
        return "Cash";
    }

    @Override
    public double getPaidAmount() {
        return paidAmount;
    }

    @Override
    public double getChange() {
        return change;
    }
}
