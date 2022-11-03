// See https://aka.ms/new-console-template for more information

Random rnd = new Random();

int aleatorio = rnd.Next(0, 101);
int intento = -1;

while (aleatorio != intento)
{
    Console.WriteLine("Introduce un número");

    try
    {
        intento = Int32.Parse(Console.ReadLine());

        if (intento > aleatorio)
        {
            Console.WriteLine(intento + " > aleatorio");
        }
        else if (intento < aleatorio)
        {
            Console.WriteLine(intento + " < aleatorio");
        }
        else
        {
            Console.WriteLine("Felicidades el numero secreto era " + aleatorio);
        }
    }
    catch (Exception e)
    {
        Console.WriteLine("El dao introducido no es un número");
    }
}



