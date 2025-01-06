package controller;
import data.GestorDatos;
import model.*;

public class Controlador {
    public static Gestor cargarDatos(Gestor gestor) {
        gestor.setActividades(GestorDatos.leerJson("actividades.json", Actividad.class));
        return gestor;
    }

    public static boolean guardarDatos(Gestor gestor) {
        return GestorDatos.grabarJson(gestor.getActividades(), "actividades.json");
    }

    public static Actividad agregarActividad(Gestor gestor, Actividad actividad) {
        if (actividad != null) {
            gestor.agregarActividad(actividad);
        }else{
            System.out.println("No se pudo agregar la actividad");
        }
        return actividad;
    }

    public static Actividad modificarActividadLibro(Libro libro, String autor, int anno, Estado status, int rating, String comentario) {
        libro.setAutor(autor);
        libro.setAnno(anno);
        libro.setStatus(status);
        libro.setRating(rating);
        libro.setComentario(comentario);
        return libro;
    }

    public static Actividad modificarActividadJuego(Juego juego, int fecha, int dlc, Estado status, int rating, String comentario) {
        juego.setFecha(fecha);
        juego.setDlc(dlc);
        juego.setStatus(status);
        juego.setRating(rating);
        juego.setComentario(comentario);
        return juego;
    }

    public static Actividad modificarActividadSerie(Serie serie, Estado status, int rating, String comentario, int temporadas, int capitulos, int temporadaActual, int capituloActual) {
        serie.setStatus(status);
        serie.setRating(rating);
        serie.setComentario(comentario);
        serie.setTemporadas(temporadas);
        serie.setCapitulos(capitulos);
        serie.setTemporadaActual(temporadaActual);
        serie.setCapituloActual(capituloActual);
        return serie;
    }

    public static Actividad modificarActividadPelicula(Pelicula pelicula, int anno, int duracion, Estado status, int rating, String comentario) {
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