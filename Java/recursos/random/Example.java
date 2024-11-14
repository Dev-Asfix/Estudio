//¿Cúal es el problema especifico?
	//Hallar el IGV
//¿Por qué es un problema?
	//Por que el cliente necesita saber su precio final de manera rapida y eficiente
//¿Qué resultados esperas obtener?
	//El valor del IGV y el Precio Final

//¿Qúe datos necesitas ?
	//Numero 1 y Numero 2 ,SumaTotal , IGV
//¿Cuales son las limitaciones y restrucciones?
	//Solo Numeros
//¿Quiénes son los usuarios o partes interesadas?
	//Clientes

import java.util.Scanner;

public class Example {
    public static void main(String args[]){

	Scanner in = new Scanner(System.in);
	int numero;
	short radical , resultado;
	
	System.out.print("Numero : ");
	numero = in.nextInt();
	
	System.out.print("Exponente : ");
	radical = in.nextShort();

	resultado = (short)Math.pow(numero,1.0/radical);
		
	System.out.println("El Radical es : " + resultado);

 }
}





