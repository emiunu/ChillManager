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
    private JLabel resultadoLabel;

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
        resultadoLabel.setVisible(false);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoLabel.setText(tituloText.getText());
                String titulo = resultadoLabel.getText();
                if (verificarResultado(ChillManager,titulo)) {
                    mostrarResultado(ChillManager);
                } else {
                    JOptionPane.showMessageDialog(EliminarActividad.this,"No hay resultados para este título.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        eliminarSeleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = resultadoLabel.getText();
                if (verificarResultado(ChillManager,titulo)){
                    eliminarActividad(ChillManager,titulo);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(EliminarActividad.this, "No hay resultados para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Método para verificar que el título que se está buscando exista en la colección.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @return Devuelve true si el título se encontró, false si no existe en la lista.
     */

    public boolean verificarResultado(Gestor ChillManager,String titulo){
        if (!Utilidad.tituloUnico(titulo,ChillManager)){
            return true; //el título no es único, por lo que sí existe en la lista.
        }
        return false;
    }

    /**
     * Método para mostrar el resultado de la búsqueda en la tabla.
     *
     * @param ChillManager Gestor que contiene los datos.
     */

    public void mostrarResultado(Gestor ChillManager){
        DefaultTableModel model = (DefaultTableModel) resultado.getModel();
        model.setRowCount(0);
        String titulo = resultadoLabel.getText();

        for (Actividad actividadEnLista : ChillManager.getActividades()){
            if (Utilidad.entregarActividad(titulo,ChillManager) == actividadEnLista){
                model.addRow(new Object[]{actividadEnLista.getTitulo(),actividadEnLista.getStatus(),actividadEnLista.getRating(),actividadEnLista.getComentario(),actividadEnLista.getTipo()});
            }
        }
    }

    /**
     * Método para eliminar la actividad en la colección.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param titulo Título de la actividad que se va a eliminar.
     * @return
     */

    private void eliminarActividad(Gestor ChillManager, String titulo){
        for (Actividad actividadEnLista : ChillManager.getActividades()){
            if (Utilidad.entregarActividad(titulo,ChillManager) == actividadEnLista){
                Controlador.eliminarActividadControlador(ChillManager,actividadEnLista);
                JOptionPane.showMessageDialog(EliminarActividad.this, "Actividad Eliminada", "Eliminada", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}
