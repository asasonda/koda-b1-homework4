using Warteg.Console.Models;
using Warteg.Console.Services;

List<Menu> menus =
[
    new Category("Nasi Putih", 4000, 30, "Makanan"),
    new Category("Ayam Gulai", 8000, 25, "Makanan"),
    new Category("Telur Dadar", 5000, 15, "Makanan"),
    new Category("Tempe Orek", 4000, 10, "Makanan"),
    new Category("Teh Manis Panas/Dingin", 4000, 12, "Minuman")
];

MenuServices menuService = new MenuServices();

Console.WriteLine("========== WELCOME TO WARTEG ==========");
Console.WriteLine("1. Lihat Menu");
Console.WriteLine("2. Keranjang");
Console.WriteLine("3. Checkout");
Console.WriteLine("4. Exit");

Console.Write("Silahkan pilih menu: ");
int menu = Convert.ToInt32(Console.ReadLine());

switch (menu)
{
    case 1:
        MenuServices.ShowDetail(menus);
        
        break;
    case 2:
        Console.WriteLine("Keranjang");
        break;
    case 3:
        Console.WriteLine("Checkout");
        break;
    case 4:
        Console.WriteLine("Exit");
        break;
    default:
        return;
}