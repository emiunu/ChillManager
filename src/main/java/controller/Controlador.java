package controller;
import data.GestorDatos;
import model.*;

/**
 * Clase Controlador que se encarga de manejar las actividades
 * Siguiendo la arquitectura modelo-vista-controlador
 */

public class Controlador {

    /**
     * Metodo que carga los datos de las actividades desde un archivo Json
     * @param gestor El gestor de actividades
     * @return El gestor de actividades con las actividades cargadas
     */

    public static Gestor cargarDatos(Gestor gestor) {
        gestor.setActividades(GestorDatos.leerJson("actividades.json", Actividad.class));
        return gestor;
    }

    /**
     * Metodo que guarda los datos de las actividades en un archivo Json
     * @param gestor El gestor de actividades para obtener las actividades
     * @return True si se guardaron los datos, false si no
     */

    public static boolean guardarDatos(Gestor gestor) {
        return GestorDatos.grabarJson(gestor.getActividades(), "actividades.json");
    }

    /**
     * Metodo que agrega una actividad al gestor
     * @param gestor El gestor de actividades
     * @param actividad La actividad a agregar
     * @return True si se agrego la actividad, false si no
     */

    public static boolean agregarActividad(Gestor gestor, Actividad actividad) {
        if (actividad != null) {
            gestor.agregarActividad(actividad);
            return true;
        }else{
            System.out.println("No se pudo agregar la actividad");
            return false;
        }
    }

    /**
     * Metodo que modifica una Actividad Libro del gestor
     * @param libro Libro a modificar
     * @param autor El nuevo autor de la actividad
     * @param status El nuevo status de la actividad
     * @param rating El nuevo rating de la actividad
     * @param comentario El nuevo comentario de la actividad
     * @return La actividad modificada
     */

    public static Actividad modificarActividadLibro(Libro libro, String autor, int anno, Estado status, int rating, String comentario) {
        libro.setAutor(autor);
        libro.setAnno(anno);
        libro.setStatus(status);
        libro.setRating(rating);
        libro.setComentario(comentario);
        return libro;
    }

    /**
     * Metodo que modifica una Actividad Juego del gestor
     * @param juego Juego a modificar
     * @param fecha La nueva fecha de la actividad
     * @param dlc La nueva cantidad de DLC de la actividad
     * @param status El nuevo status de la actividad
     * @param rating El nuevo rating de la actividad
     * @param comentario El nuevo comentario de la actividad
     * @return La actividad modificada
     */


    public static Actividad modificarActividadJuego(Juego juego, int fecha, int dlc, Estado status, int rating, String comentario) {
        juego.setFecha(fecha);
        juego.setDlc(dlc);
        juego.setStatus(status);
        juego.setRating(rating);
        juego.setComentario(comentario);
        return juego;
    }

    /**
     * Metodo que modifica una Actividad Serie del gestor
     * @param serie Serie a modificar
     * @param status El nuevo status de la actividad
     * @param rating El nuevo rating de la actividad
     * @param comentario El nuevo comentario de la actividad
     * @param temporadas La nueva cantidad de temporadas de la actividad
     * @param capitulos La nueva cantidad de capitulos de la actividad
     * @param temporadaActual La nueva temporada actual de la actividad
     * @param capituloActual El nuevo capitulo actual de la actividad
     * @return La actividad modificada
     */

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

    /**
     * Metodo que modifica una Actividad Pelicula del gestor
     * @param pelicula Pelicula a modificar
     * @param anno El nuevo año de la actividad
     * @param duracion La nueva duracion de la actividad
     * @param status El nuevo status de la actividad
     * @param rating El nuevo rating de la actividad
     * @param comentario El nuevo comentario de la actividad
     * @return La actividad modificada
     */

    public static Actividad modificarActividadPelicula(Pelicula pelicula, int anno, int duracion, Estado status, int rating, String comentario) {
            pelicula.setAnno(anno);
            pelicula.setDuracion(duracion);
            pelicula.setStatus(status);
            pelicula.setRating(rating);
            pelicula.setComentario(comentario);
            return pelicula;
    }

    /**
     * Metodo que elimina una actividad del gestor
     * @param gestor El gestor de actividades
     * @param actividad La actividad a eliminar
     * @return True si se elimino la actividad, false si no
     */

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