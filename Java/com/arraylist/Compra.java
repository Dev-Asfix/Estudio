package com.arraylist;

import java.util.Scanner;

public  class Compra implements Comparable<Compra>{
    public double precio;
    public String compra;
    Scanner in = new Scanner(System.in);

    public Compra(String compra, double precio){
        this.compra = compra;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString(){
        return "compra : "+ compra+ " precio: S/" +precio;
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return this.compra.compareTo(otraCompra.compra);
    }

    public static int compareByPrecio(Compra c1 , Compra c2){
        return Double.compare(c2.precio, c1.precio);
    }
}
