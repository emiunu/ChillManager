import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chillManagerTest {

    Object [][] matrizJuegos = new Object[5][6];

    @BeforeEach
    void setUp() {
        matrizJuegos[0] = new Object[]{"Juego1",2020, 1,"Sin jugar", 10, "Comentario"};
        matrizJuegos[1] = new Object[]{"Juego2",2021, 0,"Sin jugar", 10, "Comentario"};
        matrizJuegos[2] = new Object[]{"Juego3",2022, 2,"Sin jugar", 10, "Comentario"};
        matrizJuegos[3] = new Object[]{"Juego4",2023, 0,"Sin jugar", 10, "Comentario"};
        matrizJuegos[4] = new Object[]{"Juego5",2024, 1,"Sin jugar", 10, "Comentario"};
    }

    @AfterEach
    void tearDown() {
        matrizJuegos[0] = null;
        matrizJuegos[1] = null;
        matrizJuegos[2] = null;
        matrizJuegos[3] = null;
        matrizJuegos[4] = null;
    }
    @Test
    void obtenerFilaJuego() {
        assertEquals(0,chillManager.obtenerFilaJuego(matrizJuegos,"Juego1"));
        assertEquals(1,chillManager.obtenerFilaJuego(matrizJuegos,"Juego2"));
        assertEquals(2,chillManager.obtenerFilaJuego(matrizJuegos,"Juego3"));
        assertEquals(3,chillManager.obtenerFilaJuego(matrizJuegos,"Juego4"));
        assertEquals(4,chillManager.obtenerFilaJuego(matrizJuegos,"Juego5"));
    }

    @Test
    void juegoUnico () {
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Juego1"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Juego2"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Juego3"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Juego4"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Juego5"));
        assertTrue(chillManager.juegoUnico(matrizJuegos,"Juego6"));
    }
    @Test
    void espaciodisponible () {
        assertFalse(chillManager.espacioDisponible(matrizJuegos));
        chillManager.vaciarFila(matrizJuegos,0,6);
        assertTrue(chillManager.espacioDisponible(matrizJuegos));
        chillManager.agregarJuego(matrizJuegos,"titulo10", "No empezado", 2002, 0, 10, "");
        assertFalse(chillManager.espacioDisponible(matrizJuegos));
    }
}