package clases;

/**
 *
 * @author Pablo
 */

// Heredamos la clase Abstracta de la clase Padre
public class ClaseHija_Consulta extends ClasePadre_Abstracta {
    
    
    //Necesario para el POlimorfismo
    @Override
    //El metodo que declaramos anteriormente y lo reescribimos para esta clase
    public void Transacciones(){
        System.out.println("----------------------------------");
        System.out.println("Tu saldo actual es : " + getSaldo());
        System.out.println("----------------------------------");
    }

    
}
