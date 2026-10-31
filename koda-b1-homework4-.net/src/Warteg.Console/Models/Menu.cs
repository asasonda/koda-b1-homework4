namespace Warteg.Console.Models;

public class Menu(string name, decimal price, int stock)
{
    public string Name { get; set; } = name;
    public decimal Price { get; private set; } = price;
    public int Stock { get; private set; } = stock;

    public string GetMenu()
    {
        return $"{Name} Rp.{Price:N0} (Stock: {Stock})";
    }
}