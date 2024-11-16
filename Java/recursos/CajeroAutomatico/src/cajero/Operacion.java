package cajero;

/**
 *
 * @author Pablo
 */
public class Operacion extends Funciones {

    Funciones opcion = new Funciones();
    Consulta consultar = new Consulta();
    Retiro retirar = new Retiro();
    Deposito depositar = new Deposito();

    public void Condicional() {

        do {

            PedirOpcion();

            switch (opcion.getOpcion()) {

                case 1:
                    consultar.Operar();
                    break;
                case 2:
                    retirar.Operar();
                    break;
                case 3:
                    depositar.Operar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("----------------------------------");
                    System.out.println("INGRESA UNA OPCION VALIDA");
                    System.out.println("----------------------------------");
                    break;

            }

        } while (opcion.getOpcion() != 4);

    }

}
