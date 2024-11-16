package clases;

/**
 *
 * @author Pablo
 */

//Hereda la clase abstracta de la clase Padre
public class ClaseHija_Depositar extends ClasePadre_Abstracta {
    
    //Para poder usar el polimorfismo
    @Override
    
    //Metodo que creamos en la clase padre , abstracta
    public void Transacciones(){
        System.out.print("Cuanto deseas depositar: ");
        Deposito();
        
        //Recuperamos el saldo 
        transacciones = getSaldo();
        //Hacemos la logica de Depositar , ademas de que actualizamos la variable saldo con el setter
        setSaldo(transacciones + deposito);

        //Se imprime el saldo
        System.out.println("-----------------------------------");
        System.out.println("Depositaste : " + deposito);
        System.out.println("Tu saldo actual es : " + getSaldo());
        System.out.println("-----------------------------------");
    }
    
}
