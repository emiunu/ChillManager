import java.util.Scanner;

public class chillManager {
    public static void main(String[] args) {
        iniciar();
    }

    //Funciones en común.

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static int pedirInt(String mensaje){
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner().nextInt();
                break;
            } catch(Exception InputMismatchException) {
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return valor;
    }

    public static int pedirIntPositivo(String mensaje) {
        while (true) {
            int numero = pedirInt(mensaje);
            if (numero < 0) {
                System.out.println("Ingrese un número positivo.");
            } else {
                return numero;
            }
        }
    }

    public static String pedirString(String mensaje){
        System.out.print(mensaje);
        String string;
        while (true){
            string = scanner().nextLine();
            if (string.isEmpty()){
                System.out.print("Por favor ingrese una entrada no vacía: ");
            }else{
                break;
            }
        }
        return string;
    }

    public static int obtenerRating(){
        return leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10);
    }

    public static boolean espacioDisponible(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
                return true;
            }
        }
        return false;
    }

    public static int obtenerFilaVacia(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
                return i;
            }
        }
        return 0;
    }

    public static Object [][] vaciarFila(Object[][] matriz, int fila, int columnas) {
        for (int i = 0; i < columnas; i ++) {
            matriz[fila][i] = null;
        }
        return matriz;
    }

    public static int leerOpcionLimitada(String mensaje, int min, int max){
        System.out.print(mensaje);
        int opcion;
        while (true) {
            try {
                opcion = scanner().nextInt();
                if ((opcion >= min) && (opcion <= max)) {
                    break;
                } else {
                    System.out.print("Opción sale del rango. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }

    //Funciones menú general.

    public static void mostrarMenus(){
        System.out.println("\nCHILL MANAGER");
        System.out.println("¿Qué deseas explorar?");
        System.out.println("1) Juegos.");
        System.out.println("2) Libros.");
        System.out.println("3) Películas.");
        System.out.println("4) Series.");
        System.out.println("5) Salir.");
    }

    public static void ejecutarOpcionIniciar(int opcion, Object[][] matrizJuegos, Object[][] matrizLibros, Object[][] matrizPeliculas, Object[][] matrizSeries){
        if (opcion == 1) { //menu juegos.
        } else if (opcion == 2) { //menu libros.
        } else if (opcion == 3) { //menu películas.
        } else if (opcion == 4) { //menu series.
        } else if (opcion == 5) { //salir del menú.
            System.out.println("Cerrando menú... ¡Hasta luego!");
        }
    }

    public static void menuGeneral(Object[][] matrizJuegos, Object[][] matrizLibros, Object[][] matrizPeliculas, Object[][] matrizSeries){
        while(true) {
            mostrarMenus();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ", 1, 5);
            ejecutarOpcionIniciar(opcion,matrizJuegos,matrizLibros,matrizPeliculas,matrizSeries);
            if (opcion == 5) {
                break;
            }
        }
        scanner().close();
    }

    public static void iniciar(){
        //iniciar matrices y llamar menú general.
    }

    //Funciones Juegos.

    //Funciones Libros.

    //Funciones Películas.

    //Funciones Series.

}