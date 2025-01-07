package guis;

import model.*;
import utils.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class BuscarActividad extends JFrame {
    private JPanel mainPanel;
    private JTextField tituloText;
    private JTable resultado;
    private JPanel buscarPanel;
    private JLabel tituloLabel;
    private JButton buscarButton;
    private JLabel instruccionLabel;
    private JScrollPane scrollResultado;
    private JLabel resultadoLabel;

    public BuscarActividad(Gestor ChillManager){
        setTitle("Buscar Actividad");
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
                if (verificarResultado(ChillManager)) {
                    mostrarResultado(ChillManager);
                } else {
                    JOptionPane.showMessageDialog(BuscarActividad.this,"No hay resultados para este título.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resultado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    detallarResultado(ChillManager);
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

    public boolean verificarResultado(Gestor ChillManager){
        String titulo = resultadoLabel.getText();
        if (!Utilidad.tituloUnico(titulo,ChillManager)){
            return true;
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
     * Método para mostrar los detalles de la actividad seleccionada.
     *
     * @param ChillManager Gestor que contiene los datos.
     */

    private void detallarResultado(Gestor ChillManager){
        String titulo = resultadoLabel.getText();
        String detalle;
        detalle = Objects.requireNonNull(Utilidad.entregarActividad(titulo, ChillManager)).toString();
        JOptionPane.showMessageDialog(BuscarActividad.this, detalle, "Detalles de la Actividad", JOptionPane.INFORMATION_MESSAGE);
    }

}
