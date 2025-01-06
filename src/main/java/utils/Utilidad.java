package utils;
import model.*;

import java.util.Objects;

/**
 * Clase Utilidad que se encarga de manejar los métodos básicos
 * Usados en el programa.
 */


public class Utilidad {

    /**
     * Método que elimina los espacios y convierte una cadena a minúsculas.
     * @param cadena La cadena a trabajar.
     * @return La cadena sin espacios y en minúsculas.
     */
    public static String minusSinEspacio(String cadena) {
        return cadena.replace(" ","").toLowerCase();
    }

    /**
     * Método que verifica si un título es único.
     * @param buscando El título a buscar.
     * @param gestor El gestor de actividades.
     * @return True si el título es único, false si no.
     */
    public static boolean tituloUnico(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que entrega una actividad del gestor según su título.
     * @param buscando El título de la actividad a buscar.
     * @param gestor El gestor de actividades.
     * @return La actividad encontrada o null si no se encuentra.
     */
    public static Actividad entregarActividad(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return actividadEnLista;
            }
        }
        return null;
    }

    /**
     * Método que verifica si un ISBN es único en el gestor.
     * @param buscando El ISBN a buscar.
     * @param gestor El gestor de actividades.
     * @return True si el ISBN es único, false si no.
     */
    public static boolean isbnUnico(int buscando, Gestor gestor) { //int o long?
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(actividadEnLista.getTipo(), "Libro")) {
                Libro libro = (Libro) actividadEnLista;
                if (libro.getIsbn() == buscando) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Método que verifica si una cadena está vacía.
     * @param cadena La cadena a verificar.
     * @return True si la cadena está vacía, false si no.
     */
    public static boolean stringVacio(String cadena) {
        return Objects.equals(minusSinEspacio(cadena), "");
    }

}