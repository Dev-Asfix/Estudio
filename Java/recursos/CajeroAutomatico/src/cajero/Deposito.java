/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

/**
 *
 * @author Pablo
 */
public class Deposito extends Funciones{
    
    @Override
    public void Operar(){
        System.out.print("Cuánto deseas depositar:");
        Deposito = in.nextInt();
        Saldo = Saldo + Deposito;
        
        System.out.println("----------------------------------");
        System.out.println("Depositaste: "+ Deposito);
        System.out.println("Tu saldo actual es: "+ Saldo);
        System.out.println("----------------------------------");        
    }
    
    
}
