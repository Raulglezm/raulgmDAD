// See https://aka.ms/new-console-template for more information

static class Calculadora
{
    public static double operar(int v1, int v2, String operador)
    {
        switch (operador)
        {

            case "+":
                return v1 + v2;
                break;

            case "-":
                return  v1 - v2;
                break;

            case "*":
                return v1 * v2;
                break;

            case "/":
                return v1 / v2;
                break;
        }
        return 0;
    }
}


public class Ejercicio8
{ 
    public static void Main()
    {
        Console.WriteLine("--Menú--");
        Console.WriteLine("Sumar = +");
        Console.WriteLine("Restar = -");
        Console.WriteLine("Multiplicar = *");
        Console.WriteLine("Dividir = /");
        Console.WriteLine("Salir = exit");

        String operacion = " ";
        int v1 = 0;
        int v2 = 0;
        int resultado = 0;
        do
        {
            try
            {
                Console.WriteLine("Introduzca un Número");
                v1 = Int32.Parse(Console.ReadLine());
                Console.WriteLine("Introduzca un Número");
                v2 = Int32.Parse(Console.ReadLine());
            }
            catch (Exception e)
            {
                Console.WriteLine("Los valores introducidos no son correctos");
            }

            Console.WriteLine("Introduzca la operacion");
            operacion = Console.ReadLine();

            if (!operacion.Equals("exit"))
            {
                Console.WriteLine(v1 + " " + operacion + " " + v2 + " = " + Calculadora.operar(v1, v2, operacion));
            }


        } while (!operacion.Equals("exit"));
    }
}




