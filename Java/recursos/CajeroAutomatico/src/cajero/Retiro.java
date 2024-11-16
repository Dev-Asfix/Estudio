
package cajero;

/**
 *
 * @author Pablo
 */
public class Retiro extends Funciones{
    
    @Override
    public void Operar(){
        System.out.print("Cuánto deseas retirar :");
        Retiro = in.nextInt();
        Saldo = Saldo - Retiro;
        
        System.out.println("----------------------------------");
        System.out.println("Retiraste: "+ Retiro);
        System.out.println("Tu saldo actual es: "+ Saldo);
        System.out.println("----------------------------------");        
    }
    
}
