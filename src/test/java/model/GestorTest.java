package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.accessibility.AccessibleIcon;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {
    Gestor gestor = new Gestor();
    public ArrayList<Actividad> auxiliar = new ArrayList<Actividad>();

    @BeforeEach
    void setUp() {
        gestor.setActividades(new ArrayList<Actividad>());
        auxiliar = new ArrayList<Actividad>();
    }

    @Test
    void agregarActividad() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"comentario");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"comentario");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"comentario");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"comentario");
        assertFalse(gestor.getActividades().contains(juego1));
        assertFalse(gestor.getActividades().contains(libro1));
        assertFalse(gestor.getActividades().contains(pelicula1));
        assertFalse(gestor.getActividades().contains(serie1));
        gestor.agregarActividad(juego1);
        gestor.agregarActividad(libro1);
        gestor.agregarActividad(pelicula1);
        gestor.agregarActividad(serie1);
        assertTrue(gestor.getActividades().contains(juego1));
        assertTrue(gestor.getActividades().contains(libro1));
        assertTrue(gestor.getActividades().contains(pelicula1));
        assertTrue(gestor.getActividades().contains(serie1));
    }

    @Test
    void eliminarActividad() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"comentario");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"comentario");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"comentario");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"comentario");
        gestor.agregarActividad(juego1);
        gestor.agregarActividad(libro1);
        gestor.agregarActividad(pelicula1);
        gestor.agregarActividad(serie1);
        assertTrue(gestor.getActividades().contains(juego1));
        assertTrue(gestor.getActividades().contains(libro1));
        assertTrue(gestor.getActividades().contains(pelicula1));
        assertTrue(gestor.getActividades().contains(serie1));
        gestor.eliminarActividad(juego1);
        gestor.eliminarActividad(libro1);
        gestor.eliminarActividad(pelicula1);
        gestor.eliminarActividad(serie1);
        assertFalse(gestor.getActividades().contains(juego1));
        assertFalse(gestor.getActividades().contains(libro1));
        assertFalse(gestor.getActividades().contains(pelicula1));
        assertFalse(gestor.getActividades().contains(serie1));
    }

    @Test
    void setActividades() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"comentario");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"comentario");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"comentario");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"comentario");
        auxiliar.add(juego1);
        auxiliar.add(libro1);
        auxiliar.add(pelicula1);
        auxiliar.add(serie1);
        assertNotEquals(auxiliar, gestor.getActividades());
        gestor.setActividades(auxiliar);
        assertEquals(auxiliar, gestor.getActividades());
    }

    @Test
    void getActividades() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"comentario");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"comentario");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"comentario");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"comentario");
        auxiliar.add(juego1);
        auxiliar.add(libro1);
        auxiliar.add(pelicula1);
        auxiliar.add(serie1);
        assertNotEquals(auxiliar, gestor.getActividades());
        gestor.setActividades(auxiliar);
        assertEquals(auxiliar, gestor.getActividades());


    }
}