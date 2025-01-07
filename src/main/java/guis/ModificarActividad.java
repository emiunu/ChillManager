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
    private JLabel isbnText;
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
                modificarActividad(ChillManager,tipo);
                dispose();
            }
        });
    }

    /**
     * Método para verificar que el título que se está buscando exista en la colección.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @return Devuelve true si el título se encontró, false si no existe en la lista.
     */

    public boolean validacionBusqueda(String titulo, Gestor ChillManager){
        if (Utilidad.tituloUnico(titulo,ChillManager)){
            return false; //titulo no se encuentra.
        }
        return true;
    }

    /**
     * Método para cambiar la etiqueta del tipo correspondiente de la actividad que se buscó.
     *
     * @param tipo Tipo identificado en la actividad que se encontró.
     */

    public void cambiarLabelTipo(String tipo){
        tipoToFillLabel.setText(tipo);
    }

    /**
     * Método para mostrar los paneles con los campos correspondientes según el tipo de actividad que se buscó.
     *
     * @param tipo Tipo identificado en la actividad que se encontró.
     */

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

    /**
     * Método para completar los datos en los campos de texto comunes y luego los correspondientes de la actividad que se buscó.
     *
     * @param actividad Objeto actividad encontrada para extraer sus campos comunes.
     * @param tipo Tipo identificado en la actividad que se encontró.
     */

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

    /**
     * Método para completar los datos en los campos de texto correspondientes a la actividad Juego.
     *
     * @param actividad Objeto de la actividad encontrada para interpretarla como Juego y extraer sus campos específicos.
     */

    private void datosJuego(Actividad actividad){
        Juego juego = (Juego) actividad;
        fechaJuegoText.setText(String.valueOf(juego.getFecha()));
        dlcText.setText(String.valueOf(juego.getDlc()));
    }

    /**
     * Método para completar los datos en los campos de texto correspondientes a la actividad Libro.
     *
     * @param actividad Objeto de la actividad encontrada para interpretarla como Libro y extraer sus campos específicos.
     */

    private void datosLibro(Actividad actividad){
        Libro libro = (Libro) actividad;
        isbnText.setText(String.valueOf(libro.getIsbn()));
        autorText.setText(libro.getAutor());
        annoLibroText.setText(String.valueOf(libro.getAnno()));
    }

    /**
     * Método para completar los datos en los campos de texto correspondientes a la actividad Pelicula.
     *
     * @param actividad Objeto de la actividad encontrada para interpretarla como Pelicula y extraer sus campos específicos.
     */

    private void datosPelicula(Actividad actividad){
        Pelicula pelicula = (Pelicula) actividad;
        annoPeliculaText.setText(String.valueOf(pelicula.getAnno()));
        duracionText.setText(String.valueOf(pelicula.getDuracion()));
    }

    /**
     * Método para completar los datos en los campos de texto correspondientes a la actividad Serie.
     *
     * @param actividad Objeto de la actividad encontrada para interpretarla como Serie y extraer sus campos específicos.
     */

    private void datosSerie(Actividad actividad){
        Serie serie = (Serie) actividad;
        tempTotalesText.setText(String.valueOf(serie.getTemporadas()));
        capTotalesText.setText(String.valueOf(serie.getCapitulos()));
        tempActualText.setText(String.valueOf(serie.getTemporadaActual()));
        capActualText.setText(String.valueOf(serie.getCapituloActual()));
    }

    /**
     * Método para extraer los nuevos datos en los campos de texto comunes y luego buscar los demás según el tipo de actividad.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param tipo Tipo identificado en la actividad que se encontró.
     */

    private void modificarActividad(Gestor ChillManager, String tipo){
        Estado status = Estado.valueOf((String) estadoBox.getSelectedItem());
        int rating = ratingBox.getSelectedIndex();
        String comentario = comentText.getText();

        if (Objects.equals(tipo, "Juego")){
            nuevoJuego(ChillManager,status,rating,comentario);
        } else if (Objects.equals(tipo, "Libro")){
            nuevoLibro(ChillManager,status,rating,comentario);
        } else if (Objects.equals(tipo, "Pelicula")){
            nuevaPelicula(ChillManager,status,rating,comentario);
        } else if (Objects.equals(tipo, "Serie")){
            nuevaSerie(ChillManager,status,rating,comentario);
        }
    }

    /**
     * Método para extraer los nuevos datos en los campos de texto correspondientes a la actividad Juego.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param status Nuevo Estado según Estado.enum.
     * @param rating Nuevo número de rating seleccionado entre 1 y 10.
     * @param comentario Nuevos comentarios que se quieran agregar en la actividad.
     */

    public void nuevoJuego(Gestor ChillManager, Estado status, int rating, String comentario){
        int fecha = Integer.parseInt(fechaJuegoText.getText());
        int dlc = Integer.parseInt(dlcText.getText());
        Juego juegoOriginal = (Juego) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadJuego(juegoOriginal,fecha,dlc,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Juego modificado",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para extraer los nuevos datos en los campos de texto correspondientes a la actividad Libro.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param status Nuevo Estado según Estado.enum.
     * @param rating Nuevo número de rating seleccionado entre 1 y 10.
     * @param comentario Nuevos comentarios que se quieran agregar en la actividad.
     */

    public void nuevoLibro(Gestor ChillManager,Estado status, int rating, String comentario) {
        String autor = autorText.getText();
        int anno = Integer.parseInt(annoLibroText.getText());
        Libro libroOriginal = (Libro) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadLibro(libroOriginal,autor,anno,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Libro modificado",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para extraer los nuevos datos en los campos de texto correspondientes a la actividad Pelicula.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param status Nuevo Estado según Estado.enum.
     * @param rating Nuevo número de rating seleccionado entre 1 y 10.
     * @param comentario Nuevos comentarios que se quieran agregar en la actividad.
     */

    public void nuevaPelicula(Gestor ChillManager, Estado status, int rating, String comentario) {
        int anno = Integer.parseInt(annoPeliculaText.getText());
        int duracion = Integer.parseInt(duracionText.getText());
        Pelicula peliculaOriginal = (Pelicula) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadPelicula(peliculaOriginal,anno,duracion,status,rating,comentario);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Pelicula modificada",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para extraer los nuevos datos en los campos de texto correspondientes a la actividad Serie.
     *
     * @param ChillManager Gestor que contiene los datos.
     * @param status Nuevo Estado según Estado.enum.
     * @param rating Nuevo número de rating seleccionado entre 1 y 10.
     * @param comentario Nuevos comentarios que se quieran agregar en la actividad.
     */

    public void nuevaSerie(Gestor ChillManager, Estado status, int rating, String comentario) {
        int temporadas = Integer.parseInt(tempTotalesText.getText());
        int capitulos = Integer.parseInt(capTotalesText.getText());
        int temporadaActual = Integer.parseInt(tempActualText.getText());
        int capituloActual = Integer.parseInt(capActualText.getText());
        Serie serieOriginal = (Serie) Utilidad.entregarActividad(resultadoLabel.getText(),ChillManager);
        Controlador.modificarActividadSerie(serieOriginal,status,rating,comentario,temporadas,capitulos,temporadaActual,capituloActual);
        JOptionPane.showMessageDialog(ModificarActividad.this,"Se ha modificado exitosamente.","Serie modificada",JOptionPane.INFORMATION_MESSAGE);
    }
}
