package principal;

import model.*;
import controller.*;
import guis.*;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Gestor ChillManager = new Gestor();
//        Juego juego1 = new Juego("Juego 1",2024,1,Estado.EN_PROGRESO,10,"WAA");
//        Libro libro1 = new Libro(1234567890,"Libro 1","Autor",2024,Estado.EN_PROGRESO,0,"waa");
//        Pelicula pelicula1 = new Pelicula("Pelicula 1",2024,120,Estado.EN_PROGRESO,10,"wa a");
//        Serie serie1 = new Serie("Serie 1",2,20,1,10,Estado.EN_PROGRESO,10,"WaA");
//        ChillManager.agregarActividad(juego1);
//        ChillManager.agregarActividad(libro1);
//        ChillManager.agregarActividad(pelicula1);
//        ChillManager.agregarActividad(serie1);
//        Controlador.guardarDatos(ChillManager);
        Controlador.cargarDatos(ChillManager);

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(ChillManager);
        ventanaPrincipal.setVisible(true);
    }
}
