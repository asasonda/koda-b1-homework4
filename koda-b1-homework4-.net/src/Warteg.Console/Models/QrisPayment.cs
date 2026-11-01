namespace Warteg.Console.Models;

public class QrisPayment : Payment
{
    public decimal Nominal {get; private set;}

    public override bool Pay(decimal total)
    {
        System.Console.WriteLine("Silahkan scan Qris...");
        System.Console.WriteLine($"Total pembayaran: Rp{total}");
        
        System.Console.WriteLine("Konfirmasi pembayaran (Y/n): ");
        string? confirm = System.Console.ReadLine(); 

        if(confirm?.ToLower() != "y")
        {
            System.Console.WriteLine("Gagal Checkout");
            return false;
        }

        Nominal = total;

        System.Console.WriteLine("Pembayaran QRIS Berhasil!");
        return true;
    }

    public override string PaymentName()
    {
        return "Cash";
    }

    public override decimal NominalPay()
    {
        return Nominal;
    }

    public override decimal Kembalian()
    {
        return 0;
    }
}