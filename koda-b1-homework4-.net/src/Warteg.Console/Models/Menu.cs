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

    public void ReduceStock(int quantity)
    {
        if(Stock <= 0 || quantity < 0)
        {
            throw new ArgumentException("Stok not valid");
        }

        Stock -= quantity;
    }

    public void AddStock(int quantity)
    {
        if(quantity <= 0)
        {
            throw new ArgumentException("Quantity tidak valid");
        }
        Stock += quantity;
    }
}