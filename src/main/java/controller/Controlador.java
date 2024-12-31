package controller;
import data.GestorDatos;
import model.*;

public class Controlador {
    public static Gestor cargarDatos(Gestor gestor) {
        GestorDatos.leerJson("actividades.json", Actividad.class);
        return gestor;
    }

    public static void guardarDatos(Gestor gestor) {
        GestorDatos.grabarJson(gestor.getActividades(), "actividades.json");
    }

    public static Actividad agregarActividad(Gestor gestor, Actividad actividad) {
        if (actividad != null) {
            gestor.agregarActividad(actividad);
        }else{
            System.out.println("No se pudo agregar la actividad");
        }
        return actividad;
    }

    public static Actividad modificarActividadLibro(Libro libro, int isbn, String titulo, String autor, int anno, Estado status, int rating, String comentario) {
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnno(anno);
        libro.setStatus(status);
        libro.setRating(rating);
        libro.setComentario(comentario);
        return libro;
    }

    public static Actividad modificarActividadJuego(Juego juego, String titulo, int fecha, int dlc, Estado status, int rating, String comentario) {
        juego.setTitulo(titulo);
        juego.setFecha(fecha);
        juego.setDlc(dlc);
        juego.setStatus(status);
        juego.setRating(rating);
        juego.setComentario(comentario);
        return juego;
    }

    public static Actividad modificarActividadSerie(Serie serie, String titulo, Estado status, int rating, String comentario, int temporadas, int capitulos, int temporadaActual, int capituloActual) {
        serie.setTitulo(titulo);
        serie.setStatus(status);
        serie.setRating(rating);
        serie.setComentario(comentario);
        serie.setTemporadas(temporadas);
        serie.setCapitulos(capitulos);
        serie.setTemporadaActual(temporadaActual);
        serie.setCapituloActual(capituloActual);
        return serie;
    }

    public static Actividad modificarActividadPelicula(Pelicula pelicula, String titulo, int anno, int duracion, Estado status, int rating, String comentario) {
            pelicula.setTitulo(titulo);
            pelicula.setAnno(anno);
            pelicula.setDuracion(duracion);
            pelicula.setStatus(status);
            pelicula.setRating(rating);
            pelicula.setComentario(comentario);
            return pelicula;
    }

    public static boolean eliminarActividadControlador(Gestor gestor, Actividad actividad) {
        try {
            gestor.eliminarActividad(actividad);
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la actividad");
            return false;
        }
    }
}