package data;

import model.Actividad;
import model.Estado;
import model.Juego;
import model.Libro;
import model.Pelicula;
import model.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorDatosTest {

    public ArrayList<Actividad> actividades = new ArrayList<>();

    @BeforeEach
    void setUp() {
        actividades = new ArrayList<>();
    }

    @Test
    void leerJson() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"WAA");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"waa");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"wa a");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"WaA");
        actividades = GestorDatos.leerJson("testJsonLectura.json", Actividad.class);
        for (Actividad actividad : actividades) {
            switch (actividad.getTitulo()) {
                case "Juego 1" -> assertEquals(juego1.getTitulo(), actividad.getTitulo());
                case "Libro 1" -> assertEquals(libro1.getTitulo(), actividad.getTitulo());
                case "Pelicula 1" -> assertEquals(pelicula1.getTitulo(), actividad.getTitulo());
                case "Serie 1" -> assertEquals(serie1.getTitulo(), actividad.getTitulo());
            }
        }
        actividades = GestorDatos.leerJson("", Actividad.class);
        assertEquals(new ArrayList<>(), actividades);
    }

    @Test
    void grabarJson() {
        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"WAA");
        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"waa");
        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"wa a");
        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"WaA");
        actividades.add(juego1);
        actividades.add(libro1);
        actividades.add(pelicula1);
        actividades.add(serie1);
        assertTrue(GestorDatos.grabarJson(actividades, "testJsonEscritura.json"));
        assertFalse(GestorDatos.grabarJson(actividades, ""));
    }
}