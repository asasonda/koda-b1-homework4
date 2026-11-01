using Warteg.Console.Models;

namespace Warteg.Console.Services;

public class CartServices
{
    public void AddCart(List<Menu> menus, List<Cart> carts)
    {
        while (true)
        {
            System.Console.Write("Pilih makanan: ");
            int makanan = Convert.ToInt32(System.Console.ReadLine());
            if(makanan > menus.Count || makanan < 0 )
            {
                System.Console.WriteLine("tidak sesuai daftar menu");
                continue;
            }

            System.Console.Write("Masukan quantity: ");
            int quantity = Convert.ToInt32(System.Console.ReadLine());

            Menu pilihanMenu = menus[makanan - 1];

            if(quantity <= 0 || quantity > pilihanMenu.Stock)
            {
                System.Console.WriteLine("quantity tidak valid");
                continue;
            }
            
            Cart? cekElement = carts.FirstOrDefault(item => item.Menus == pilihanMenu);

            if(cekElement != null)
            {
                System.Console.WriteLine("Update jumlah belanjaan");
                cekElement.Quantity += quantity;
            }
            else
            {
                System.Console.WriteLine("Berhasil ditambahkan ke keranjang!");
                carts.Add(new Cart(pilihanMenu, quantity));
            }

            System.Console.WriteLine();
            System.Console.Write("Tambah keranjang makanan(Y/n): ");
            string? tambah = System.Console.ReadLine();

            if(tambah?.ToLower() == "y")
            {
                System.Console.WriteLine("Silahkan lanjutkan");
            }else if(tambah?.ToLower() == "n")
            {
                System.Console.WriteLine("Berhasil ditambahkan ke keranjang!");
                break;
            }
            else
            {
                System.Console.WriteLine("Masukan Y or N for comfirm add to cart");
                System.Console.WriteLine();
                continue;
            }
        }
    }

    public void ShowCart(List<Cart> carts)
    {
        if(carts.Count == 0)
        {
            System.Console.WriteLine("Cart is Empty");
            System.Console.WriteLine();
            return;
        }
        System.Console.WriteLine("============= KERANJANG =============");
        foreach (Cart item in carts)
        {
            System.Console.WriteLine($"{item.Menus.Name} (x{item.Quantity}) Rp.{item.Menus.Price:N0}");
        }
        System.Console.WriteLine();

        decimal total = carts.Sum(item => item.Menus.Price * item.Quantity);
        System.Console.WriteLine($"Total belanja: Rp.{total:N0}");
        System.Console.WriteLine();
    }
}