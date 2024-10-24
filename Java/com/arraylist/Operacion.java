package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Operacion {

    private Scanner in;
    private ArrayList<Compra> lista;
    public double saldo;
    public int opcion = 0;

    //Contructor
    public Operacion(){
        this.in = new Scanner(System.in);
        this.lista = new ArrayList<>();
    }

    //Añadir Compra
    public void añadir(){

        if(saldo <= 0){
            System.out.println("Saldo insuficiente. No puedes añadir compras.");
            return;
        }
        System.out.print("Nombre de la compra: ");
        String compra = in.nextLine();

        System.out.print("Precio:");
        double precio = in.nextDouble();
        in.nextLine();

        if(saldo < precio){
            System.out.println("No tienes saldo suficiente para realizar esta compra.");
        } else {
            lista.add(new Compra(compra, precio));
            saldo -= precio;
            System.out.println(String.format("Compra añadida con éxito. Saldo restante: S/ %.2f",saldo));
        }
    }

    //Mostrar lista de Compras
    public void mostrar(){
        System.out.println("Lista Ordenada");
        Collections.sort(lista, Compra::compareByPrecio);
        System.out.println("Lista de Compras");
        for(Compra list : lista){
            System.out.println(list);
        }
    }
    public void ordenar(){

        mostrar();

    }

    public void elegirSaldo(){
        System.out.println("Elige el Saldo : ");
        saldo = Integer.parseInt(in.nextLine());
    }

    public void elegir(){
        System.out.println("Elige una opcion: " +
                "\n1 : Comprar"+
                "\n2 : Listar.");
        opcion = Integer.parseInt(in.nextLine());

    }


    public void bucle(){
        
        elegirSaldo();
        while(opcion != 3){
            elegir();

            if(saldo <= 0){
                System.out.println("Saldo insuficiente. No puedes añadir ");
                mostrar();
            }
                switch(opcion){
                    case 1:
                        añadir();
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                        System.out.println("Saliendo del Programa");
                        break;
                    default:
                        System.out.println("Ingresa un numero correcto");
                        
                }
        }
    }
}
