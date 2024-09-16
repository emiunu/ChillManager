import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chillManagerTest {

    Object[][] matrizPeliculas = chillManager.crearMatrizPeliculas();
    @BeforeEach
    void setUp(){
            chillManager.annadirPelicula(matrizPeliculas,"El cisne negro",2011,"Thriller", 108,"Completado.",10,"Muy buena");
            chillManager.annadirPelicula(matrizPeliculas,"Pearl",2022,"Thriller",102, "Completado.",10,"Muy buena");
            chillManager.annadirPelicula(matrizPeliculas,"Cars",2006,"Comedia",117,"Sin ver.",1,"");
            chillManager.annadirPelicula(matrizPeliculas,"WALL E", 2008,"Ciencia ficción",98,"Sin ver",1,"");
            chillManager.annadirPelicula(matrizPeliculas,"Terminator",1984,"Ciencia ficción",107,"Sin ver",1,"");
    }

    @Test
    void conseguirNumeroFila() {
        assertEquals(1,chillManager.conseguirNumeroFila(matrizPeliculas,"Pearl"));
        assertEquals(2,chillManager.conseguirNumeroFila(matrizPeliculas,"Cars"));
    }

    @Test
    void peliculaUnica() {
        assertFalse(chillManager.peliculaUnica(matrizPeliculas,"Pearl"));
        assertTrue(chillManager.peliculaUnica(matrizPeliculas,"Up"));
        chillManager.eliminarPelicula(matrizPeliculas,"Cars");
        assertTrue(chillManager.peliculaUnica(matrizPeliculas,"Cars"));
    }

    @Test
    void espacioDisponible(){
        assertTrue(chillManager.espacioDisponible(matrizPeliculas));
        chillManager.annadirPelicula(matrizPeliculas,"Spiderverse",2023,"Acción",140,"Sin ver",1,"");
        chillManager.annadirPelicula(matrizPeliculas,"Terminator 2",1991,"Ciencia ficción",157,"Sin ver",1,"");
        chillManager.annadirPelicula(matrizPeliculas,"Terminator 3",2003,"Ciencia ficción",109,"Sin ver",1,"");
        chillManager.annadirPelicula(matrizPeliculas,"Up",2009,"Aventura",96,"Sin ver",1,"");
        chillManager.annadirPelicula(matrizPeliculas,"Matrix",1999,"Ciencia ficción",136,"Sin ver",1,"");
        assertFalse(chillManager.espacioDisponible(matrizPeliculas));
    }
}