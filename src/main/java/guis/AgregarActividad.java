package guis;

import controller.*;
import model.*;
import utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AgregarActividad extends JFrame {
    private JPanel mainPanel;
    private JPanel agregarPanel;
    private JPanel juegoPanel;
    private JLabel fechaJuegoLabel;
    private JTextField fechaJuegoText;
    private JLabel dlcLabel;
    private JTextField dlcText;
    private JPanel libroPanel;
    private JLabel isbnLabel;
    private JTextField isbnText;
    private JLabel autorLabel;
    private JTextField autorText;
    private JLabel annoLibroLabel;
    private JTextField annoLibroText;
    private JPanel peliculaPanel;
    private JLabel annoPeliculaLabel;
    private JTextField annoPeliculaText;
    private JLabel duracionLabel;
    private JTextField duracionText;
    private JPanel seriePanel;
    private JLabel tempTotalesLabel;
    private JTextField tempTotalesText;
    private JLabel capTotalesLabel;
    private JTextField capTotalesText;
    private JLabel tempActualLabel;
    private JTextField tempActualText;
    private JLabel capActualLabel;
    private JTextField capActualText;
    private JLabel tituloLabel;
    private JTextField tituloText;
    private JLabel estadoLabel;
    private JComboBox<String> estadoBox;
    private JLabel ratingLabel;
    private JComboBox<Integer> ratingBox;
    private JLabel tipoLabel;
    private JComboBox<String> tipoBox;
    private JLabel comentLabel;
    private JTextField comentText;
    private JScrollPane scrollPanel;
    private JButton confirmarButton;
    private JLabel tituloAgregarLabel;

    public AgregarActividad(Gestor ChillManager){
        setTitle("Agregar Actividad");
        setSize(850, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(mainPanel);

        //Datos despegables
        tipoBox.addItem("Juego");
        tipoBox.addItem("Libro");
        tipoBox.addItem("Pelicula");
        tipoBox.addItem("Serie");

        for (Estado estado : Estado.values()){
            estadoBox.addItem(estado.toString());
        }

        for (int i = 0; i < 11; i++) {
            ratingBox.addItem(i);
        }

        //Visibilidad de los paneles de cada tipo.
        juegoPanel.setVisible(false);
        libroPanel.setVisible(false);
        peliculaPanel.setVisible(false);
        seriePanel.setVisible(false);

        //Cambiar la visibilidad según el tipo de actividad seleccionada.
        tipoBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) tipoBox.getSelectedItem();
                //Asegurar que los paneles estén ocultos.
                juegoPanel.setVisible(false);
                libroPanel.setVisible(false);
                peliculaPanel.setVisible(false);
                seriePanel.setVisible(false);
                if (Objects.equals(tipo, "Juego")){
                    juegoPanel.setVisible(true);
                } else if (Objects.equals(tipo, "Libro")){
                    libroPanel.setVisible(true);
                } else if (Objects.equals(tipo, "Pelicula")){
                    peliculaPanel.setVisible(true);
                } else if (Objects.equals(tipo, "Serie")){
                    seriePanel.setVisible(true);
                }
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validacion(ChillManager)){
                    agregarActividad(ChillManager);
                    dispose();
                }
            }
        });

    }

    public boolean validacion(Gestor ChillManager){
        String titulo = tituloText.getText();
        String tipo = (String) tipoBox.getSelectedItem();
        if (Objects.equals(tipo, "Libro")){
            int isbn = Integer.parseInt(isbnText.getText());
            if (!Utilidad.isbnUnico(isbn,ChillManager)){
                JOptionPane.showMessageDialog(AgregarActividad.this,"Este ISBN ya existe.","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (Utilidad.stringVacio(autorText.getText())){
                JOptionPane.showMessageDialog(AgregarActividad.this,"Hace falta completar el campo 'Autor/a'.","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (!Utilidad.tituloUnico(titulo,ChillManager)){
            JOptionPane.showMessageDialog(AgregarActividad.this,"Este título ya existe.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void agregarActividad(Gestor ChillManager){
        String titulo = tituloText.getText();
        Estado status = Estado.valueOf((String) estadoBox.getSelectedItem());
        int rating = ratingBox.getSelectedIndex();
        String comentario = comentText.getText();
        String tipo = (String) tipoBox.getSelectedItem();

        if (Objects.equals(tipo, "Juego")){
            Controlador.agregarActividad(ChillManager,agregarJuego(titulo,status,rating,comentario));
        } else if (Objects.equals(tipo, "Libro")){
            Controlador.agregarActividad(ChillManager,agregarLibro(titulo,status,rating,comentario));
        } else if (Objects.equals(tipo, "Pelicula")){
            Controlador.agregarActividad(ChillManager,agregarPelicula(titulo,status,rating,comentario));
        } else if (Objects.equals(tipo, "Serie")){
            Controlador.agregarActividad(ChillManager,agregarSerie(titulo,status,rating,comentario));
        }
    }

    public Juego agregarJuego(String titulo, Estado status, int rating, String comentario){
        int fecha = Integer.parseInt(fechaJuegoText.getText());
        int dlc = Integer.parseInt(dlcText.getText());
        Juego juegoAgregado = new Juego(titulo,fecha,dlc,status,rating,comentario);
        JOptionPane.showMessageDialog(AgregarActividad.this,juegoAgregado.toString(),"Juego agregado",JOptionPane.INFORMATION_MESSAGE);
        return juegoAgregado;
    }

    public Libro agregarLibro(String titulo, Estado status, int rating, String comentario) {
        int isbn = Integer.parseInt(isbnText.getText());
        String autor = autorText.getText();
        int anno = Integer.parseInt(annoLibroText.getText());
        Libro libroAgregado = new Libro(isbn, titulo, autor, anno, status, rating, comentario);
        JOptionPane.showMessageDialog(AgregarActividad.this, libroAgregado.toString(), "Libro agregado", JOptionPane.INFORMATION_MESSAGE);
        return libroAgregado;
    }

    public Pelicula agregarPelicula(String titulo, Estado status, int rating, String comentario) {
        int anno = Integer.parseInt(annoPeliculaText.getText());
        int duracion = Integer.parseInt(duracionText.getText());
        Pelicula peliculaAgregada = new Pelicula(titulo,anno,duracion,status,rating,comentario);
        JOptionPane.showMessageDialog(AgregarActividad.this, peliculaAgregada.toString(), "Pelicula agregado", JOptionPane.INFORMATION_MESSAGE);
        return peliculaAgregada;
    }

    public Serie agregarSerie(String titulo, Estado status, int rating, String comentario) {
        int temporadas = Integer.parseInt(tempTotalesText.getText());
        int capitulos = Integer.parseInt(capTotalesText.getText());
        int temporadaActual = Integer.parseInt(tempActualText.getText());
        int capituloActual = Integer.parseInt(capActualText.getText());
        Serie serieAgregada = new Serie(titulo,temporadas,capitulos,temporadaActual,capituloActual,status,rating,comentario);
        JOptionPane.showMessageDialog(AgregarActividad.this, serieAgregada.toString(), "Serie agregado", JOptionPane.INFORMATION_MESSAGE);
        return serieAgregada;
    }
}
