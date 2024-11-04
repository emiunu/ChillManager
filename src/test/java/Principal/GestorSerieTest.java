package Principal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GestorSerieTest {

    Serie serie1 = new Serie("Serie1",1,1,1,1,"Sin empezar",10,"Comentario1");
    Serie serie2 = new Serie("Serie2",1,1,1,1,"Sin empezar",10,"Comentario2");
    Serie serie3 = new Serie("SerieModificada",1,1,1,1,"Sin empezar",10,"Comentario3");
    ArrayList<Serie> seriesLista = new ArrayList<>(Arrays.asList());
    GestorSerie gestorSerie = new GestorSerie(seriesLista);

    @BeforeEach
    void setUp() {
        System.out.println("Preparando un nuevo test...");
        seriesLista = new ArrayList<>(Arrays.asList(serie1));
        gestorSerie = new GestorSerie(seriesLista);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando un test...");
        seriesLista = new ArrayList<>(Arrays.asList());
        gestorSerie = new GestorSerie(seriesLista);
    }

    @Test
    void transformarStatusSerie() {
        assertEquals(gestorSerie.transformarStatusSerie(1),"Sin empezar");
        assertEquals(gestorSerie.transformarStatusSerie(2),"Viendo");
        assertEquals(gestorSerie.transformarStatusSerie(3),"Terminada");
    }

    @Test
    void minusSinEspacios() {
        assertEquals(gestorSerie.minusSinEspacios("A b C d"),"abcd");
    }

    @Test
    void serieUnica() {
        assertFalse(gestorSerie.serieUnica(serie1.getTitulo()));
        assertTrue(gestorSerie.serieUnica(serie2.getTitulo()));
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
        assertEquals(gestorSerie.buscarSerie(serie1.getTitulo()),serie1);
    }

    @Test
    void modificarSerie() {
        System.out.println("Antes de modificar.");
        gestorSerie.mostrarTodasSeries();
        gestorSerie.modificarSerie(serie1.getTitulo(),serie3);
        gestorSerie.mostrarTodasSeries();
        System.out.println("Después de modificar.");
    }

    @Test
    void eliminarSerie() {
        System.out.println("Antes de eliminar.");
        gestorSerie.mostrarTodasSeries();
        gestorSerie.eliminarSerie(serie1);
        gestorSerie.mostrarTodasSeries();
        System.out.println("Después de eliminar.");
    }
}