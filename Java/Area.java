public class Area {

    //Sobrecarga de metodos

    //Circulo
    public double calcularArea(double radio){
        return Math.PI * (radio * radio);
    }

    //Rectangulo
    public double calcularArea(double largo, double ancho){

        return largo * ancho;
    }

    //Triangulo
    public double calcularArea(double base ,double altura,boolean esTriangulo){
        return (base*altura)/2;
    }

    public static void main(String args[]){
        Area area = new Area();
        System.out.println("El area de un circulo es : " + area.calcularArea(10));
        System.out.println("El area de un rectangulo es : " + area.calcularArea(10,10));
        System.out.println("El area de un triengulo es : " + area.calcularArea(10,5,false));
    }
}
