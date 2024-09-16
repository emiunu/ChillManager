import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class chillManagerTest {

    Object[][] matrizSeries = new Object[10][8];

    @BeforeEach
    void setUp() {
        System.out.println("Preparando la matriz para una prueba...");
        matrizSeries[0] = new Object[]{"Serie1",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[1] = new Object[]{"Serie2",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[2] = new Object[]{"Serie3",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[3] = new Object[]{"Serie4",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[4] = new Object[]{"Serie5",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[5] = new Object[]{"Serie6",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[6] = new Object[]{"Serie7",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[7] = new Object[]{"Serie8",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[8] = new Object[]{"Serie9",1,1,1,1,"Sin empezar",10,"Comentario"};
        matrizSeries[9] = new Object[]{"Serie10",1,1,1,1,"Sin empezar",10,"Comentario"};
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando la matriz luego de una prueba...");
        matrizSeries[0] = null;
        matrizSeries[1] = null;
        matrizSeries[2] = null;
        matrizSeries[3] = null;
        matrizSeries[4] = null;
        matrizSeries[5] = null;
        matrizSeries[6] = null;
        matrizSeries[7] = null;
        matrizSeries[8] = null;
        matrizSeries[9] = null;
    }

    @Test
    void transformarStatus() {
        assertEquals("Sin empezar",chillManager.transformarStatus(1));
        assertEquals("Viendo",chillManager.transformarStatus(2));
        assertEquals("Terminada",chillManager.transformarStatus(3));
    }

    @Test
    void serieUnica() {
        assertFalse(chillManager.serieUnica(matrizSeries,"Serie1"));
        assertFalse(chillManager.serieUnica(matrizSeries,"S erie 2"));
        assertFalse(chillManager.serieUnica(matrizSeries,"Ser  ie3"));
        assertFalse(chillManager.serieUnica(matrizSeries,"serie4"));
        assertFalse(chillManager.serieUnica(matrizSeries,"serie 5"));
        assertFalse(chillManager.serieUnica(matrizSeries,"se rie6 "));
        assertFalse(chillManager.serieUnica(matrizSeries,"ser ie 7"));
        assertTrue(chillManager.serieUnica(matrizSeries,"Serie11"));
    }

    @Test
    void obtenerFilaDeSerie() {
        assertEquals(0,chillManager.obtenerFilaDeSerie(matrizSeries,"Serie1"));
        assertEquals(6,chillManager.obtenerFilaDeSerie(matrizSeries,"ser ie 7"));
    }

    @Test
    void espacioDisponible() {
        assertFalse(chillManager.espacioDisponible(matrizSeries));
        matrizSeries[7] = new Object[]{null,null,null,null,null,null,null,null};
        assertTrue(chillManager.espacioDisponible(matrizSeries));
    }

    @Test
    void obtenerFilaVacia() {
        matrizSeries[7] = new Object[]{null,null,null,null,null,null,null,null};
        assertEquals(7,chillManager.obtenerFilaVacia(matrizSeries));
    }

    @Test
    void escribirInfoSerie() {
        assertEquals("Serie prueba",chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][0]);
        assertEquals(2,chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][1]);
        assertEquals(2,chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][2]);
        assertEquals(2,chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][3]);
        assertEquals(2,chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][4]);
        assertEquals("Terminada",chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][5]);
        assertEquals(5,chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][6]);
        assertEquals(" ",chillManager.escribirInfoSerie(matrizSeries, "Serie prueba",2,2,2,2,"Terminada",5," ",7)[7][7]);
    }

    @Test
    void vaciarSerie() {
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][0]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][1]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][2]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][3]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][4]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][5]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][6]);
        assertNull(chillManager.vaciarSerie(matrizSeries,7)[7][7]);
    }
}