// See https://aka.ms/new-console-template for more information
public class Ejercicio5
{
    public static long Factorial(int num)
    {
        if (num == 1)
        {
            return 1;
        }
        else
        {
            return num * Factorial(num - 1);
        }
    }


    public static void Main()
    {
        Console.WriteLine("Introduzca un Número");
        int num;
        num = Convert.ToInt32(Console.ReadLine());


        if (num % 2 == 0) { 
        
            Console.WriteLine("El factorial de " + num + " es " + Factorial(num));
        }
        else
        {
            Console.WriteLine(num + " no es divisible por 2");
        }
    }
}


