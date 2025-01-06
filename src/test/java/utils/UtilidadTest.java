package utils;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadTest {
    String cadena = "texto Con Espacio      ";
    String cadena2 = "TextoconEspacio";
    Gestor gestor = new Gestor();

    @BeforeEach
    void setUp() {
        gestor.setActividades(new ArrayList<Actividad>());
    }

    @Test
    void minusSinEspacio() {
        assertNotEquals(cadena, cadena2);
        assertEquals(Utilidad.minusSinEspacio(cadena), Utilidad.minusSinEspacio(cadena2));
    }

    @Test
    void tituloUnico() {
        Juego juego1 = new Juego("Juego 1",2024,1, Estado.EN_PROGRESO,10,"comentario");
        gestor.agregarActividad(juego1);
        assertFalse(Utilidad.tituloUnico("Juego 1", gestor));
        assertTrue(Utilidad.tituloUnico("Juego 2", gestor));
    }

    @Test
    void entregarActividad() {
        Juego juego1 = new Juego("Juego 1",2024,1, Estado.EN_PROGRESO,10,"comentario");
        gestor.agregarActividad(juego1);
        assertEquals(juego1, Utilidad.entregarActividad("Juego 1", gestor));
        assertNull(Utilidad.entregarActividad("Juego 2", gestor));
    }

    @Test
    void isbnUnico() {
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024, Estado.EN_PROGRESO,0,"comentario");
        gestor.agregarActividad(libro1);
        assertFalse(Utilidad.isbnUnico(1234567890, gestor));
        assertTrue(Utilidad.isbnUnico(1234567891, gestor));
    }

    @Test
    void stringVacio() {
        String cadenaVacia = "";
        String cadenaNoVacia = "texto";
        assertTrue(Utilidad.stringVacio(cadenaVacia));
        assertFalse(Utilidad.stringVacio(cadenaNoVacia));
    }
}