package com.koda.services;

import java.util.List;

import com.koda.Menu;

public class MenuService {
    public void showMenus(List<Menu> menus){
        System.out.println("=============== MENU ===============");
        for (Menu menu : menus) {
            menu.showMenu();
        }
        System.out.println();

    }
}