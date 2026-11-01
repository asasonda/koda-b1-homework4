namespace Warteg.Console.Models;

public class CashPayment : Payment
{
    public decimal Nominal {get; private set;}
    public decimal Change {get; private set;}

    public override bool Pay(decimal total)
    {
        System.Console.Write("Masukan uang: ");
        Nominal = Convert.ToDecimal(System.Console.ReadLine());

        if(Nominal < total)
        {
            System.Console.WriteLine("Uang tidak mencukupi!");
            return false;
        }

        Change = Nominal - total;
        System.Console.WriteLine("Pembayaran Cash Berhasil");
        
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
        return Change;
    }
}