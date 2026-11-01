namespace Warteg.Console.Interfaces;

public interface IPaymentable
{
    bool Pay(decimal total);
    string PaymentName();
    decimal NominalPay();
    decimal Kembalian();
}