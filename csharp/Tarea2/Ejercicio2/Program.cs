// See https://aka.ms/new-console-template for more information

using System;

public class Ejercicio2
{

    public static int countPalabras(String texto, String palabra)
    {
        int veces = 0;

        String[] split = texto.Split(" ");

        for (int i = 0; i < split.Length; i++)
        {
            if (split[i].Equals(palabra))
            {
                veces ++;
            }
        }
        return veces;
    }


    public static String replacefrase(String texto, String palabra, int metodo)
    {

        if (metodo == 2)
        {
            Console.WriteLine("Introduce la nueva palabra");
            String newPalabra = Console.ReadLine();
            texto = texto.Replace(palabra, newPalabra);

        }
        else if (metodo == 3)
        {
            texto = texto.Replace(palabra, "");
        }


        return texto;
    }

    public static void Main()
    {
        Console.WriteLine("Introduce el texto con el que desea trabajar: ");

        String texto = Console.ReadLine();

        String menu = "Menú \n 1 = buscar palabra \n 2 = remplaza palabra \n 3 = borrar palabra \n 4 = salir";

        Console.WriteLine(menu);

        int metodo = Int32.Parse(Console.ReadLine());

        while (metodo != 4)
        {
            Console.WriteLine("Introduce la palabra con la que desea trabajar");
            String palabra = Console.ReadLine();
            if (metodo > 1)
            {
                texto = replacefrase(texto, palabra, metodo);
                Console.WriteLine(texto);
            }
            else
            {
                Console.WriteLine("Se han encontrado "+ countPalabras(texto, palabra)+ " " + palabra) ;
            }

            Console.WriteLine(menu);
            try
            {
                metodo = Int32.Parse(Console.ReadLine());
            }
            catch (Exception e) {
                Console.WriteLine("El metodo introducido no es valido");
                metodo = 4;
            }
        }
    }
}