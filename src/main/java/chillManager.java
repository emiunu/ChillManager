import com.sun.source.tree.BreakTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class chillManager {
    public static void main(String[] args) {
        gameMenu();
    }

    public static Object[][] categoriasJuegos () { // inicializa la matriz de datos con las categorías en la primera fila
        return new Object[10][6];
    }

    public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
        for (int row = 0; row < matrizJuegos.length; row++) {
            if (matrizJuegos[row][0] != null) {
                if (matrizJuegos[row][0].equals(titulo))
                    return false;
            }
        }
        return true;
    }

    public static Object[][] modificarFila (Object[][] matriz, String titulo, String status, int year, int dlc, int rating, String comment, int row) { // modifica una fila especifica de forma breve
        matriz[row] = new Object[]{(String) titulo, (String) status, (Integer) year, (Integer) dlc, (Integer) rating, (String) comment};
        return matriz;
    }

    public static Object[][] agregarJuego (Object[][] matrizJuegos, String titulo, String status, int year, int dlc, int rating, String comment) {
        if (freeSpace(matrizJuegos)) {
            for (int i = 0; i < matrizJuegos.length; i++) {
                if (matrizJuegos[i][0] == null) {
                    modificarFila(matrizJuegos, titulo, status, year, dlc, rating, comment, i);
                    return matrizJuegos;
                }
            }
        }
        System.out.println("No hay espacio para el juego.");
        return matrizJuegos;
    }

    public static void mostrarJuegos (Object[][] matrizJuegos) {
        System.out.println("Juego" + " | " + "Status" + " | " + "Año" + " | " + "DLC" + " | " + "Rating" + " | " + "Comentario" + " | ");
        for (int row = 0; row < matrizJuegos.length; row++) {
            if (matrizJuegos[row][0] != null) {
                mostrarFilaJuego(matrizJuegos, row);
            }
        }
    }

    public static void mostrarFilaJuego (Object[][] matrizJuegos, int row) {
        System.out.println(matrizJuegos[row][0] + " | " + matrizJuegos[row][1] + " | " + matrizJuegos[row][2] + " | " + matrizJuegos[row][3] + " | " + matrizJuegos[row][4] + " | " + matrizJuegos[row][5] + " | ");
    }

    public static Scanner scanner(){ // inicia scanner de forma abreviada
        return new Scanner(System.in);
    }

    public static int requestInt(String mensaje){ // Pide un numero entero que no tiene restriccion de ser positivo o negativo
        int value;
        while (true) {
            try {
                System.out.print(mensaje);
                value = scanner().nextInt();
                break;
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número. "); // excepcion en caso de no ser numero
            }
        }
        return value;
    }

    public static String pedirString(String mensaje){
        System.out.print(mensaje);
        return scanner().nextLine();
    }

    public static int obtenerRating(){
        int rating;
        while (true) {
            try {
                System.out.print("Ingrese su rating (del 1 al 10): ");
                rating = scanner().nextInt();
                if ((rating >= 1) && (rating <= 10)) { // escala de rating
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

    public static int obtenerFilaJuego(Object[][] matrizJuegos, String titulo){ // obtener fila de un juego existente
        for (int i = 0; i < matrizJuegos.length; i++) {
            if (matrizJuegos[i][0] != null) {
                if (matrizJuegos[i][0].equals(titulo)){
                    return i;
                }
            }
        }
        return 0;
    }

    public static boolean freeSpace (Object[][] matrizSeries){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] == null){
                return true;
            }
        }
        return false;
    }

    public static void mostrarOpciones(){
        System.out.println("\nMenú de Juegos:");
        System.out.println("1) Agregar juego.");
        System.out.println("2) Buscar juego.");
        System.out.println("3) Actualizar/modificar juego.");
        System.out.println("4) Eliminar juego.");
        System.out.println("5) Ver todas los juegos.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }
    public static int escogerOpcion(int min, int max){
        int option;
        while (true) {
            try {
                option = scanner().nextInt();
                if ((option >= min) && (option <= max)) {
                    break;
                } else {
                    System.out.print("Opción sale del rango. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return option;
    }

    public static void correrOpciones(Object[][] matrizJuegos, int option){
        if (option == 1) { //add game
            anadirJuego(matrizJuegos);
        }else if (option == 2) { //search game
            buscarJuego(matrizJuegos);
        } else if (option == 3) { //update game
            actualizarJuego(matrizJuegos);
        } else if (option == 4) { //delete game
            borrarJuego(matrizJuegos);
        } else if (option == 5) { //show all game
            mostrarJuegos(matrizJuegos);
        } else if (option == 6) { //exit game
            System.out.print("A continuación, confirme. ");
        }
    }

    public static boolean continueMenu(int option){
        boolean pass = true;
        if(option == 0){
            pass = false;
            System.out.println("Cerrando menú ");
        } else if(option != 1){
            System.out.println("Opción no válida.");
        }
        return pass;
    }

    public static void gameMenu(){
        boolean pass = true;
        Object[][] juegos = categoriasJuegos();
        while(pass){
            mostrarOpciones();
            int option = escogerOpcion(1, 6);
            correrOpciones(juegos, option);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 0 = No): ");
            int userAnswer = escogerOpcion(0, 1);
            pass = continueMenu(userAnswer);
        }
        scanner().close();
    }

    public static String ingresarStatus(){
        Scanner scanner = scanner();
        String status = "";
        int opcion;
        while(true){
            try{
                opcionesStatusJuego();
                opcion = escogerOpcion(1, 3);
                if (opcion == 1){
                    status = "Sin jugar";
                    break;
                } else if (opcion == 2){
                    status = "Jugando";
                    break;
                }else{
                    status = "Terminado";
                    break;
                }
            } catch (InputMismatchException e){
                System.out.print("Ingrese una entrada valida. ");
                scanner.nextLine();
            }
        }
        return status;
    }

    public static int ingresarAno () {
        while (true) {
            int year = requestInt("Ingrese el año de lanzamiento: ");
            if (year < 0) {
                System.out.println("Ingrese un número positivo");
            } else {
                return year;
            }
        }
    }

    public static int ingresarDLC () {
        while (true) {
            int dlc = requestInt("Ingrese la cantidad de DLC: ");
            if (dlc < 0) {
                System.out.println("Ingrese un número mayor o igual a 0");
            } else {
                return dlc;
            }
        }
    }

    public static void opcionesStatusJuego(){
        System.out.println("Status de Videojuego:");
        System.out.println("1. Sin jugar");
        System.out.println("2. Jugando");
        System.out.println("3. Completado");
        System.out.print("Seleccione una opción: ");
    }

    public static void anadirJuego(Object[][] matrizJuegos) {
        String gameName = pedirString("Ingrese el nombre del videojuego: ");
        if (juegoUnico(matrizJuegos, gameName)) {
            agregarJuego(matrizJuegos, gameName, ingresarStatus(), ingresarAno(), ingresarDLC(), obtenerRating(), pedirString("Ingrese un comentario: "));
        }
    }

    public static void buscarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego: ");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            int fila = obtenerFilaJuego(matrizJuegos, nombreJuego);
            System.out.println("Juego" + " | " + "Status" + " | " + "Año" + " | " + "DLC" + " | " + "Rating" + " | " + "Comentario" + " | ");
            mostrarFilaJuego(matrizJuegos, fila);
        } else {
            System.out.println("No se encuentra en juego en el registro");
        }
    }

    public static void actualizarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego a modificar: ");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            System.out.println("Ingrese los datos del juego");
            modificarFila(matrizJuegos, pedirString("Ingrese el nuevo nombre"), ingresarStatus(), ingresarAno(), ingresarDLC(), obtenerRating(), pedirString("Ingrese un comentario: "), obtenerFilaJuego(matrizJuegos, nombreJuego));
        } else {
            System.out.println("No se encuentra en juego en el registro, no se puede modificar.");
        }
    }

    public static Object [][] hacerFilaNull (Object[][] matrizJuegos, int row) {
        for (int i = 0; i < 6; i ++) {
            matrizJuegos[row][i] = null;
        }
        return matrizJuegos;
    }

    public static Object [][] borrarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego a eliminar");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            hacerFilaNull(matrizJuegos, obtenerFilaJuego(matrizJuegos, nombreJuego));
        }
        return matrizJuegos;
    }
}