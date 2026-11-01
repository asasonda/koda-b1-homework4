using Warteg.Console.Interfaces;

namespace Warteg.Console.Models;

public abstract class Payment : IPaymentable
{
    public abstract bool Pay(decimal total);
    public abstract string PaymentName();
    public abstract decimal NominalPay();
    public abstract decimal Kembalian();
}