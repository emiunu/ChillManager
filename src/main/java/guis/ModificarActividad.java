package guis;

import controller.*;
import model.*;
import utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ModificarActividad extends JFrame {

    private JPanel mainPanel;
    private JScrollPane scrollPanel;
    private JPanel datosPanel;
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
    private JLabel comentLabel;
    private JTextField comentText;
    private JPanel buscarPanel;
    private JLabel tipoToFillLabel;
    private JButton buscarButton;
    private JPanel modificarPanel;
    private JButton confirmarButton;
    private JLabel resultadoLabel;

    public ModificarActividad(Gestor ChillManager){
        setTitle("Modificar Actividad");
        setSize(850, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(mainPanel);

        resultadoLabel.setVisible(false);

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


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloText.getText();
                resultadoLabel.setText(titulo);
                if (validacionBusqueda(titulo,ChillManager)){
                    Actividad actividad = Objects.requireNonNull(Utilidad.entregarActividad(titulo, ChillManager));
                    String tipo = actividad.getTipo();
                    cambiarLabelTipo(tipo);
                    cambiarPanelTipo(tipo);
                    cambiarDatos(actividad,tipo);
                } else {
                    JOptionPane.showMessageDialog(ModificarActividad.this,"No hay resultados para este título.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = tipoToFillLabel.getText();
                if (validacionGuardar(ChillManager,tipo)){
                    modificarActividad(ChillManager,tipo);
                    dispose();
                }
            }
        });
    }

    public boolean validacionBusqueda(String titulo, Gestor ChillManager){
        if (Utilidad.tituloUnico(titulo,ChillManager)){
            return false; //titulo disponible, no existe resultado.
        }
        return true;
    }

    public boolean validacionGuardar(Gestor ChillManager,String tipo){
        String titulo = tituloText.getText();
        if (Objects.equals(tipo, "Libro")){
            int isbn = Integer.parseInt(isbnText.getText());
            if (!Utilidad.isbnUnico(isbn,ChillManager)){
                JOptionPane.showMessageDialog(ModificarActividad.this,"Este ISBN ya existe.","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (Utilidad.stringVacio(autorText.getText())){
                JOptionPane.showMessageDialog(ModificarActividad.this,"Hace falta completar el campo 'Autor/a'.","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (!Utilidad.tituloUnico(titulo,ChillManager)){
            JOptionPane.showMessageDialog(ModificarActividad.this,"Este título ya existe.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void cambiarLabelTipo(String tipo){
        tipoToFillLabel.setText(tipo);
    }

    public void cambiarPanelTipo(String tipo){
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

    private void cambiarDatos(Actividad actividad, String tipo){
        tituloText.setText(actividad.getTitulo());
        estadoBox.setSelectedItem(actividad.getStatus().toString());
        ratingBox.setSelectedItem(actividad.getRating());
        comentText.setText(actividad.getComentario());
        if (Objects.equals(tipo, "Juego")){
            datosJuego(actividad);
        } else if (Objects.equals(tipo, "Libro")){
            datosLibro(actividad);
        } else if (Objects.equals(tipo, "Pelicula")){
            datosPelicula(actividad);
        } else if (Objects.equals(tipo, "Serie")){
            datosSerie(actividad);
        }
    }

    private void datosJuego(Actividad actividad){
        Juego juego = (Juego) actividad;
        fechaJuegoText.setText(String.valueOf(juego.getFecha()));
        dlcText.setText(String.valueOf(juego.getDlc()));
    }

    private void datosLibro(Actividad actividad){
        Libro libro = (Libro) actividad;
        isbnText.setText(String.valueOf(libro.getIsbn()));
        autorText.setText(libro.getAutor());
        annoLibroText.setText(String.valueOf(libro.getAnno()));
    }

    private void datosPelicula(Actividad actividad){
        Pelicula pelicula = (Pelicula) actividad;
        annoPeliculaText.setText(String.valueOf(pelicula.getAnno()));
        duracionText.setText(String.valueOf(pelicula.getDuracion()));
    }

    private void datosSerie(Actividad actividad){
        Serie serie = (Serie) actividad;
        tempTotalesText.setText(String.valueOf(serie.getTemporadas()));
        capTotalesText.setText(String.valueOf(serie.getCapitulos()));
        tempActualText.setText(String.valueOf(serie.getTemporadaActual()));
        capActualText.setText(String.valueOf(serie.getCapituloActual()));
    }

    private void modificarActividad(Gestor ChillManager, String tipo){
        String titulo = tituloText.getText();
        Estado status = Estado.valueOf((String) estadoBox.getSelectedItem());
        int rating = ratingBox.getSelectedIndex();
        String comentario = comentText.getText();

        if (Objects.equals(tipo, "Juego")){
            nuevoJuego(ChillManager,titulo,status,rating,comentario);
        } else if (Objects.equals(tipo, "Libro")){
            nuevoLibro(ChillManager,titulo,status,rating,comentario);
        } else if (Objects.equals(tipo, "Pelicula")){
            nuevaPelicula(ChillManager,titulo,status,rating,comentario);
        } else if (Objects.equals(tipo, "Serie")){
            nuevaSerie(ChillManager,titulo,status,rating,comentario);
        }
    }

    public void nuevoJuego(Gestor ChillManager,String titulo, Estado status, int rating, String comentario){
        int fecha = Integer.parseInt(fechaJuegoText.getText());
        int dlc = Integer.parseInt(dlcText.getText());
        Juego juegoOriginal = (Juego) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadJuego(juegoOriginal,titulo,fecha,dlc,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Juego modificado",JOptionPane.INFORMATION_MESSAGE);
    }

    public void nuevoLibro(Gestor ChillManager,String titulo, Estado status, int rating, String comentario) {
        int isbn = Integer.parseInt(isbnText.getText());
        String autor = autorText.getText();
        int anno = Integer.parseInt(annoLibroText.getText());
        Libro libroOriginal = (Libro) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadLibro(libroOriginal,isbn,titulo,autor,anno,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Libro modificado",JOptionPane.INFORMATION_MESSAGE);
    }

    public void nuevaPelicula(Gestor ChillManager,String titulo, Estado status, int rating, String comentario) {
        int anno = Integer.parseInt(annoPeliculaText.getText());
        int duracion = Integer.parseInt(duracionText.getText());
        Pelicula peliculaOriginal = (Pelicula) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadPelicula(peliculaOriginal,titulo,anno,duracion,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Pelicula modificada",JOptionPane.INFORMATION_MESSAGE);
    }

    public void nuevaSerie(Gestor ChillManager,String titulo, Estado status, int rating, String comentario) {
        int temporadas = Integer.parseInt(tempTotalesText.getText());
        int capitulos = Integer.parseInt(capTotalesText.getText());
        int temporadaActual = Integer.parseInt(tempActualText.getText());
        int capituloActual = Integer.parseInt(capActualText.getText());
        Serie serieOriginal = (Serie) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadSerie(serieOriginal,titulo,status,rating,comentario,temporadas,capitulos,temporadaActual,capituloActual);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Serie modificada",JOptionPane.INFORMATION_MESSAGE);
    }
}
