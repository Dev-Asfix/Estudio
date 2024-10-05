public class Persona {
    private String nombre ;
    private int edad;

    public Persona(String nombres, int edades){
        this.nombre = nombres;
        this.edad = edades;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void mostrarInfo(){
        System.out.println("El nombre es : " + getNombre() + " y su edad es : " + getEdad()) ;
    }

    public static void main(String [] args){
        Persona objeto = new Persona("Pablo",19);
        objeto.mostrarInfo();
        objeto.setNombre("Aldair");
        objeto.setEdad(10);

        objeto.mostrarInfo();
    }

}