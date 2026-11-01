using Warteg.Console.Models;

namespace Warteg.Console.Services;

public class MenuServices
{

    public static void ShowDetail(List<Menu> menus)
    {
        menus.Add(new Category("Nasi Putih", 4000, 30, "Makanan"));
        menus.Add(new Category("Ayam Gulai", 8000, 25, "Makanan"));
        menus.Add(new Category("Telur Dadar", 5000, 15, "Makanan"));
        menus.Add(new Category("Tempe Orek", 4000, 10, "Makanan"));
        menus.Add(new Category("Teh Manis Panas/Dingin", 4000, 12, "Minuman"));

        System.Console.WriteLine("=============== MENU =============== ");

        var i = 0;
        foreach (Menu item in menus)
        {
            System.Console.WriteLine($"{i+1}. {item.GetMenu()}");
            i++;
        }
        System.Console.WriteLine();
    }

}