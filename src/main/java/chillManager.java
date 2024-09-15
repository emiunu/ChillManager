import java.util.Scanner;

public class chillManager {
    public static void main(String[] args) {
        gameMenu();
    }

    public static Object[][] categoriasJuegos () { // inicializa la matriz de datos con las categorías en la primera fila
        Object [][] matrizJuegos = new Object[10][6];
        matrizJuegos[0] = new Object[]{(String)"title",(String)"status",(String)"year",(String)"DLC",(String)"rating",(String)"comment"};
        return matrizJuegos;
    }

    public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
        for (int row = 1; row < matrizJuegos.length; row++) {
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
        if (juegoUnico(matrizJuegos, titulo)) {
            for (int i = 0; i < matrizJuegos.length; i++) {
                if (matrizJuegos[i][0] == null) {
                    modificarFila(matrizJuegos, titulo, status, year, dlc, rating, comment, i );
                    return matrizJuegos;
                }
            }
        }
        System.out.println("El juego ya se encuentra agregado.");
        return matrizJuegos;
    }

    public static void mostrarJuegos (Object[][] matrizJuegos) {
        System.out.println(matrizJuegos[0][0] + " | " + matrizJuegos[0][1] + " | " + matrizJuegos[0][2] + " | " + matrizJuegos[0][3] + " | " + matrizJuegos[0][4] + " | " + matrizJuegos[0][5] + " | ");
        for (int row = 1; row < matrizJuegos.length; row++) {
            if (matrizJuegos[row][0] != null) {
                System.out.println(matrizJuegos[row][0] + " | " + matrizJuegos[row][1] + " | " + matrizJuegos[row][2] + " | " + matrizJuegos[row][3] + " | " + matrizJuegos[row][4] + " | " + matrizJuegos[row][5] + " | ");
            } else {
                break;
            }
        }
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static int requestInt(String mensaje){
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

    public static String askString(String mensaje){
        System.out.print(mensaje);
        return scanner().nextLine();
    }

    public static int askRating(){
        int rating;
        while (true) {
            try {
                System.out.print("Ingrese su rating (del 1 al 10): ");
                rating = scanner().nextInt();
                if ((rating >= 1) && (rating <= 10)) { // rating default de todas las categorias
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

    public static int getGameRow (Object[][] matrizJuegos, String titulo){ // obtener fila de un juego existente
        for (int i = 0; i < matrizJuegos.length; i++) {
            if (matrizJuegos[i][0].equals(titulo)){
                return i;
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

    public static void showOptions(){
        System.out.println("\nMenú de Juegos:");
        System.out.println("1) Agregar juego.");
        System.out.println("2) Buscar juego.");
        System.out.println("3) Actualizar/modificar juego.");
        System.out.println("4) Eliminar juego.");
        System.out.println("5) Ver todas los juegos.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }
    //Función de leer la opción del menú.
    public static int readOption(){
        int option;
        while (true) {
            try {
                option = scanner().nextInt();
                if ((option >= 1) && (option <= 6)) {
                    break;
                } else {
                    System.out.print("Opción inválida. Inténtelo nuevamente: ");
                }
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return option;
    }

    public static void runOptions(Object[][] matrizSeries, int option){
        if (option == 1) { //add game
        } else if (option == 2) { //search game
        } else if (option == 3) { //update game
        } else if (option == 4) { //delete game
        } else if (option == 5) { //show all game
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
            showOptions();
            int option = readOption();
            runOptions(juegos, option);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 0 = No): ");
            int userAnswer = scanner().nextInt();
            pass = continueMenu(userAnswer);
        }
        scanner().close();
    }
}