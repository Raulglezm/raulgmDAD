// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduzca un Número");
int cantidad;
cantidad = Convert.ToInt32(Console.ReadLine());

for (int i = 1; i <= cantidad; i++)
{
    for (int j = 1; j <= i; j++)
    {
        Console.Write("*");     
    } 
    Console.WriteLine(); 
}


for (int i = cantidad -1; i >= 1; i--)
{
    for (int j = i; j >= 1; j--)
    {
        Console.Write("*");     
    } 
    Console.WriteLine(); 
}