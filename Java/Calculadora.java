public class Calculadora {
    public int sumar(int a , int b){

        return a + b;
    }

    public int restar(int a , int b){
        return a - b;
    }

    public int multiplicar(int a , int b){
        return a*b;

    }

    public int dividir(int a,  int b){
        if(b != 0){
            return a/b;
        } else {
            System.out.println("Error al dividir por cero");
            return 0;
        }
    }

    public static void main(String []args){
        Calculadora operacion = new Calculadora();

        System.out.println("La suma es : " + operacion.sumar(5, 5));
        System.out.println("LA Resta es : " + operacion.restar(20,10));
        System.out.println("La multiplicacion es : " + operacion.multiplicar(2,5));
        System.out.println("La division es : " + operacion.dividir(20,0));

    }
}
