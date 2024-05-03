package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Denuncia {
    private String fecha;
    private String ubicacion;
    private String descripcion;
    private List<String> evidencia;

    public Denuncia(String fecha, String ubicacion, String descripcion) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.evidencia = new ArrayList<>();
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
}
