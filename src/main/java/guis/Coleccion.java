package guis;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Coleccion extends JFrame {

    private JPanel mainPanel;
    private JLabel instruccionLabel;
    private JScrollPane scrollColeccion;
    private JTable coleccionTabla;
    private JPanel coleccionPanel;

    public Coleccion(Gestor ChillManager){
        setTitle("Colección de Actividades");
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
        coleccionTabla.setModel(model);
        rellenarTabla(ChillManager);

        coleccionTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int filaSeleccionada = coleccionTabla.getSelectedRow();
                    detallarResultado(ChillManager,filaSeleccionada);
                }
            }
        });
    }

    public void rellenarTabla(Gestor ChillManager){
        DefaultTableModel model = (DefaultTableModel) coleccionTabla.getModel();
        model.setRowCount(0);
        for (Actividad actividadEnLista : ChillManager.getActividades()){
            model.addRow(new Object[]{actividadEnLista.getTitulo(),actividadEnLista.getStatus(),actividadEnLista.getRating(),actividadEnLista.getComentario(),actividadEnLista.getTipo()});
        }
    }

    private void detallarResultado(Gestor ChillManager, int fila){
        String detalle;
        int filaSeleccionada = fila;
        detalle = ChillManager.getActividades().get(filaSeleccionada).toString();
        JOptionPane.showMessageDialog(Coleccion.this, detalle, "Detalles de la Actividad", JOptionPane.INFORMATION_MESSAGE);
    }
}
