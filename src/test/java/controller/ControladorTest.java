package controller;

import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Utilidad;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    Gestor ChillManager = new Gestor();
    Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"WAA");
    Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"waa");
    Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"wa a");
    Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"WaA");
    ArrayList<Actividad> auxiliar = new ArrayList<Actividad>();
    Juego juego2 = new Juego("Juego 2",2025,1,Estado.SIN_EMPEZAR,0,"segundo juego");


    @BeforeEach
    void setUp() {
        ChillManager.setActividades(auxiliar);
        ChillManager.agregarActividad(juego1);
        ChillManager.agregarActividad(libro1);
        ChillManager.agregarActividad(pelicula1);
        ChillManager.agregarActividad(serie1);
        Controlador.guardarDatos(ChillManager);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void cargarDatos() {
        Controlador.cargarDatos(ChillManager);
        assertFalse(Utilidad.tituloUnico("Juego1",ChillManager));
        assertFalse(Utilidad.tituloUnico("libro1",ChillManager));
        assertFalse(Utilidad.tituloUnico("peliculA1",ChillManager));
        assertFalse(Utilidad.tituloUnico("Se rie1",ChillManager));
    }

    @Test
    void guardarDatos() {
        assertTrue(Controlador.guardarDatos(ChillManager));
    }

    @Test
    void agregarActividad() {
        assertTrue(Controlador.agregarActividad(ChillManager,juego2));
    }

    @Test
    void modificarActividadLibro() {
        Controlador.modificarActividadLibro(libro1,"Autor2",1910,Estado.FINALIZADO, 5, "Comentario");
        for (Actividad actividad : ChillManager.getActividades()) {
            if (actividad.getTitulo().equals("Libro 1")) {
                assertEquals("Autor2", ((Libro) actividad).getAutor());
                assertEquals(1910, ((Libro) actividad).getAnno());
                assertEquals(Estado.FINALIZADO, ((Libro) actividad).getStatus());
                assertEquals(5, ((Libro) actividad).getRating());
                assertEquals("Comentario", ((Libro) actividad).getComentario());
            }
        }
    }

    @Test
    void modificarActividadJuego() {
        Controlador.modificarActividadJuego(juego1,2005, 20, Estado.FINALIZADO, 5, "Comentarios20");
        for (Actividad actividad : ChillManager.getActividades()) {
            if (actividad.getTitulo().equals("Juego 1")) {
                assertEquals(2005, ((Juego) actividad).getFecha());
                assertEquals(Estado.FINALIZADO, ((Juego) actividad).getStatus());
                assertEquals(5, ((Juego) actividad).getRating());
                assertEquals("Comentarios20", ((Juego) actividad).getComentario());
            }
        }
    }

    @Test
    void modificarActividadSerie() {
        Controlador.modificarActividadSerie(serie1,Estado.EN_PROGRESO, 8, "Comentario202", 5, 1, 2, 3);
        for (Actividad actividad : ChillManager.getActividades()) {
            if (actividad.getTitulo().equals("Serie 1")) {
                assertEquals(Estado.EN_PROGRESO, ((Serie) actividad).getStatus());
                assertEquals(8, ((Serie) actividad).getRating());
                assertEquals("Comentario202", ((Serie) actividad).getComentario());
                assertEquals(5, ((Serie) actividad).getTemporadas());
                assertEquals(1, ((Serie) actividad).getCapitulos());
                assertEquals(2, ((Serie) actividad).getTemporadaActual());
                assertEquals(3, ((Serie) actividad).getCapituloActual());
            }
        }
    }

    @Test
    void modificarActividadPelicula() {
        Controlador.modificarActividadPelicula(pelicula1,2005, 120, Estado.FINALIZADO, 5, "Comentarios20");
        for (Actividad actividad : ChillManager.getActividades()) {
            if (actividad.getTitulo().equals("Pelicula 1")) {
                assertEquals(2005, ((Pelicula) actividad).getAnno());
                assertEquals(Estado.FINALIZADO, ((Pelicula) actividad).getStatus());
                assertEquals(5, ((Pelicula) actividad).getRating());
                assertEquals("Comentarios20", ((Pelicula) actividad).getComentario());
            }
        }
    }

    @Test
    void eliminarActividadControlador() {
        assertFalse(Controlador.eliminarActividadControlador(ChillManager,juego2));
        assertTrue(Controlador.eliminarActividadControlador(ChillManager,juego1));
    }
}