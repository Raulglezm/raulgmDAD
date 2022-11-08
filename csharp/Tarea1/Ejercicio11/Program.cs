// See https://aka.ms/new-console-template for more information
public class Ejercicio11
{

    public static void Main()
    { 
        String menu = "1: mostrar archivo" +
            "\n2: Añadir un texto al final del Archivo" +
            "\n3: Borrar una palabara y nos devolverá el texto de nuevo pero son la palabara" +
            "\n4: Guardar el archivo con el mismo nombre\n5: salir";
        Console.WriteLine(menu);

        StreamReader archivoRead;
        StreamWriter archivoWrite;
        List<String> lineas = new List<String>();
        String palabra;

        int opcion = Int32.Parse(Console.ReadLine());

        while(opcion != 5)
        {
            if (opcion == 1)
            {
                try
                {
                    archivoRead = new StreamReader("texto.txt");
                    while (!archivoRead.EndOfStream)
                    {
                        Console.WriteLine(archivoRead.ReadLine());
                    }
                    archivoRead.Close();
                }catch(Exception e) { }
            }else if(opcion == 2)
            {
                archivoWrite = new StreamWriter("texto.txt", true);

                if (archivoWrite != null)
                {
                    Console.WriteLine("Escriba el texto a añadir y pulse enter: ");
                    archivoWrite.WriteLine(Console.ReadLine());
                }

                archivoWrite.Close();
            }else if(opcion == 3)
            {
                archivoRead = new StreamReader("texto.txt");
                Console.WriteLine("Introduce la palabara que desea Borrar");
                palabra = Console.ReadLine();
                while (!archivoRead.EndOfStream)
                {
                    lineas.Add(archivoRead.ReadLine().Replace(palabra, ""));
                }

                archivoRead.Close();
                archivoWrite = new StreamWriter("texto.txt", true);

                foreach (String linea in lineas)
                {
                    archivoWrite.WriteLine(linea);    
                }
                archivoWrite.Close();
            }else if(opcion == 4)
            {
                Console.WriteLine("El archivo ya se guarda automaticamente");
            }
            else if(opcion == 5)
            {
                Console.WriteLine("Adios");
            }
        }
    }
}
