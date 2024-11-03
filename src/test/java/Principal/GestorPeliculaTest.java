package Principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GestorPeliculaTest {

    GestorPelicula gestorPelicula = new GestorPelicula();
    Pelicula blackSwan = new Pelicula("Black Swan", 2011,"Thriller",108,"Sin empezar",10,"Muy buena.");
    Pelicula rocky = new Pelicula("Rocky", 1976,"Acción",119,"Terminado",7,"buena.");
    Pelicula pearl = new Pelicula("Pearl",2022,"Thriller",102,"Terminado",10,"yo");

    @BeforeEach
    void setUp() {
        gestorPelicula = new GestorPelicula();

        gestorPelicula.agregarPelicula(blackSwan);
        gestorPelicula.agregarPelicula(rocky);


    }

    @Test
    void buscarPelicula() {
        //Se busca una pelicula que ya esta guardada.
        assertEquals(blackSwan,gestorPelicula.buscarPelicula("Black Swan"));
        //Se elimina la pelicula para verificar que realmente se elimina.
        gestorPelicula.eliminarPelicula(blackSwan);
        assertNull(gestorPelicula.buscarPelicula("Black Swan"));
        //Se busca una pelicula que nunca se ha guardado.
        assertNull(gestorPelicula.buscarPelicula("Pearl"));
        //Se busca nuevamente la pelicula al agregarla.
        gestorPelicula.agregarPelicula(pearl);
        assertEquals(pearl,gestorPelicula.buscarPelicula("Pearl"));
    }

    @Test
    void peliculaUnica() {
        //Se modifica una pelicula para verificar luego verificar si se puede guardar el mismo nombre luego de los cambios.
        assertFalse(gestorPelicula.peliculaUnica("Black Swan"));
        gestorPelicula.modificarPelicula("Black Swan","el cisne negro",2011,"Thriller",108,"Terminado",10,"Muy buena.");
        assertTrue(gestorPelicula.peliculaUnica("Black Swan"));
        //Se busca una pelicula que no este guardada y luego se agrega.
        assertTrue(gestorPelicula.peliculaUnica("Pearl"));
        gestorPelicula.agregarPelicula(pearl);
        assertFalse(gestorPelicula.peliculaUnica("Pearl"));
        //Se busca pelicula ya guardada, luego se elimina y se busca de nuevo.
        assertFalse(gestorPelicula.peliculaUnica("Rocky"));
        gestorPelicula.eliminarPelicula(rocky);
        assertTrue(gestorPelicula.peliculaUnica("Rocky"));
    }
}