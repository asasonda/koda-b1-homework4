using Warteg.Console.Models;
using Warteg.Console.Services;

List<Menu> menus = [];
List<Cart> carts = [];

CartServices cartServices = new();
CheckoutServices checkoutServices = new();


while (true)
{
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
            cartServices.AddCart(menus, carts);
            break;
        case 2:
            cartServices.ShowCart(carts);
            break;
        case 3:
            cartServices.ShowCart(carts);

            if(carts.Count != 0)
            {
                System.Console.Write("Checkout (Y/n): ");
                string? checkout = System.Console.ReadLine();
                if(checkout?.ToLower() == "y")
                {
                    checkoutServices.Checkout(carts);
                }
                else if(checkout?.ToLower() == "n")
                {
                    break;
                }
                else
                {
                    System.Console.WriteLine("Error: Tidak sesuai format input");
                    break;
                }
            }
            break;
        case 4:
            Console.WriteLine("Exit");
            return;
        default:
            System.Console.WriteLine("Menu tidak tersedia");
            break;
    }
}
