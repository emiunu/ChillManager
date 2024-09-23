import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chillManagerTest {

    Object [][] matrizJuegos = new Object[5][7];

    @BeforeEach
    void setUp() {
        matrizJuegos[0] = new Object[]{"Serie1",1,1,1,"Sin empezar", 10, "Comentario"};
        matrizJuegos[1] = new Object[]{"Serie2",1,1,1,"Sin empezar", 10, "Comentario"};
        matrizJuegos[2] = new Object[]{"Serie3",1,1,1,"Sin empezar", 10, "Comentario"};
        matrizJuegos[3] = new Object[]{"Serie4",1,1,1,"Sin empezar", 10, "Comentario"};
        matrizJuegos[4] = new Object[]{"Serie5",1,1,1,"Sin empezar", 10, "Comentario"};
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
    void conseguirNumeroFila() {
        assertEquals(0,chillManager.obtenerFilaJuego(matrizJuegos,"Serie1"));
        assertEquals(1,chillManager.obtenerFilaJuego(matrizJuegos,"Serie2"));
        assertEquals(2,chillManager.obtenerFilaJuego(matrizJuegos,"Serie3"));
        assertEquals(3,chillManager.obtenerFilaJuego(matrizJuegos,"Serie4"));
        assertEquals(4,chillManager.obtenerFilaJuego(matrizJuegos,"Serie5"));
    }
    @Test
    void juegoUnica () {
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Serie1"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Serie2"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Serie3"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Serie4"));
        assertFalse(chillManager.juegoUnico(matrizJuegos,"Serie5"));
        assertTrue(chillManager.juegoUnico(matrizJuegos,"Serie6"));
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