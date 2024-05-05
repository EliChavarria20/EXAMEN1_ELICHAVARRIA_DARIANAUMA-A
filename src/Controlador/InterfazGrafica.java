package Controlador;

import javax.swing.*;

import Modelo.Denuncia;
import Modelo.SistemaSeguimiento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private SistemaSeguimiento sistema;
    private JButton btnAgregarDenuncia;
    private JButton btnMostrarDenuncia;
    private JButton btnBuscarDenuncia;
    private JButton btnSalir;

    public InterfazGrafica(SistemaSeguimiento sistema) {
        this.sistema = sistema;
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Seguimiento de Denuncias");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botones
        btnAgregarDenuncia = new JButton("Agregar Denuncia");
        configurarBoton(btnAgregarDenuncia);
        btnAgregarDenuncia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarDenuncia();
            }
        });

        btnMostrarDenuncia = new JButton("Mostrar Denuncia");
        configurarBoton(btnMostrarDenuncia);
        btnMostrarDenuncia.addActionListener(e -> mostrarDenuncia());

        btnBuscarDenuncia = new JButton("Buscar Denuncia");
        configurarBoton(btnBuscarDenuncia);
        btnBuscarDenuncia.addActionListener(e -> buscarDenuncia());

        btnSalir = new JButton("Salir");
        configurarBoton(btnSalir);
        btnSalir.addActionListener(e -> salir());

        panel.add(btnAgregarDenuncia);
        panel.add(btnMostrarDenuncia);
        panel.add(btnBuscarDenuncia);
        panel.add(btnSalir);

        add(panel);
    }

    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
        boton.setPreferredSize(new Dimension(200, 40));
    }

    private void agregarDenuncia() {
        JTextField txtFecha = new JTextField(10);
        JTextField txtUbicacion = new JTextField(10);
        JTextArea txtDescripcion = new JTextArea(5, 20);
        JTextField txtNombre = new JTextField(10);
        JTextField txtEdad = new JTextField(10);
        JTextField txtEvidencia = new JTextField(10); // Nuevo campo para la evidencia

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Fecha:"));
        panel.add(txtFecha);
        panel.add(new JLabel("Ubicación:"));
        panel.add(txtUbicacion);
        panel.add(new JLabel("Descripción:"));
        panel.add(new JScrollPane(txtDescripcion));
        panel.add(new JLabel("Nombre de la Persona:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Edad de la Persona:"));
        panel.add(txtEdad);
        panel.add(new JLabel("Evidencia:")); // Nuevo campo para la evidencia
        panel.add(txtEvidencia);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Denuncia",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String fecha = txtFecha.getText();
            String ubicacion = txtUbicacion.getText();
            String descripcion = txtDescripcion.getText();
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String evidencia = txtEvidencia.getText(); // Obtener la evidencia ingresada por el usuario

            // Crear una lista para almacenar la evidencia
            List<String> listaEvidencia = new ArrayList<>();
            listaEvidencia.add(evidencia);

            Denuncia nuevaDenuncia = new Denuncia(fecha, ubicacion, descripcion, nombre, edad, evidencia);

            sistema.registrarDenuncia(nuevaDenuncia);
            JOptionPane.showMessageDialog(null, "Denuncia agregada correctamente.");
        }
    }

    private void mostrarDenuncia() {
        Denuncia[] denuncias = sistema.getDenuncias();
        if (denuncias.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay denuncias registradas.");
        } else {
            StringBuilder mensaje = new StringBuilder("Listado de denuncias:\n\n");
            for (Denuncia denuncia : denuncias) {
                mensaje.append("Fecha: ").append(denuncia.getFecha()).append("\n");
                mensaje.append("Ubicación: ").append(denuncia.getUbicacion()).append("\n");
                mensaje.append("Descripción: ").append(denuncia.getDescripcion()).append("\n");
                mensaje.append("Evidencia: ").append(denuncia.getEvidencia()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    private void buscarDenuncia() {
        JTextField txtFechaBusqueda = new JTextField(10);
        JPanel panelBusqueda = new JPanel(new GridLayout(1, 2));
        panelBusqueda.add(new JLabel("Fecha de la denuncia:"));
        panelBusqueda.add(txtFechaBusqueda);

        int result = JOptionPane.showConfirmDialog(null, panelBusqueda, "Buscar Denuncia",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String fechaBusqueda = txtFechaBusqueda.getText();
            Denuncia denunciaEncontrada = sistema.buscarDenunciaPorFecha(fechaBusqueda);
            if (denunciaEncontrada != null) {
                JOptionPane.showMessageDialog(null, "Denuncia encontrada:\n" +
                        "Fecha: " + denunciaEncontrada.getFecha() + "\n" +
                        "Ubicación: " + denunciaEncontrada.getUbicacion() + "\n" +
                        "Descripción: " + denunciaEncontrada.getDescripcion() + "\n" +
                        "Evidencia: " + denunciaEncontrada.getEvidencia());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna denuncia con la fecha especificada.");
            }
        }
    }

    private void salir() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "Salir",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

