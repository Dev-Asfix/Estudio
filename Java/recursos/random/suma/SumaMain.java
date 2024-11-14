package suma;

import java.util.Scanner;

public class SumaMain {
  public static void main(String args[]){
	
	Scanner in = new Scanner(System.in);
	
	System.out.println("|::SUMA::|");
	System.out.println("________________________________");												

	System.out.print("Numero 1 : ");
	int a = in.nextInt();

	System.out.print("Numero 2 : ");
	int b = in.nextInt();

	Operacion datos = new Operacion(a,b);
	datos.Resultado();
	
  }
}