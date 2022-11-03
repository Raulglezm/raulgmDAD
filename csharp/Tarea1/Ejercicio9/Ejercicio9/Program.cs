// See https://aka.ms/new-console-template for more information

using System.Numerics;

Dictionary<int, int> numeros = new Dictionary<int, int>();
Random rnd = new Random();

int random;
for (int i = 0; i < 20; i++)
{
    random = rnd.Next(10, 21);

    if (numeros.ContainsKey(random))
    {
        Console.WriteLine(random + " ya había aparecido " + numeros[random] + " veces");
        numeros[random]++;
    }
    else
    {
        numeros.Add(random, 1);
        Console.WriteLine(random + " es la primera vez que aparece");
    }
}
