package Modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaSeguimiento {
    private List<Denuncia> denuncias;

    public SistemaSeguimiento() {
        this.denuncias = new ArrayList<>();
    }

    public void registrarDenuncia(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public Denuncia[] getDenuncias() {
        return denuncias.toArray(new Denuncia[0]);
    }

    public Denuncia buscarDenunciaPorFecha(String fecha) {
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getFecha().equals(fecha)) {
                return denuncia;
            }
        }
        return null;
    }
}
