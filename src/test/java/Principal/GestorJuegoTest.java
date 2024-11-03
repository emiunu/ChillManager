package Principal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorJuegoTest {

    GestorJuego gestorJuego = new GestorJuego();
    Juego juego1 = new Juego("Juego1", 2021, 0, "Sin jugar", 10, "Comentario");
    Juego juego2 = new Juego("Juego2", 2020, 1, "Jugando", 9, "Comentario");
    Juego juego3 = new Juego("Juego3", 2019, 2, "Completado", 8, "Comentario");

    @BeforeEach
    void setUp() {
        gestorJuego.agregarJuego(juego1);
        gestorJuego.agregarJuego(juego2);
        gestorJuego.agregarJuego(juego3);
    }

    @AfterEach
    void tearDown() {
        gestorJuego.setJuegos(new ArrayList<Juego>());
    }

    @Test
    void agregarJuego() { // como agregarJuego solamente agrega un juego a la lista de juegos, no se puede testear, pero se van a testear las funciones interiores.
        assertFalse(gestorJuego.juegoUnico("Juego1"));
        assertFalse(gestorJuego.juegoUnico("Juego2"));
        assertFalse(gestorJuego.juegoUnico("Juego3"));
        assertTrue(gestorJuego.juegoUnico("Juego4"));
    }

    @Test
    void eliminarJuego() { // Se va a chequear la existencia de los juegos, y posteriormente la no existencia de estos
        assertFalse(gestorJuego.juegoUnico("Juego1"));
        assertFalse(gestorJuego.juegoUnico("Juego2"));
        assertFalse(gestorJuego.juegoUnico("Juego3"));
        gestorJuego.eliminarJuego(juego1);
        assertTrue(gestorJuego.juegoUnico("Juego1"));
        gestorJuego.eliminarJuego(juego2);
        assertTrue(gestorJuego.juegoUnico("Juego2"));
        gestorJuego.eliminarJuego(juego3);
        assertTrue(gestorJuego.juegoUnico("Juego3"));
    }

    @Test
    void buscarJuego() {
        assertEquals(juego1, gestorJuego.buscarJuego("Juego1"));
        assertEquals(juego2, gestorJuego.buscarJuego("Juego2"));
        assertEquals(juego3, gestorJuego.buscarJuego("Juego3"));
        assertNotEquals(juego1, gestorJuego.buscarJuego("Juego2"));
    }

    @Test
    void modificarJuego() { //Se va a modificar un juego y se va a chequear cada uno de los cambios
        gestorJuego.modificarJuego("Juego1", "Juegazo1", 2024, 10, "Jugando", 10, "Comentario");
        assertEquals("Juegazo1", gestorJuego.buscarJuego("Juegazo1").getNombre());
        assertEquals(2024, gestorJuego.buscarJuego("Juegazo1").getFecha());
        assertEquals(10, gestorJuego.buscarJuego("Juegazo1").getDlc());
        assertEquals("Jugando", gestorJuego.buscarJuego("Juegazo1").getStatus());
        assertEquals(10, gestorJuego.buscarJuego("Juegazo1").getRating());
        assertEquals("Comentario", gestorJuego.buscarJuego("Juegazo1").getComentario());
    }

}