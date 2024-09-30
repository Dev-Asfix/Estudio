import java.util.Scanner;
public class Main {

    Scanner in = new Scanner(System.in);
    public int saldo = 500;
    public int deposito= 0;
    public int retiro= 0;
    public int opcion = 0;


    public void bienvenida(){
        System.out.println("""
                  ----------------------------------
                Bienvenido al Banco Stark
                ----------------------------------

                """);
    }
    public void menu(){
        System.out.println("""
                Opciones:
                1. Consultar saldo
                2. Retirar dinero
                3. Depositar dinero
                9. Salir
                
                Ingrese el número de la opción deseada:
                """);
        opcion = in.nextInt();
        while(opcion != 1 && opcion!=2 && opcion !=3 && opcion!=9 ){
            System.out.println("** Ingresa una opcion Valida **");
            System.out.println("""
                Opciones:
                1. Consultar saldo
                2. Retirar dinero
                3. Depositar dinero
                9. Salir
                
                Ingrese el número de la opción deseada:
                """);
            opcion = in.nextInt();
        }

    }

    public void consultarSaldo(){
        System.out.println("Tienes un saldo de : S/" + saldo);

    }

    public void retirar(){
        System.out.println("Cuánto dinero deseas retirar?");
        retiro = in.nextInt();
        while(retiro > saldo){
            System.out.println("Ingresa un numero Valido");
            retiro = in.nextInt();
        }
        saldo = saldo - retiro;
        System.out.println("Se retiro "+retiro);
    }

    public void depositar(){
        System.out.println("Cuánto dinero deseas depositar?");
        deposito  = in.nextInt();
        saldo = saldo + deposito;
        System.out.println("Se deposito S/"+deposito);

    }

    public void salir(){
        System.out.println("Muchas Gracias");
        System.exit(0);
    }

    public void operacion(){
        bienvenida();
        do{
            menu();
            switch (opcion){
                case 1 -> consultarSaldo();
                case 2 -> retirar();
                case 3 -> depositar();
                case 9 -> salir();
                default -> System.out.println("Elige una opcion Valida");
            }
        }while(opcion!=9);

    }

    public static void main(String []args){
        Main in = new Main();
        in.operacion();
    }
}