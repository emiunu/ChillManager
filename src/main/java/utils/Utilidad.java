package utils;
import model.*;

import java.util.Objects;

public class Utilidad {

    public String minusSinEspacio(String cadena) {
        return cadena.replace(" ","").toLowerCase();
    }

    public boolean intPositivo(int valor){
        return valor >= 0;
    }

    public boolean tituloUnico(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return false;
            }
        }
        return true;
    }

    public Actividad entregarActividad(String buscando, Gestor gestor){
        for (Actividad actividadEnLista : gestor.getActividades()) {
            if (Objects.equals(minusSinEspacio(buscando), minusSinEspacio(actividadEnLista.getTitulo()))) {
                return actividadEnLista;
            }
        }
        return null;
    }

    public boolean isbnUnico(int buscando, Gestor gestor) { //int o long?
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

    public boolean stringVacio(String cadena) {
        return Objects.equals(minusSinEspacio(cadena), "");
    }

    public boolean ratingEnLimite(int rating){
        if (0<=rating && rating<=10) {
            return true;
        }
        return false;
    }

}