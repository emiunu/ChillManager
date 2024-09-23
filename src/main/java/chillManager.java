import java.io.ObjectStreamClass;
import java.util.Scanner;

//Esta es la rama para crear las funciones de Libros.

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

    public static void ejecutarOpcionMenuGeneral(int opcion, Object[][] matrizJuegos, Object[][] matrizLibros, Object[][] matrizPeliculas, Object[][] matrizSeries){
        if (opcion == 1) { //menu juegos.
            menuJuegos(matrizJuegos);
        } else if (opcion == 2) { //menu libros.
            menuLibros(matrizLibros);
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
            ejecutarOpcionMenuGeneral(opcion,matrizJuegos,matrizLibros,matrizPeliculas,matrizSeries);
            if (opcion == 5) {
                break;
            }
        }
        scanner().close();
    }

    public static void iniciar(){
        //iniciar matrices y llamar menú general.
        //menuGeneral(matrizJuegos(),matrizLibros(),);
    }

    //Funciones Juegos.

    public static Object[][] matrizJuegos(){
        return new Object[10][8];
    }

    public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
        for (int fila = 0; fila < matrizJuegos.length; fila++) {
            if (matrizJuegos[fila][0] != null) {
                if (((String) matrizJuegos[fila][0]).replace(" ", "").toLowerCase().equals(titulo.replace(" ", "").toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Object[][] modificarFilaJuegos(Object[][] matriz, String titulo, String status, int year, int dlc, int rating, String comment, int fila) { // modifica una fila especifica de forma breve
        matriz[fila] = new Object[]{(String) titulo, (String) status, (Integer) year, (Integer) dlc, (Integer) rating, (String) comment};
        return matriz;
    }

    public static Object[][] agregarJuego (Object[][] matrizJuegos, String titulo, String status, int year, int dlc, int rating, String comment) {
        if (espacioDisponible(matrizJuegos)) {
            for (int fila = 0; fila < matrizJuegos.length; fila++) {
                if (matrizJuegos[fila][0] == null) {
                    modificarFilaJuegos(matrizJuegos, titulo, status, year, dlc, rating, comment, fila);
                    return matrizJuegos;
                }
            }
        }
        System.out.println("No hay espacio para el juego.");
        return matrizJuegos;
    }

    public static void mostrarJuegos (Object[][] matrizJuegos) {
        System.out.println("LISTA DE JUEGOS");System.out.println("===================================");
        for (int fila = 0; fila < matrizJuegos.length; fila++) {
            if (matrizJuegos[fila][0] != null) {
                mostrarFilaJuego(matrizJuegos, fila);
            }
        }
        System.out.println("FIN DEL LISTADO");
    }

    public static void mostrarFilaJuego (Object[][] matrizJuegos, int fila) {
        System.out.println("『 Título: " + matrizJuegos[fila][0] + " | Estatus : " + matrizJuegos[fila][1] + " | Año: " + matrizJuegos[fila][2] + " | DLC: " + matrizJuegos[fila][3] + " | Rating: " + matrizJuegos[fila][4] + " | Comentario: " + matrizJuegos[fila][5] + " 』");
    }

    public static int obtenerFilaJuego(Object[][] matrizJuegos, String titulo){ // obtener fila de un juego existente
        for (int fila = 0; fila < matrizJuegos.length; fila++) {
            if (matrizJuegos[fila][0] != null) {
                if (((String) matrizJuegos[fila][0]).replace(" ", "").toLowerCase().equals(titulo.replace(" ", "").toLowerCase())){
                    return fila;
                }
            }
        }
        return 0;
    }

    public static String ingresarStatusJuego(){
        String status = "";
        opcionesStatusJuego();
        int opcion = leerOpcionLimitada("Seleccione una opción: ",1, 3);
        if (opcion == 1){
            status = "Sin jugar";
        } else if (opcion == 2){
            status = "Jugando";
        }else { status = "Terminado";}
        return status;
    }

    public static void opcionesStatusJuego(){
        System.out.println("Status de Videojuego:");
        System.out.println("1. Sin jugar.");
        System.out.println("2. Jugando.");
        System.out.println("3. Completado.");
    }

    public static void anadirJuego(Object[][] matrizJuegos) {
        String gameName = pedirString("Ingrese el nombre del videojuego: ");
        if (juegoUnico(matrizJuegos, gameName)) {
            agregarJuego(matrizJuegos, gameName, ingresarStatusJuego(), pedirIntPositivo("Ingrese la fecha: "), pedirIntPositivo("Ingrese la cantidad de DLC: "), obtenerRating(), pedirString("Ingrese un comentario: "));
            System.out.print("Se ha agregado correctamente.");
        } else { System.out.println("El juego ya se encuentra registrado"); }
    }

    public static void buscarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego: ");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            System.out.println("Juego encontrado. ");
            int fila = obtenerFilaJuego(matrizJuegos, nombreJuego);
            mostrarFilaJuego(matrizJuegos, fila);
        } else {
            System.out.println("No se encuentra el juego.");
        }
    }

    public static void actualizarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego que quiere modificar: ");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            System.out.println("Ingrese los datos del juego: ");
            modificarFilaJuegos(matrizJuegos, pedirString("Ingrese el nuevo nombre: "), ingresarStatusJuego(), pedirIntPositivo("Ingrese la fecha: "), pedirIntPositivo("Ingrese la cantidad de DLC: "), obtenerRating(), pedirString("Ingrese un comentario: "), obtenerFilaJuego(matrizJuegos, nombreJuego));
            System.out.println("Actualización realizada correctamente. ");
        } else {
            System.out.println("No se encuentra el juego.");
        }
    }

    public static Object [][] borrarJuego (Object[][] matrizJuegos) {
        String nombreJuego = pedirString("Ingrese el nombre del juego que quiere eliminar: ");
        if (!juegoUnico(matrizJuegos, nombreJuego)) {
            vaciarFila(matrizJuegos, obtenerFilaJuego(matrizJuegos, nombreJuego), 6);
            System.out.println("Juego eliminado correctamente.");
        } else { System.out.println("No se encuentra el juego");}
        return matrizJuegos;
    }

    public static void mostrarOpcionesJuegos(){
        System.out.println("\nMenú de Juegos:");
        System.out.println("1) Agregar juego.");
        System.out.println("2) Buscar juego.");
        System.out.println("3) Actualizar/modificar juego.");
        System.out.println("4) Eliminar juego.");
        System.out.println("5) Ver todos los juegos.");
        System.out.println("6) Volver.");
    }

    public static void ejecutarOpcionJuego (Object[][] matrizJuegos, int opcion){
        if (opcion == 1) { //add game
            anadirJuego(matrizJuegos);
        }else if (opcion == 2) { //search game
            buscarJuego(matrizJuegos);
        } else if (opcion == 3) { //update game
            actualizarJuego(matrizJuegos);
        } else if (opcion == 4) { //delete game
            borrarJuego(matrizJuegos);
        } else if (opcion == 5) { //show all game
            mostrarJuegos(matrizJuegos);
        } else if (opcion == 6) { //exit game
            System.out.print("Volviendo al menú general...");
        }
    }

    public static void menuJuegos (Object[][] matrizJuegos ){
        while(true){
            mostrarOpcionesJuegos();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1, 6);
            ejecutarOpcionJuego(matrizJuegos, opcion);
            if (opcion == 6) {
                break;
            }
        }
    }

    //Funciones Libros.

    public static Object[][] matrizLibros() {
        return new Object[10][7];
    }

    //Función para comprobar que si ya existe. Compara el título con la posición en la matriz, ambas cosas en minúsculas y sin espacios.
    public static boolean libroUnico(Object[][] matrizLibros, int isbn){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null) {
                if (matrizLibros[i][0].equals(isbn)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Object[][] escribirInfoLibro(Object[][] matrizLibros,int isbn,String titulo,String autor,int year,String status,int rating,String commment, int fila){
        matrizLibros[fila][0] = isbn;
        matrizLibros[fila][1] = titulo;
        matrizLibros[fila][2] = autor;
        matrizLibros[fila][3] = year;
        matrizLibros[fila][4] = status;
        matrizLibros[fila][5] = rating;
        matrizLibros[fila][6] = commment;
        return matrizLibros;
    }
    //Fucion para agregar un libro nuevo dependiendo de ciertos parametros.
    public static void agregarLibro(Object[][] matrizLibros, int isbn) {
        if (libroUnico(matrizLibros,isbn)){
            if (espacioDisponible(matrizLibros)){
                escribirInfoLibro(matrizLibros,isbn,pedirString("Dime el titulo del libro: "),pedirString("Dime el autor del libro: "),pedirInt("Dime el año del libro: "), transformarStatusLibro(leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin leer ; 2 = Leyendo ; 3 = Terminado): ", 1, 3)),obtenerRating(),pedirString("Ingrese un comentario sobre el libro: "),obtenerFilaVacia(matrizLibros));
                System.out.println("Libro guardado correctamente.");
            }else System.out.println("No hay espacio disponible para agregar un libro.");
        }else System.out.println("El libro ya se encuentra registrado.");
    }

    //Función para obtener la fila en la que está el libro que se busca. Solo debe ser llamada si el libro ya fue encontrado (ya existe en la matriz).
    public static int obtenerFilaLibro(Object[][] matrizLibros, int isbn){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null){
                if (matrizLibros[i][1].equals(isbn)){
                    return i;
                }
            }
        }
        return 0;
    }

    //Transformar en int del status a un string.
    public static String transformarStatusLibro(int opcion){
        String status = "";
        if (opcion == 1){
            status = "Sin leer";
        } else if (opcion == 2){
            status = "Leyendo";
        } else if (opcion == 3){
            status = "Terminado";
        }
        return status;
    }

    public static void buscarLibro(Object[][] matrizLibros, int isbn){
        if (!libroUnico(matrizLibros,isbn)){
            int fila = obtenerFilaLibro(matrizLibros,isbn);
            System.out.println("Libro encontrado.");
            System.out.println("『 ISBN: "+matrizLibros[fila][0]+" | Titulo: "+matrizLibros[fila][1]+" | Autor: "+matrizLibros[fila][2]+" | Año: "+matrizLibros[fila][3]+" | Status: "+matrizLibros[fila][4]+" | Rating: "+matrizLibros[fila][5]+" | Comentarios: "+matrizLibros[fila][6]+" 』");
        } else System.out.println("No se encontró el libro.");
    }

    public static void actualizarLibro(Object[][]matrizLibros,int isbn){
        if (!libroUnico(matrizLibros,isbn)){
            int fila = obtenerFilaLibro(matrizLibros,isbn);
            escribirInfoLibro(matrizLibros,isbn,pedirString("Dime el nuevo titulo: "),pedirString("Dime el nuevo autor: "),pedirInt("Dime el nuevo año: "), transformarStatusLibro(leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin leer ; 2 = Leyendo ; 3 = Terminado): ", 1, 3)),obtenerRating(),pedirString("Dime un comentario del libro: "), fila);
            System.out.println("Actualización realizada correctamente.");
        } else System.out.println("No se encontró el libro.");
    }

    public static void eliminarLibro(Object[][] matrizLibros, int isbn){
        if (!libroUnico(matrizLibros,isbn)) { //Si el libro ya se encuentra en la matriz.
            int fila = obtenerFilaLibro(matrizLibros,isbn); //Obtener la fila donde está ese libro.
            vaciarFila(matrizLibros,fila,7);
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    public static void mostrarLibros(Object[][] matrizLibros){
        System.out.println("LISTA DE LIBROS");
        System.out.println("===================================");
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null) {
                System.out.println("『 ISBN: "+matrizLibros[i][0]+" | Titulo: "+matrizLibros[i][1]+" | Autor: "+matrizLibros[i][2]+" | Año: "+matrizLibros[i][3]+" | Status: "+matrizLibros[i][4]+" | Rating: "+matrizLibros[i][5]+" | Comentarios: "+matrizLibros[i][6]+" 』");
            }
        }
        System.out.println("FIN DEL LISTADO.");
    }

    //Funcion para imprimir las distintas opciones para la parte de libros
    public static void mostrarOpcionesLibros(){
        System.out.println("\nMenú libros:");
        System.out.println("1) Agregar libro.");
        System.out.println("2) Buscar libro.");
        System.out.println("3) Actualizar/modificar libro.");
        System.out.println("4) Eliminar libro.");
        System.out.println("5) Ver todos los libros.");
        System.out.println("6) Volver.");
    }

    //Función de ejecutar las opciones del menú libros.
    public static void ejecutarOpcionLibros(Object[][] matrizLibros, int opcion){
        if (opcion == 1) {
            agregarLibro(matrizLibros, pedirIntPositivo("Ingrese el isbn del libro: "));//agregar
        } else if (opcion == 2) {
            buscarLibro(matrizLibros,pedirIntPositivo("Ingrese el isbn del libro que quiere buscar: "));//buscar.
        } else if (opcion == 3) {
            actualizarLibro(matrizLibros,pedirIntPositivo("Ingrese el isbn del libro que quiere actualizar/modificar: ")    );//actualizar.
        } else if (opcion == 4) {
            eliminarLibro(matrizLibros, pedirIntPositivo("Ingrese el isbn del libro que quiere eliminar: "));//eliminar.
        } else if (opcion == 5) {
            mostrarLibros(matrizLibros);//ver todos.
        } else if (opcion == 6) { //salir.
            System.out.print("Volviendo al menu general... "); //volvera al menu general.
        }
    }

    public static void menuLibros(Object [][]matrizLibros){
        while(true){
            mostrarOpcionesLibros();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1,6);
            ejecutarOpcionLibros(matrizLibros,opcion);
            if (opcion == 6) {
                break;
            }
        }
    }

    //Funciones Películas.

    //Funciones Series.

}