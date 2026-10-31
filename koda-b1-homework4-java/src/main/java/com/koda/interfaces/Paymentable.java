package com.koda.interfaces;

import java.util.Scanner;

public interface Paymentable {
    boolean pay(double total, Scanner input);
    String getPaymentName();
    double getPaidAmount();
    double getChange();
}
