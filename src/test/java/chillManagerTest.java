import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class chillManagerTest {

    Object [][] matrizJuegos = new Object[5][6];
    Object[][] matrizLibros = new Object[5][7];
    Object[][] matrizPeliculas = chillManager.matrizPeliculas();
    Object[][] matrizSeries = new Object[10][8];

    @BeforeEach
    void setUp() {
        System.out.println("Preparando la matriz para una prueba...");
        //Juegos.
        matrizJuegos[0] = new Object[]{"Juego1",2020, 1,"Sin jugar", 10, "Comentario"};
        matrizJuegos[1] = new Object[]{"Juego2",2021, 0,"Sin jugar", 10, "Comentario"};
        matrizJuegos[2] = new Object[]{"Juego3",2022, 2,"Sin jugar", 10, "Comentario"};
        matrizJuegos[3] = new Object[]{"Juego4",2023, 0,"Sin jugar", 10, "Comentario"};
        matrizJuegos[4] = new Object[]{"Juego5",2024, 1,"Sin jugar", 10, "Comentario"};
        //Libros.
        matrizLibros[0] = new Object[]{1,"el camino de los reyes","brandon sanderson",2010,"Terminado",10,"De los mejores libros que he leido."};
        matrizLibros[1] = new Object[]{2,"pepito","david baez",2200,"Leyendo",2,"ta entrete"};
        matrizLibros[2] = new Object[]{3,"Juramentada","brandon sanderson",2015,"Sin leer",5,"me gustaria leerlo"};
        matrizLibros[3] = new Object[]{4,"Un viaje al centro de la tierra","julio verne",1980,"Leyendo",4,"Se ve un libro entretenido"};
        matrizLibros[4] = new Object[]{5,"Perico trepa por chile","Nose",1920,"Sin leer",3,"parece fome"};
        //Películas.
        chillManager.agregarPelicula(matrizPeliculas,"El cisne negro",2011,"Thriller", 108,"Completado.",10,"Muy buena");
        chillManager.agregarPelicula(matrizPeliculas,"Pearl",2022,"Thriller",102, "Completado.",10,"Muy buena");
        chillManager.agregarPelicula(matrizPeliculas,"Cars",2006,"Comedia",117,"Sin ver.",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"WALL E", 2008,"Ciencia ficción",98,"Sin ver",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"Terminator",1984,"Ciencia ficción",107,"Sin ver",1,"");
        //Series.
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
        //Juegos.
        matrizJuegos[0] = null;
        matrizJuegos[1] = null;
        matrizJuegos[2] = null;
        matrizJuegos[3] = null;
        matrizJuegos[4] = null;
        //Libros.
        matrizLibros = null;
        //Series.
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

    //Funciones comunes.
    @Test
    void espacioDisponible() {
        //Juegos.
        assertFalse(chillManager.espacioDisponible(matrizJuegos));
        chillManager.vaciarFila(matrizJuegos,0,6);
        assertTrue(chillManager.espacioDisponible(matrizJuegos));
        chillManager.agregarJuego(matrizJuegos,"titulo10", "No empezado", 2002, 0, 10, "");
        assertFalse(chillManager.espacioDisponible(matrizJuegos));
        //Libros.
        assertFalse(chillManager.espacioDisponible(matrizLibros));
        matrizLibros[4] = new Object[]{null,null,null,null,null,null,null};
        assertTrue(chillManager.espacioDisponible(matrizLibros));
        //Películas.
        assertTrue(chillManager.espacioDisponible(matrizPeliculas));
        chillManager.agregarPelicula(matrizPeliculas,"Spiderverse",2023,"Acción",140,"Sin ver",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"Terminator 2",1991,"Ciencia ficción",157,"Sin ver",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"Terminator 3",2003,"Ciencia ficción",109,"Sin ver",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"Up",2009,"Aventura",96,"Sin ver",1,"");
        chillManager.agregarPelicula(matrizPeliculas,"Matrix",1999,"Ciencia ficción",136,"Sin ver",1,"");
        assertFalse(chillManager.espacioDisponible(matrizPeliculas));
        //Series.
        assertFalse(chillManager.espacioDisponible(matrizSeries));
        matrizSeries[7] = new Object[]{null,null,null,null,null,null,null,null};
        assertTrue(chillManager.espacioDisponible(matrizSeries));
    }

    @Test
    void obtenerFilaVacia() {
        //Libros.
        matrizLibros[4] = new Object[]{null,null,null,null,null,null,null};
        assertEquals(4, chillManager.obtenerFilaVacia(matrizLibros));
        //Series.
        matrizSeries[7] = new Object[]{null,null,null,null,null,null,null,null};
        assertEquals(7,chillManager.obtenerFilaVacia(matrizSeries));
    }

    @Test
    void vaciarFila() {
        //Libros.
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][0]);
        assertNull(chillManager.vaciarFila(matrizLibros,1,7)[4][1]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][2]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][3]);
        assertNull(chillManager.vaciarFila(matrizLibros,4,7)[4][4]);
        //Series.
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][0]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][1]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][2]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][3]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][4]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][5]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][6]);
        assertNull(chillManager.vaciarFila(matrizSeries,7,8)[7][7]);
    }

    //Juegos.
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

    //Libros.
    @Test
    void libroUnico() {
        assertFalse(chillManager.libroUnico(matrizLibros,1));
        assertTrue(chillManager.libroUnico(matrizLibros,23));
        assertFalse(chillManager.libroUnico(matrizLibros,4));
    }

    @Test
    void escribirInfoLibro() {
        assertEquals(0,chillManager.escribirInfoLibro(matrizLibros,0,"Alicia en el pais de las maravillas"," ",2001,"Sin leer",2," ",0)[0][0]);
        assertEquals("Alicia en el pais de las maravillas",chillManager.escribirInfoLibro(matrizLibros,0,"Alicia en el pais de las maravillas"," ",2001,"Sin leer",2," ",0)[0][1]);
        assertEquals("Sin leer",chillManager.escribirInfoLibro(matrizLibros,2,"Alicia"," ",2001,"Sin leer",2," ",2)[2][4]);
    }

    //Películas.
    @Test
    void obtenerFilaPelicula() {
        assertEquals(1,chillManager.obtenerFilaPelicula(matrizPeliculas,"Pearl"));
        assertEquals(2,chillManager.obtenerFilaPelicula(matrizPeliculas,"Cars"));
    }

    @Test
    void peliculaUnica() {
        assertFalse(chillManager.peliculaUnica(matrizPeliculas,"Pearl"));
        assertTrue(chillManager.peliculaUnica(matrizPeliculas,"Up"));
        chillManager.eliminarPelicula(matrizPeliculas,"Cars");
        assertTrue(chillManager.peliculaUnica(matrizPeliculas,"Cars"));
    }

    //Series.
    @Test
    void transformarStatusSerie() {
        assertEquals("Sin empezar",chillManager.transformarStatusSerie(1));
        assertEquals("Viendo",chillManager.transformarStatusSerie(2));
        assertEquals("Terminada",chillManager.transformarStatusSerie(3));
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
    void obtenerFilaSerie() {
        assertEquals(0,chillManager.obtenerFilaSerie(matrizSeries,"Serie1"));
        assertEquals(6,chillManager.obtenerFilaSerie(matrizSeries,"ser ie 7"));
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

}