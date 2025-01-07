package principal;

import model.*;
import controller.*;
import guis.*;

/**
 * Clase principal para ejecutar el proyecto.
 */

public class Main {

    /**
     * Ejecución del proyecto.
     */

    public static void main(String[] args) {
        run();
    }

    /**
     * Función para iniciar el gestor, cargar los datos y abrir la ventana.
     */

    public static void run(){
        Gestor ChillManager = new Gestor();
        Controlador.cargarDatos(ChillManager);

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(ChillManager);
        ventanaPrincipal.setVisible(true);
    }
}
