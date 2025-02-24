package com.dev;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String args[]){
        Stack<String> pila = new Stack<>();

        System.out.println(pila);

        pila.push("java");
        pila.push("Python");
        pila.push("C++");
        System.out.println("Pila" + pila);

        System.out.println("Ultimo : " + pila.peek());

        pila.pop();
        System.out.println("Pila despues de pop " + pila);

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

        Queue<String> cola = new LinkedList<>();

        cola.offer("Cliente 1");
        cola.offer("Cliente 2");
        cola.offer("Cliente 3");
        System.out.println( "Cola : " + cola);

        cola.poll();
        System.out.println("Cola despues de atender a un cliente _ " + cola);

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

        HashMap<String, Integer> edades = new HashMap<>();

        edades.put("Pablo", 25);
        edades.put("Ana", 30);
        edades.put("Carlos" , 25);
        System.out.println("edades : " +edades);

        // Obtener el valor de una clave
        System.out.println("Edad de Ana: " + edades.get("Ana"));

        edades.remove(25);
        System.out.println("Edades : " + edades);
    }
}
