package com.arraylist;



import java.util.ArrayList;
import java.util.Scanner;


public class Operacion {

    public int opcion = 0;
    Scanner in = new Scanner(System.in);
    ArrayList<Compra> lista = new ArrayList<>();

    public void añadir(){
        System.out.print("Nombre : ");
        String compra = in.nextLine();
        System.out.print("Precio:");
        double precio = in.nextDouble();
        in.nextLine();
        lista.add(new Compra(compra,precio));
    }

    public void mostrar(){
        System.out.println("Lista de Compras");
        for(Compra list : lista){
            System.out.println(list);
        }
    }

    public void elegir(){
        System.out.print("Elige una opcion: ");
        opcion = in.nextInt();
        in.nextLine();
    }

    public void bucle(){


        while(opcion != 3){
            elegir();
            if(opcion == 1){
                añadir();

            } else if(opcion == 2){
                mostrar();
                break;
            } else if(opcion == 3){
                System.out.println("Saliendo del Programa");
            } else {
                System.out.println("ELige un numero correcto");
            }
        }
    }

}
