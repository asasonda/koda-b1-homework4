namespace Warteg.Console.Models;

public class Category(string name, decimal price, int stock, string categoryName) : Menu(name, price, stock)
{
    public string CategoryName { get; set; } = categoryName;
}