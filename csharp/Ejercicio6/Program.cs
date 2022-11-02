// See https://aka.ms/new-console-template for more information

using System;
using System.Collections;

int num = 0;
ArrayList numeros = new ArrayList();

while (num != -1)
{
    Console.WriteLine("Introduzca un Número");
    num = Convert.ToInt32(Console.ReadLine());
    if (num != -1){
        numeros.Add(num);
    }
}

numeros.Sort();

int vecesRepetido = 0;
int maxvecesRepetido = 0;
int masRepetido = 0;

for (int i = 0; i <= numeros.Count-1; i++)
{
    for (int j = 0; j <= numeros.Count-1; j++)
    {
        if(Convert.ToInt32(numeros[i]) == Convert.ToInt32(numeros[j])){
            vecesRepetido ++;
        }
    }

    if(maxvecesRepetido < vecesRepetido){
        maxvecesRepetido = vecesRepetido;
        masRepetido = Convert.ToInt32(numeros[i]);
    }

    vecesRepetido = 0;
}

Console.WriteLine("El numero más pequeño es: " + numeros[0]);
Console.WriteLine("El numero más grande es: " + numeros[numeros.Count-1]);
Console.WriteLine("El numero más repetido es: " + masRepetido);