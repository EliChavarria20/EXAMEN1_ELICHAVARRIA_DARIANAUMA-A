package Modelo;


public class Persona extends Denuncia{

    public Persona(String fecha, String ubicacion, String descripcion) {
        super(fecha, ubicacion, descripcion);
      
    }

    private String nombre;
    private int edad;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
