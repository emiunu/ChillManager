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
    }

    @Test
    void modificarActividadJuego() {
    }

    @Test
    void modificarActividadSerie() {
    }

    @Test
    void modificarActividadPelicula() {
    }

    @Test
    void eliminarActividadControlador() {
        assertFalse(Controlador.eliminarActividadControlador(ChillManager,juego2));
        assertTrue(Controlador.eliminarActividadControlador(ChillManager,juego1));
    }
}