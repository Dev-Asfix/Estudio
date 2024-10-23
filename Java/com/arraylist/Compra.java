package com.arraylist;

import java.util.Scanner;

public class Compra {
    public double precio;
    public String compra;
    Scanner in = new Scanner(System.in);

    public Compra(String compra, double precio){
        this.compra = compra;
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "compra : "+ compra+ " precio: S/" +precio;
    }
}
