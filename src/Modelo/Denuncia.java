package Modelo;

import java.util.ArrayList;
import java.util.List;

//INICIO DE LA CLASE DENUNCIA
public class Denuncia {
    private String fecha;
    private String ubicacion;
    private String descripcion;
    private List<String> evidencia;
    private Persona denunciante; // Objeto de la clase Persona que representa al denunciante

    public Denuncia(String fecha, String ubicacion, String descripcion, Persona denunciante, String evidencia) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.denunciante = denunciante;
        this.evidencia = new ArrayList<>();
        this.evidencia.add(evidencia);
    }

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(List<String> evidencia) {
        this.evidencia = evidencia;
    }

    public Persona getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Persona denunciante) {
        this.denunciante = denunciante;
    }













    
}



