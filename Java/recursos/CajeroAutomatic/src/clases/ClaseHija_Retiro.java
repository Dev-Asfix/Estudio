package clases;

/**
 *
 * @author Pablo
 */

//HEreda la clase abstracta de la clase Padre
public class ClaseHija_Retiro extends ClasePadre_Abstracta {
    
    //Para el polimorfismo 
    @Override
    
    //Reescribe el codigo del metodo que creamos en la clase padre
    public void Transacciones(){
        System.out.print("Cuanto deseas Retirar : ");
        Retiro(); //Llama al metodo
       
        //Recuperamos la variable saldo y la guardamos en la variable transacciones 
        //la condicional se asegura que cobre solo lo que tenga en su cuenta
        if(retiro <= getSaldo()){
            
            transacciones = getSaldo();
            //Usamos setter para establecer el valor de la nueva variable
            setSaldo(transacciones - retiro);
            System.out.println("-----------------------------------");
            System.out.println("Retiraste : "+ retiro);
            System.out.println("Tu saldo actual es : " + getSaldo());
            System.out.println("-----------------------------------");
        //En caso de que quiera retirar menos de su saldo 
        } else {
            System.out.println("-----------------------------------");
            System.out.println("Saldo insuficiente");
            System.out.println("-----------------------------------");
        }
    }
    
}
