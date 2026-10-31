using Warteg.Console.Models;

namespace Warteg.Console.Services;

public class MenuServices
{
    public static void ShowDetail(List<Menu> menus)
    {
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