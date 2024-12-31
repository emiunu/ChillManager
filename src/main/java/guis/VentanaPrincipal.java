package guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controlador;
import model.*;

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

            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        coleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
