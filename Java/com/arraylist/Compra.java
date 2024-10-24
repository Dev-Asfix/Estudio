package com.arraylist;

public  class Compra implements Comparable<Compra>{
    private double precio;
    private String compra;

    // Contructor
    public Compra(String compra, double precio){
        this.compra = compra;
        this.precio = precio;
    }

    // Getters
    public double getPrecio() {
        return precio;
    }

    //Sobrescribit toString para representar correctamente el onjeto Compra
    @Override
    public String toString(){
        return String.format("Compra: %s | Precio: S/ %.2f", compra,precio);
    }

    //Comparar por nombre
    @Override
    public int compareTo(Compra otraCompra) {
        return this.compra.compareTo(otraCompra.compra);
    }

    public static int compareByPrecio(Compra c1 , Compra c2){
        return Double.compare(c2.precio, c1.precio);
    }
}
