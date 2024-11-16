package cajero;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Funciones {
    
    Scanner in = new Scanner(System.in);
    protected static int Saldo = 500, Opcion , Deposito , Retiro;
    
    public void PedirOpcion(){
        System.out.println("Por favor, selecciona una opcion:"
                + "\n   1. Consulta de saldo."
                + "\n   2. Retiro de efectivo."
                + "\n   3. Deposito de efectivo."
                + "\n   4. Salir.");
        
        Opcion = in.nextInt();
        
    }
    public void Operar(){
       
    }
    
    public int getOpcion(){
        return Opcion;
    }
    public void setOpcion(int Opcion){
        this.Opcion = Opcion;
    }
    
}
