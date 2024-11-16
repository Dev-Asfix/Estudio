package clases;

import java.util.Scanner; //Paquete para poder importar la libreria Scanner

/**
 *
 * @author Pablo
 */
//Como tenemos metodos abstractos  la Clase tambien deve ser abstracta
public abstract class ClasePadre_Abstracta {

    //Protected va para la herencia y polimorfismo , ademas es una variable 
    //De ambito global , tambien conocido como variable de instancia-
    protected int transacciones, retiro, deposito;

    //Una variable de clase , se puede compartir con las demas clases , sin 
    //tener que crear un objeto
    private static int saldo;
    Scanner in = new Scanner(System.in); //Creamos el objeto

    //Este es el metodo de Operaciones donde va la logica
    public void Operaciones() {

        //Variables de ambito Local
        int bandera = 0;
        int seleccion = 0;

        //Inicia el Doble  "Do" para el bucle
        do {
            do {

                System.out.println("Por favor seleccione una opcion:");
                System.out.println("    1. Consulta de saldo.");
                System.out.println("    2. Retiro de efectivo.");
                System.out.println("    3. Deposito de efectivo.");
                System.out.println("    4. Salir.");
                seleccion = in.nextInt();

                //Mientras se cumpla la condicion ,El bucle se repetira, para
                //que se asegure de que el usuario ingrese una opcion Correcta
                if (seleccion >= 1 && seleccion <= 4) {

                    //la bandera es una variable que uso para controlar el bucle
                    bandera = 1;

                } else {
                    System.out.println("--------------------------------------------");
                    System.out.println("Opcion no disponible , vuelva a intentar ");
                    System.out.println("--------------------------------------------");
                }

            } while (bandera == 0); //Condicion para que acabe el primer bucle

            //Pertenece el primer "DO" y procede a implementar condicionales para las 
            //Diferentes opciones que el usuario elija
            if (seleccion == 1) {

                //Esta es una instancia pero para los metodos Absractos 
                ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
                mensajero.Transacciones();

            } else if (seleccion == 2) {

                ClasePadre_Abstracta mensajero = new ClaseHija_Retiro();
                mensajero.Transacciones();

            } else if (seleccion == 3) {

                ClasePadre_Abstracta mensajero = new ClaseHija_Depositar();
                mensajero.Transacciones();

            } else if (seleccion == 4) {
                System.out.println("--------------------------------------------");
                System.out.println("Gracias, Vuelva pronto.");
                System.out.println("--------------------------------------------");
                bandera = 2; // La bandera se encarga de el bucle se repita , hasta que se salga con la opcion 4 que es salir
            }

        } while (bandera != 2); // Cuanto la condicion sea diferente de 2 , se acaba el bucle , pero primero hace lo que tiene en "DO"
    }

    //Metodo para solicitar cantidad de retiro
    public void Retiro() {
        retiro = in.nextInt();
    }

    //Metodo para solicitar deposito
    public void Deposito() {
        deposito = in.nextInt();
    }

    //Metodo abstracto
    public abstract void Transacciones();

    //Metodos setter y getter
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
