// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduce tu peso en KG");

double peso;
peso = Convert.ToDouble(Console.ReadLine());

Console.WriteLine("Introduce tu altura en metros");

double altura;
altura = Convert.ToDouble(Console.ReadLine());


Console.WriteLine("Su indice de masa corporal es : " + (peso/(altura*altura)));