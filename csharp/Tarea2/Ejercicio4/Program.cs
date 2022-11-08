// See https://aka.ms/new-console-template for more information

using System.IO;
using System.Collections.Generic;
using System;

class Tiempo
{
    StreamReader archivo;

    List<double> maximas = new List<double>();
    List<double> minimas = new List<double>();
    List<double> medias = new List<double>();

    public double calcularMedias(List<double> temperaturas)
    {
        double total = 0;
        int registros = 0;

        foreach (double temp in temperaturas)
        {
            total += temp;
            registros++;
        }
        return truncate((truncate(total, 2) / registros), 2) ;
    }

    public void leerArchivo(String ruta){
        try
        {
            archivo = new StreamReader(File.OpenRead(ruta));
            double num;
            while (!archivo.EndOfStream)
            {

                var linea = archivo.ReadLine();
                var valores = linea.Split(",");

                maximas.Add(truncate(Double.Parse(valores[0].Replace(".", ",")), 2));
                minimas.Add(truncate(Double.Parse(valores[1].Replace(".", ",")), 2));
                medias.Add(truncate(Double.Parse(valores[2].Replace(".", ",")), 2));

            }
        }catch(Exception e)
        {
            Console.WriteLine(e.GetBaseException());
        }

    }

    public double truncate(double value, int decimales)
    {
        double aux_value = Math.Pow(10, decimales);
        return (Math.Truncate(value * aux_value) / aux_value);
    }

    public List<double> getMaximas()
    {
        return maximas;
    }    
    public List<double> getMinimas()
    {
        return minimas;
    }    
    
    public List<double> getMedias()
    {
        return medias;
    }
}



public class Ejercicio4
{
    public static void Main()
    {

        Tiempo tiempo = new Tiempo();

        tiempo.leerArchivo("C:\\Users\\Usuario\\Documents\\GitHub\\raulgmDAD\\csharp\\Tarea2\\Ejercicio4\\csv.csv");

        Console.WriteLine("La media de las temperaturas maximas es "+ tiempo.calcularMedias(tiempo.getMaximas()));
        Console.WriteLine("La media de las temperaturas minimas es "+ tiempo.calcularMedias(tiempo.getMinimas()));
        Console.WriteLine("La media de las temperaturas medias es "+ tiempo.calcularMedias(tiempo.getMedias()));

    }
}