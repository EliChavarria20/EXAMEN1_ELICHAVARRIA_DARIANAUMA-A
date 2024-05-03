package Vista;

import javax.swing.SwingUtilities;

import Controlador.InterfazGrafica;
import Modelo.SistemaSeguimiento;

public class Main {
    public static void main(String[] args) {
        // Inicializar el sistema de seguimiento
        SistemaSeguimiento sistema = new SistemaSeguimiento();
        

        // Crear la interfaz gráfica y mostrarla
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfaz = new InterfazGrafica(sistema);
            interfaz.setVisible(true);
        });
    }
}
