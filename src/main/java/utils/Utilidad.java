package utils;
import model.*;

import java.util.Objects;

public class Utilidad {

    public static String minusSinEspacio(String cadena) {
        return cadena.replace(" ","").toLowerCase();
    }

    public static boolean tituloUnico(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return false;
            }
        }
        return true;
    }

    public static Actividad entregarActividad(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return actividadEnLista;
            }
        }
        return null;
    }

    public static boolean isbnUnico(int buscando, Gestor gestor) { //int o long?
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(actividadEnLista.getTipo(), "Libro")) {
                Libro libro = (Libro) actividadEnLista;
                if (libro.getIsbn()==buscando) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean stringVacio(String cadena) {
        return Objects.equals(minusSinEspacio(cadena), "");
    }

}