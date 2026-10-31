package com.koda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koda.services.CartService;
import com.koda.services.CheckoutService;
import com.koda.services.MenuService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        List<Menu> menus = new ArrayList<>();
        menus.add(new Category("1", "Nasi Putih", 4000, 30, "Makanan"));
        menus.add(new Category("2", "Ayam Gulai", 8000, 25, "Makanan"));
        menus.add(new Category("3", "Telur Dadar", 5000, 15, "Makanan"));
        menus.add(new Category("4", "Tempe Orek", 4000, 10, "Makanan"));
        menus.add(new Category("5", "Teh Manis Panas/Dingin", 4000, 12, "Minuman"));
        menus.add(new Category("6", "Air Putih", 0, 10, "Minuman"));

        MenuService menuService = new MenuService();

        List<Cart> cart = new ArrayList<>();
        CartService cartControll = new  CartService();
        CheckoutService checkoutService = new CheckoutService();

        boolean runningSystem = true;

        while (runningSystem) {
            System.out.println("========== WELCOME TO WARTEG ========== ");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Keranjang");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
    
            System.out.println();
            System.out.print("Silahkan pilih menu: ");
            int welcome = input.nextInt();
            System.out.println();
            
            switch (welcome) {
                case 1:
                    menuService.showMenus(menus);
                    cartControll.addCart(menus, cart, input);
                    break;
    
                case 2:
                    cartControll.showCart(cart);
                    break;
                case 3:
                    checkoutService.checkout(cart, input);
                    break;
                case 4:
                    System.out.println("jkdvn");
                    runningSystem = false;
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
                    break;
            }  
        }
        input.close();
    }
}
