import java.util.Scanner;

public class chillManager {
    public static void main(String[] args) {
        iniciar();
    }

    //Funciones de series.

    //Función escáner.
    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    //Función para crear la matriz de objetos.
    public static Object[][] matrizSeries(){
        return new Object[10][7];
    }

    //Función para pedir un Int, junto con el mensaje correspondiente de para qué se utilizará.
    public static int pedirInt(String mensaje){
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner().nextInt();
                break;
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número. ");
            }
        }
        return valor;
    }

    //Función para pedir un String, junto con el mensaje correspondiente de para qué se utilizará.
    public static String pedirString(String mensaje){
        System.out.print(mensaje);
        return scanner().nextLine();
    }

    //Función para ingresar un rating entre 1 y 10.
    public static int pedirRating(){
        int rating;
        while (true) {
            try {
                System.out.print("Ingrese su rating (del 1 al 10): ");
                rating = scanner().nextInt();
                if ((rating >= 1) && (rating <= 10)) {
                    break;
                } else {
                    System.out.print("Opción inválida. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return rating;
    }

    //Función para comprobar que si ya existe. Compara el título en minúsculas y sin espacios.
    public static boolean serieUnica(Object[][] matrizSeries, String titulo){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] != null){
                if (matrizSeries[i][0] == titulo) {
                    return false;
                }
            }
        }
        return true;
    }

    //Función para obtener la fila en la que está la serie que se busca. Solo debe ser llamada si la serie fue encontrada (ya existe en la matriz).
    public static int obtenerFilaDeSerie(Object[][] matrizSeries, String titulo){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0].equals(titulo)){
                return i;
            }
        }
        return 0;
    }

    //Función para saber si existe espacio disponible.
    public static boolean espacioDisponible(Object[][] matrizSeries){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función para obtener la siguiente fila vacía. Solo debe ser llamada si hay espacio disponible.
    public static int obtenerFilaVacia(Object[][] matrizSeries){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] == null){
                return i;
            }
        }
        return 0;
    }

    //Función para agregar los parámetros a la matriz
    public static Object[][] agregarInfoSerie(Object[][] matrizSeries, String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, int rating, String comentario, int fila){
        matrizSeries[fila][0] = titulo;
        matrizSeries[fila][1] = temporadas;
        matrizSeries[fila][2] = capitulos;
        matrizSeries[fila][3] = temporadaActual;
        matrizSeries[fila][4] = capituloActual;
        matrizSeries[fila][5] = rating;
        matrizSeries[fila][6] = comentario;
        return matrizSeries;
    }

    //Función para mostrar todas las series.
    public static void mostrarSeries(Object[][] matrizSeries){
        for (int i = 0; i < matrizSeries.length; i++) {
           if (matrizSeries[i][0] != null) {
               System.out.println("Título: "+matrizSeries[i][0]+" | Temporadas: "+matrizSeries[i][1]+" | Capítulos: "+matrizSeries[i][2]+" | Temporada Actual: "+matrizSeries[i][3]+" | Capítulo Actual (de temporada): "+matrizSeries[i][4]+" | Rating: "+matrizSeries[i][5]+" | Comentarios: "+matrizSeries[i][6]);
           }
        }
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpciones(){
        System.out.println("\nMenú de series:");
        System.out.println("1) Agregar serie.");
        System.out.println("2) Buscar serie.");
        System.out.println("3) Actualizar/modificar serie.");
        System.out.println("4) Eliminar serie.");
        System.out.println("5) Ver todas las series.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }

    //Función de leer la opción del menú.
    public static int leerOpcion(){
        int opcion;
        while (true) {
            try {
                opcion = scanner().nextInt();
                if ((opcion >= 1) && (opcion <= 6)) {
                    break;
                } else {
                    System.out.print("Opción inválida. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcion(Object[][] matrizSeries, int opcion){
        if (opcion == 1) { //agregar
        } else if (opcion == 2) { //buscar serie.
        } else if (opcion == 3) { //actualizar serie.
        } else if (opcion == 4) { //eliminar serie.
        } else if (opcion == 5) { //ver todos serie.
        } else if (opcion == 6) { //salir serie.
            System.out.print("A continuación, confirme. "); //se ejecutará el continuar en el menú.
        }
    }

    //Función booleana de continuar para el menú.
    public static boolean continuarMenu(int opcion){
        boolean continuar = true;
        if(opcion == 2){
            continuar = false;
            System.out.println("Cerrando menú... ¡Hasta luego! ^^");
        } else if(opcion != 1){
            System.out.println("Opción no válida.");
        }
        return continuar;
    }

    //Función para iniciar la matriz con el menú.
    public static void iniciar(){
        menu(matrizSeries());
    }

    //Función menú.
    public static void menu(Object[][] matrizSeries){
        boolean continuar = true;
        while(continuar){
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(matrizSeries, opcion);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
            int respuesta = scanner().nextInt();
            continuar = continuarMenu(respuesta);
        }
        scanner().close();
    }

}
