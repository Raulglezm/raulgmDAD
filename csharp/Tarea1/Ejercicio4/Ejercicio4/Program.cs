// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduce un numero");

int num1;
num1 = Convert.ToInt32(Console.ReadLine());

Console.WriteLine("Introduce otro numero");

int num2;
num2 = Convert.ToInt32(Console.ReadLine());

if (num1 > num2)
{
    Console.WriteLine(num1 + " es mayor que " + num2);
}
else if (num1 < num2)
{
    Console.WriteLine(num1 + " es menor que " + num2);
}
else
{
    Console.WriteLine(num1 + " obviamente es igual que " + num2);
}