namespace Warteg.Console.Models;

public class Cart(Menu menus, int quantity)
{
    public Menu Menus = menus;
    public int Quantity { get; set; } = quantity;
    
    
}