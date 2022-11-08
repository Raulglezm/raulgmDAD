// See https://aka.ms/new-console-template for more information

using System;
using System.Collections;

public class Ejercicio3
{
    public static void contarCodones(ArrayList codones)
    {
        int top = 0;
        int contador = 0;
        String ganador = "FFF";

        String anterior = "";
        foreach (String codon1 in codones)
        {
            if (!codon1.Equals(ganador))
            {
                foreach (String codon2 in codones)
                {
                    if (codon1.Equals(codon2))
                    {
                        contador++;
                    }
                }

                if (contador > top)
                {
                    top = contador;
                    ganador = codon1;
                }
                else if (contador == top)
                {
                    ganador = "";
                }
                contador = 0;
            }
        }

        if (!ganador.Equals(""))
        {
            Console.WriteLine("El codón que se repite más veces es " + ganador);
        }
        else
        {
            Console.WriteLine("Mas de un codones se repetia el mismo número de veces");
        }
    }

    public static void baseMasSeguida(String cadena)
    {
        int top = 0;
        int contador = 0;
        String ganadora = "F";

        String actual, anterior = "";
        try
        {

            for (int i = 0; i < cadena.Length; i++)
            {

                actual = cadena.Substring(i, 1);

                if (actual.Equals(anterior))
                {
                    contador++;
                }
                else
                {
                    contador = 1;
                }

                anterior = actual;

                if (contador > top)
                {
                    top = contador;
                    ganadora = actual;
                }
                else if (contador == top)
                {
                    ganadora = "";
                }
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e.GetBaseException());
        }

        if (!ganadora.Equals(""))
        {

            Console.WriteLine("La base que se repite seguida mas veces es " + ganadora + " con " + top + " repeticiones");
        }
        else
        {
            Console.WriteLine("Mas de una base se repetia seguidamente el mismo número de veces");
        }
    }

    public static Dictionary<string, int> contarBases(String cadena)
    {
        Dictionary<string, int> bases = new Dictionary<string, int>();

        bases.Add("A", 0);
        bases.Add("C", 0);
        bases.Add("G", 0);
        bases.Add("T", 0);

        String bas = "";
        for (int i = 0; i < cadena.Length; i++)
        {
            bas = cadena.Substring(i, 1);


            if (bas.Equals("A"))
            {
                bases["A"] = bases["A"] + 1;
            }
            else if (bas.Equals("C"))
            {
                bases["C"] = bases["C"] + 1;
            }
            else if (bas.Equals("G"))
            {
                bases["G"] = bases["G"] + 1;
            }
            else if (bas.Equals("T"))
            {
                bases["T"] = bases["T"] + 1;
            }
        }

        return bases;
    }

    public static ArrayList crearCodones(String cadena)
    {
        ArrayList codones = new ArrayList();

        String codon = "";
        try
        {
            for (int i = 0; i < cadena.Length - 2; i++)
            {
                codon = cadena.Substring(i, 3);
                codones.Add(codon);
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e.GetBaseException());
        }

        return codones;
    }

    public static String crearCadena()
    {
        String bases = " ";
        String cadena = "";
        while (!bases.Equals("F"))
        {
            Console.WriteLine("Introduce una letra");
            bases = Console.ReadLine();

            if (bases.Equals("A") || bases.Equals("C") || bases.Equals("G") || bases.Equals("T"))
            {
                cadena += bases;
            }
        }

        return cadena;
    }

    public static void PrintValues(ArrayList codones)
    {
        foreach (Object obj in codones)
        {
            Console.Write("   {0}", obj);
            Console.WriteLine();
        }
    }

    public static void mostrarBases(Dictionary<string, int> bases)
    {
        Console.WriteLine(
            bases["A"] + " A, " +
            bases["C"] + " C, " +
            bases["G"] + " G, " +
            bases["T"] + " T, ");
    }

    public static void Main()
    {
        Console.WriteLine("Introduce la cadena ADN");
        String cadena = crearCadena();

        ArrayList codones = crearCodones(cadena);

        Dictionary<string, int> bases = contarBases(cadena);

        mostrarBases(bases);
        baseMasSeguida(cadena);
        contarCodones(codones);
    }
}