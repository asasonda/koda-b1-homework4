package com.koda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koda.services.CartService;
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
        menus.add(new Category("1", "Nasi Putih", 4000, "Makanan"));
        menus.add(new Category("2", "Ayam Gulai", 8000, "Makanan"));
        menus.add(new Category("3", "Telur Dadar", 5000, "Makanan"));
        menus.add(new Category("4", "Tempe Orek", 4000, "Makanan"));
        menus.add(new Category("5", "Teh Manis Panas/Dingin", 4000, "Minuman"));
        menus.add(new Category("6", "Air Putih", 0, "Minuman"));

        MenuService menuService = new MenuService();

        List<Cart> cart = new ArrayList<>();
        CartService cartControll = new  CartService();


        System.out.println("========== WELCOME TO KODA FOOD ========== ");
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

                if(cart.isEmpty()){
                    break;
                }

                double total = cartControll.showCart(cart);

                // System.out.print("Pilih makanan: ");
                // int makanan = input.nextInt();

                // System.out.print("Masukkan quantity: ");
                // int quantity = input.nextInt();

                // cart.add(new Cart(menus.get(makanan - 1).getMenuId(), menus.get(makanan - 1).getMenuName(), menus.get(makanan - 1).getPrice(), quantity));
                
                

            default:
                break;
        }
    }
}
