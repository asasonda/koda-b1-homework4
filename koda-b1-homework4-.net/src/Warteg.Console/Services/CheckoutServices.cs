using Warteg.Console.Models;

namespace Warteg.Console.Services;

public class CheckoutServices
{
    public void Checkout(List<Cart> carts)
    {
        System.Console.WriteLine("Metode Pembayaran:");
        System.Console.WriteLine("1. Cash");
        System.Console.WriteLine("2. QRIS");

        System.Console.WriteLine();
        System.Console.Write("Pilih metode: ");
        int metode = Convert.ToInt32(System.Console.ReadLine());

        Payment payment;

        switch (metode)
        {
            case 1:
                payment = new CashPayment();
                break;
            case 2:
                payment = new QrisPayment();
                break;
            default:
                System.Console.WriteLine("Metode tidak tersedia");
                return;
        }
        decimal total = carts.Sum(item => item.Menus.Price * item.Quantity);
        bool success = payment.Pay(total);

        if (!success)
        {
            System.Console.WriteLine("Checkout Gagal");
            return;
        }

        foreach (Cart kurangiStok in carts)
        {
            kurangiStok.Menus.ReduceStock(kurangiStok.Quantity);
        }

        System.Console.WriteLine("Checkout Berhasil");
        Receipt(carts, total, payment);
        carts.Clear();

        System.Console.WriteLine();


    }

    public void Receipt(List<Cart> carts, decimal total, Payment payment)
    {
        System.Console.WriteLine("=============== RECEIPT ===============");

        foreach (Cart c in carts)
        {
            System.Console.WriteLine($"{c.Menus.Name} (x{c.Quantity}) Rp{c.Menus.Price:N0}");
        }

        System.Console.WriteLine("---------------------------------------");
        System.Console.WriteLine($"Total: Rp.{total:N0}");
        System.Console.WriteLine($"Bayar: Rp.{payment.NominalPay():N0}");
        System.Console.WriteLine($"Kembalian: Rp.{payment.Kembalian():N0}");
        System.Console.WriteLine();
        System.Console.WriteLine("Terima kasih sudah membeli!");
    }
}