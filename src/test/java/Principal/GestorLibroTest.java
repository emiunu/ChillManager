package Principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorLibroTest {

    GestorLibro gestorLibro = new GestorLibro();
    Libro libro1 = new Libro(1,"El camino de los reyes", "Brandon Sanderson",2010,"Terminado", 10, "Mi libro fav");
    Libro libro2 = new Libro(2, "El secreto de las 7 semillas", "David Fishman", 2002, "Leyendo", 6,  " ");
    Libro libro3 = new Libro(3, "Amanecer rojo", "Pierce Brown", 2015, "Sin leer", 0, "me gustaria leerlo");

    @BeforeEach
    void setUp() {
        gestorLibro.agregarLibro(libro1);
        gestorLibro.agregarLibro(libro2);
        gestorLibro.agregarLibro(libro3);
    }

    @Test
    void agregarLibro() {
        assertFalse(gestorLibro.libroUnicoIsbn(1));
        assertFalse(gestorLibro.libroUnicoIsbn(2));
        assertFalse(gestorLibro.libroUnicoIsbn(3));
        assertTrue(gestorLibro.libroUnicoIsbn(4));
    }

    @Test
    void eliminarLibro() {
        assertFalse(gestorLibro.libroUnicoIsbn(1));
        assertFalse(gestorLibro.libroUnicoIsbn(2));
        assertFalse(gestorLibro.libroUnicoIsbn(3));

        gestorLibro.eliminarLibro(libro1);
        assertTrue(gestorLibro.libroUnicoIsbn(1));

        gestorLibro.eliminarLibro(libro2);
        assertTrue(gestorLibro.libroUnicoIsbn(2));

        gestorLibro.eliminarLibro(libro3);
        assertTrue(gestorLibro.libroUnicoIsbn(3));
    }

    @Test
    void buscarLibroIsbn() {
        assertEquals(libro1, gestorLibro.buscarLibroIsbn(1));
        assertEquals(libro2, gestorLibro.buscarLibroIsbn(2));
        assertEquals(libro3, gestorLibro.buscarLibroIsbn(3));

    }

    @Test
    void modificarLibro() {
        gestorLibro.modificarLibro(1, "El camino", "Brandon", 2024, "Sin leer", 0, " ");
        assertEquals("El camino", gestorLibro.buscarLibroIsbn(1).getTitulo());
        assertEquals("Brandon", gestorLibro.buscarLibroIsbn(1).getTitulo());
        assertEquals(2024, gestorLibro.buscarLibroIsbn(1).getAnno());
        assertEquals("Sin leer", gestorLibro.buscarLibroIsbn(1).getStatus());
        assertEquals(0, gestorLibro.buscarLibroIsbn(1).getRating());
        assertEquals(" ", gestorLibro.buscarLibroIsbn(1).getComentario());
    }

}