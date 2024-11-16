package clases;

/**
 *
 * @author Pablo
 */

//Clase del metodo 
public class ClasePrincipal {

    public static void main(String args[]) {
        
        //Creamos una instancia , de igual que sea la hija ya que no es abstracta , pero esta heredada
        // POr lo que los metodos se heredan 
        ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
        
        //LLamanos al metodo para establecer el valor de saldo
        mensajero.setSaldo(500);

        //LLamamos al metodo que contiene toda la programacion 
        mensajero.Operaciones();
       
    }
}
