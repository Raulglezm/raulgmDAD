// See https://aka.ms/new-console-template for more information
Console.WriteLine("Introduce un numero de 8 digitos");

string letras = "TRWAGMYFPDXBNJZSQVHLCKET";
int dniNum;
dniNum = Convert.ToInt32(Console.ReadLine());

int resultado = dniNum % 23;

char dniLetra = letras[resultado];

Console.WriteLine(dniNum+""+dniLetra);
