import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chillManagerTest {

    Object[][] matrizLibros = new Object[5][7];

    @BeforeEach
    void setUp() {
        matrizLibros[0] = new Object[]{1,"el camino de los reyes","brandon sanderson",2010,"Terminado",10,"De los mejores libros que he leido."};
        matrizLibros[1] = new Object[]{2,"pepito","david baez",2200,"Leyendo",2,"ta entrete"};
        matrizLibros[2] = new Object[]{3,"Juramentada","brandon sanderson",2015,"Sin leer",5,"me gustaria leerlo"};
        matrizLibros[3] = new Object[]{4,"Un viaje al centro de la tierra","julio verne",1980,"Leyendo",4,"Se ve un libro entretenido"};
        matrizLibros[4] = new Object[]{5,"Perico trepa por chile","Nose",1920,"Sin leer",3,"parece fome"};
    }

    @AfterEach
    void tearDown() {
        matrizLibros = null;
    }

    @Test
    void libroUnico() {
        assertFalse(chillManager.libroUnico(matrizLibros,1));
        assertTrue(chillManager.libroUnico(matrizLibros,23));
        assertFalse(chillManager.libroUnico(matrizLibros,4));
    }

    @Test
    void espacioDisponible() {
        assertFalse(chillManager.espacioDisponible(matrizLibros));
        matrizLibros[4] = new Object[]{null,null,null,null,null,null,null};
        assertTrue(chillManager.espacioDisponible(matrizLibros));
    }

    @Test
    void obtenerFilaVacia() {
        matrizLibros[4] = new Object[]{null,null,null,null,null,null,null};
        assertEquals(4, chillManager.obtenerFilaVacia(matrizLibros));
    }

    @Test
    void escribirInfoLibro() {
        assertEquals(0,chillManager.escribirInfoLibro(matrizLibros,0,"Alicia en el pais de las maravillas"," ",2001,"Sin leer",2," ",0)[0][0]);
        assertEquals("Alicia en el pais de las maravillas",chillManager.escribirInfoLibro(matrizLibros,0,"Alicia en el pais de las maravillas"," ",2001,"Sin leer",2," ",0)[0][1]);
        assertEquals("Sin leer",chillManager.escribirInfoLibro(matrizLibros,2,"Alicia"," ",2001,"Sin leer",2," ",2)[2][4]);
    }

    @Test
    void vaciarFila() {
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][0]);
        assertNull(chillManager.vaciarFila(matrizLibros,1,7)[4][1]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][2]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][3]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][4]);
    }

}