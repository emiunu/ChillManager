package guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;
import model.*;

/**
 * Ventana principal del gestor de actividades.
 */

public class VentanaPrincipal extends JFrame {
    private JPanel mainPanel;
    private JPanel elegirAccionPanel;
    private JButton agregarButton;
    private JButton buscarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton coleccionButton;
    private JLabel tituloLabel;
    private JButton guardarDatosButton;

    /**
     * Constructor de la ventana principal del gestor de actividades.
     *
     * @param ChillManager Gestor que contiene los datos.
     */

    public VentanaPrincipal(Gestor ChillManager){
        setTitle("Chill Manager");
        setSize(850, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        add(mainPanel);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarActividad agregarActividad = new AgregarActividad(ChillManager);
                agregarActividad.setVisible(true);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarActividad buscarActividad = new BuscarActividad(ChillManager);
                buscarActividad.setVisible(true);
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificarActividad modificarActividad = new ModificarActividad(ChillManager);
                modificarActividad.setVisible(true);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarActividad eliminarActividad = new EliminarActividad(ChillManager);
                eliminarActividad.setVisible(true);
            }
        });

        coleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coleccion coleccion = new Coleccion(ChillManager);
                coleccion.setVisible(true);
            }
        });

        guardarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.guardarDatos(ChillManager);
                JOptionPane.showMessageDialog(VentanaPrincipal.this,"Se han guardado los datos exitosamente.","Datos guardados",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
