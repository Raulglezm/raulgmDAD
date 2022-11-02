// See https://aka.ms/new-console-template for more information

Console.WriteLine("Introduzca un Número");
int num;
num = Convert.ToInt32(Console.ReadLine());


if (num % 2 == 0){
    double resultado = 1;
    for (int i = num; i >= 1; i--)
    {
        resultado *= i;
    }
    Console.WriteLine("El factorial de "+num+ " es "+ resultado);
}else{
    Console.WriteLine(num+" no es divisible por 2");
}


