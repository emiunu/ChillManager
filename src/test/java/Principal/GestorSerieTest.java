package Principal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorSerieTest {

    Serie serie1 = new Serie("Serie1",1,1,1,1,"Sin empezar",10,"Comentario1");
    Serie serie2 = new Serie("Serie2",1,1,1,1,"Sin empezar",10,"Comentario2");
    Serie serie3 = new Serie("SerieModificada",1,1,1,1,"Sin empezar",10,"Comentario3");
    GestorSerie gestorSerie = new GestorSerie();

    @BeforeEach
    void setUp() {
        System.out.println("Preparando un nuevo test...");
        gestorSerie = new GestorSerie();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando un test...");
        gestorSerie = new GestorSerie();
    }

    @Test
    void transformarStatusSerie() {
        assertEquals("Sin empezar", gestorSerie.transformarStatusSerie(1));
        assertEquals("Viendo", gestorSerie.transformarStatusSerie(2));
        assertEquals("Terminada", gestorSerie.transformarStatusSerie(3));
    }

    @Test
    void minusSinEspacios() {
        assertEquals("abcd", gestorSerie.minusSinEspacios("A b C d"));
    }

    @Test
    void serieUnica() {
        gestorSerie.agregarSerie(serie1);
        assertFalse(gestorSerie.serieUnica("Serie1"));
        assertTrue(gestorSerie.serieUnica("Serie2"));
    }

    @Test
    void agregarSerie() {
        System.out.println("Antes de agregar.");
        gestorSerie.mostrarTodasSeries();
        gestorSerie.agregarSerie(serie2);
        gestorSerie.mostrarTodasSeries();
        System.out.println("Después de agregar.");
    }

    @Test
    void buscarSerie() {
        gestorSerie.agregarSerie(serie1);
        assertEquals(serie1, gestorSerie.buscarSerie("Serie1"));
    }

    @Test
    void modificarSerie() {
        System.out.println("Antes de modificar.");
        gestorSerie.agregarSerie(serie1);
        gestorSerie.mostrarTodasSeries();
        gestorSerie.modificarSerie("Serie1",serie3);
        gestorSerie.mostrarTodasSeries();
        System.out.println("Después de modificar.");
    }

    @Test
    void eliminarSerie() {
        System.out.println("Antes de eliminar.");
        gestorSerie.agregarSerie(serie1);
        gestorSerie.mostrarTodasSeries();
        gestorSerie.eliminarSerie(serie1);
        gestorSerie.mostrarTodasSeries();
        System.out.println("Después de eliminar.");
    }
}