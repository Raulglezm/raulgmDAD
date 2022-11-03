// See https://aka.ms/new-console-template for more information

using System;
public class Ejercicio1
{
    public static int diasMes(int mes)
    {
        switch (mes)
        {
            case 1:
                return 31;
                break;
            case 2:
                return 28;
                break;
            case 3:
                return 31;
                break;
            case 4:
                return 30;
                break;
            case 5:
                return 31;
            case 6:
                return 30;
                break;
            case 7:
                return 31;
                break;
            case 8:
                return 31;
                break;
            case 9:
                return 30;
            case 10:
                return 31;
                break;
            case 11:
                return 30;
                break;
            case 12:
                return 31;
                break;
        }

        return 0;

    }

    public static int diasToDDC(String fecha)
    {
        String[] split = fecha.Split("/");

        int dias = 0;

        dias += diasMes(Int32.Parse(split[1])) - Int32.Parse(split[0]);
        int mes = Int32.Parse(split[1]);

        while (mes != 5)
        {

            dias += diasMes(Int32.Parse(split[1]));
            if (mes != 12)
            {
                mes++;
            }
            else
            {
                mes = 1;
            }
        }
        return dias;
    }

    public static void Main()
    {

        Console.WriteLine("Menú\n" +
            "1 = Fecha Actual\n" +
            "2 = Fecha Manual\n");

        int opcion = Int32.Parse(Console.ReadLine());

        if (opcion == 1)
        {
            DateTime fecha = DateTime.Today;
            Console.WriteLine(diasToDDC(fecha.ToString("d")));
        }
        else
        {
            Console.WriteLine("Intoduzca el día: ");
            int dia = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Intoduzca el mes: ");
            int mes = Int32.Parse(Console.ReadLine());
            Console.WriteLine("Intoduzca el año: ");
            int anio = Int32.Parse(Console.ReadLine());

            // codigo para el apartado 1
            /*if (dia > diasMes(mes))
            {
                Console.WriteLine("La fecha introducida no es valida");
            }
            else
            {
                String fecha = dia + "/" + mes + "/" + anio;
                Console.WriteLine(diasToDDC(fecha));
            }*/
            
            // codigo para el apartado 2
            var value = new DateTime(anio, mes, dia);
            Console.WriteLine(diasToDDC(value.ToString("d")));

        }
    }
}


