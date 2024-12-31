package guis;

import controller.*;
import model.*;
import utils.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarActividad extends JFrame {

    private JPanel mainPanel;
    private JPanel eliminarPanel;
    private JTextField tituloText;
    private JButton buscarButton;
    private JTable resultado;
    private JButton eliminarSeleccionButton;
    private JLabel tituloLabel;
    private JScrollPane scrollResultado;

    public EliminarActividad(Gestor ChillManager){
        setTitle("Eliminar Actividad");
        setSize(850, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(mainPanel);

        String[] columnas = { "Título", "Estado", "Calificación", "Comentario", "Tipo" };

        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultado.setModel(model);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResultado(ChillManager);
            }
        });

        eliminarSeleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificarResultado(ChillManager)){
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(EliminarActividad.this, "No hay resultados para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public boolean verificarResultado(Gestor ChillManager){
        String titulo = tituloText.getText();
        if (!Utilidad.tituloUnico(titulo,ChillManager)){
            eliminarActividad(ChillManager,titulo);
            return true;
        }
        return false;
    }

    public void mostrarResultado(Gestor ChillManager){
        DefaultTableModel model = (DefaultTableModel) resultado.getModel();
        model.setRowCount(0);
        String titulo = tituloText.getText();

        for (Actividad actividadEnLista : ChillManager.getActividades()){
            if (Utilidad.entregarActividad(titulo,ChillManager) == actividadEnLista){
                model.addRow(new Object[]{actividadEnLista.getTitulo(),actividadEnLista.getStatus(),actividadEnLista.getRating(),actividadEnLista.getComentario(),actividadEnLista.getTipo()});
            }
        }
    }

    public void eliminarActividad(Gestor ChillManager, String titulo){
        for (Actividad actividadEnLista : ChillManager.getActividades()){
            if (Utilidad.entregarActividad(titulo,ChillManager) == actividadEnLista){
                Controlador.eliminarActividadControlador(ChillManager,actividadEnLista);
                JOptionPane.showMessageDialog(EliminarActividad.this, "Actividad Eliminada", "Eliminada", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
