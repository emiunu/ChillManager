import java.util.InputMismatchException;
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

    public static void ejecutarOpcionMenuGeneral(int opcion, Object[][] matrizJuegos, Object[][] matrizLibros, Object[][] matrizPeliculas, Object[][] matrizSeries){
        if (opcion == 1) { //menu juegos.
            menuJuegos(matrizJuegos);
        } else if (opcion == 2) { //menu libros.
            menuLibros(matrizLibros);
        } else if (opcion == 3) { //menu películas.
            menuPeliculas(matrizPeliculas);
        } else if (opcion == 4) { //menu series.
            menuSeries(matrizSeries);
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
        menuGeneral(matrizJuegos(),matrizLibros(),matrizPeliculas(),matrizSeries());
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
            System.out.println("Volviendo al menú general...");
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
    //Función para agregar un libro nuevo dependiendo de ciertos parámetros.
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

    //Función para imprimir las distintas opciones para la parte de libros
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
            System.out.println("Volviendo al menu general... "); //volver al menu general.
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

    // Función para crear matriz de pelicula
    public static Object[][] matrizPeliculas(){
        return new Object[10][7];
    }

    //Función para añadir valores a la matriz pelicula
    public static void agregarPelicula(Object[][] matrizPeliculas, String titulo, int anno, String genero, int duracion, String status,int rating, String comentario){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] == null || matrizPeliculas[i][0] == "" ) {
                matrizPeliculas[i][0] = titulo;
                matrizPeliculas[i][1] = anno;
                matrizPeliculas[i][2] = genero;
                matrizPeliculas[i][3] = duracion;
                matrizPeliculas[i][4] = status;
                matrizPeliculas[i][5] = rating;
                matrizPeliculas[i][6] = comentario;
                break;
            }
        }

    }

    //Funcion para ejecutar añadir películas
    public static void ejecutarAgregarPelicula(Object [][] matrizPeliculas){
        if (espacioDisponible(matrizPeliculas)){
            String titulo = pedirString("Ingrese el titulo de la película que quiere agregar: ");
            boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
            if (peliculaUnica){
                agregarPelicula(matrizPeliculas,titulo,pedirIntPositivo("Ingrese el año de la película: "),pedirString("Ingrese el género de la película: "),pedirIntPositivo("Ingrese la duración de la película: "),ingresarStatusPelicula(),obtenerRating(),pedirString("Ingrese un comentario: "));
                System.out.println("Película guardada correctamente.");
            } else {
                System.out.println("La película ya se encuentra registrada.");
            }
        } else {
            System.out.println("No queda espacio disponible para agregar películas.");
        }
    }

    //Funcion para visualizar datos guardados en la matriz
    public static void verMatrizPeliculas(Object[][] matrizPeliculas){
        System.out.println("LISTA DE PELÍCULAS");
        System.out.println("===================================");
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] != null) {
                System.out.println("『 Título: "+matrizPeliculas[i][0]+" | Año: "+matrizPeliculas[i][1]+" | Género: "+matrizPeliculas[i][2]+" | Duracion: "+matrizPeliculas[i][3]+" | Estado: "+matrizPeliculas[i][4]+" | Rating: "+matrizPeliculas[i][5]+" | Comentarios: "+matrizPeliculas[i][6]+" 』");
            }
        }
        System.out.println("FIN DEL LISTADO.");

    }

    //Función para eliminar peliculas de la matriz
    public static void eliminarPelicula(Object [][] matrizPeliculas, String titulo){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] != null && matrizPeliculas[i][0].equals(titulo)) {
                vaciarFila(matrizPeliculas,i,7);
                break;
            }
        }
    }

    //Función para ejecutar eliminar película
    public static void ejecutarEliminarPelicula(Object[][] matrizPeliculas){
        String titulo = pedirString("Ingrese el titulo de la película que quiere eliminar: ");
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            eliminarPelicula(matrizPeliculas,titulo);
            System.out.println("Película eliminada correctamente.");
        } else {
            System.out.println("No se encontró la película");
        }
    }

    //Función para buscar película
    public static void buscarPelicula(Object [][] matrizPeliculas, String titulo){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if ( matrizPeliculas[i][0] != null && matrizPeliculas[i][0].equals(titulo)) {
                System.out.println("『 Título: "+matrizPeliculas[i][0]+" | Año: "+matrizPeliculas[i][1]+" | Género: "+matrizPeliculas[i][2]+" | Duracion: "+matrizPeliculas[i][3]+" | Estado: "+matrizPeliculas[i][4]+" | Rating: "+matrizPeliculas[i][5]+" | Comentarios: "+matrizPeliculas[i][6]+" 』");
                break;
            }
        }
    }

    //Función para ejecutar buscar película
    public static void ejecutarBuscarPelicula(Object [][] matrizPeliculas){
        String titulo = pedirString("Ingresa el titulo de la película que quiere buscar: ");
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            System.out.println("Película encontrada.");
            buscarPelicula(matrizPeliculas,titulo);
        } else {
            System.out.println("No se encontró la película.");
        }
    }

    //Función para actualizar películas de la matriz
    public static void ejecutarActualizarPelicula(Object[][] matrizPeliculas){
        String titulo = pedirString("Ingrese el titulo de la película que quiere actualizar/modificar: ");
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            actualizarPelicula(matrizPeliculas,obtenerFilaPelicula(matrizPeliculas, titulo),pedirString("Ingrese el nuevo titulo: "),pedirIntPositivo("Ingrese el año: "),pedirString("Ingrese el género: "),pedirIntPositivo("Ingrese la duración: "),ingresarStatusPelicula(),obtenerRating(),pedirString("Ingrese comentario: "));
        } else {
            System.out.println("No se encontró la película.");
        }

    }

    //Función para actualizar una película
    public static void actualizarPelicula(Object [][] matrizPeliculas, int fila, String nuevoTitulo, int nuevoAnno, String nuevoGenero, int nuevaDuracion, String nuevoStatus, int nuevoRating, String nuevoComentario ){
        matrizPeliculas[fila][0] = nuevoTitulo;
        matrizPeliculas[fila][1] = nuevoAnno;
        matrizPeliculas[fila][2] = nuevoGenero;
        matrizPeliculas[fila][3] = nuevaDuracion;
        matrizPeliculas[fila][4] = nuevoStatus;
        matrizPeliculas[fila][5] = nuevoRating;
        matrizPeliculas[fila][6] = nuevoComentario;
        System.out.println("Actualización realizada correctamente.");
    }

    //Función para conseguir numero de fila
    public static int obtenerFilaPelicula(Object[][] matrizPeliculas, String titulo){
        int fila = 0;
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if(matrizPeliculas[i][0] != null && matrizPeliculas[i][0].equals(titulo)) {
                fila = i;
                break;
            }
        }
        return fila;
    }


    //Función para verificar la unicidad de una pelicula en la matriz
    public static boolean peliculaUnica(Object[][] matrizPeliculas, String titulo){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] != null){
                if (matrizPeliculas[i][0].equals(titulo)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Funcion para ingresar Status
    public static String ingresarStatusPelicula(){
        String status = "";
        opcionesStatusPelicula();
        int opcion = leerOpcionLimitada("Seleccione una opción: ",1, 2);
        if (opcion == 1){
            status = "Sin ver";
        }else {
            status = "Completado";
        }
        return status;
    }

    //Función que muestra las opciones de status
    public static void opcionesStatusPelicula(){
        System.out.println("Status de película:");
        System.out.println("1. Sin ver.");
        System.out.println("2. Completado.");
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpcionesPeliculas(){
        System.out.println("\nMenú de Películas:");
        System.out.println("1) Agregar película.");
        System.out.println("2) Buscar película.");
        System.out.println("3) Actualizar/modificar película.");
        System.out.println("4) Eliminar película.");
        System.out.println("5) Ver todas las películas.");
        System.out.println("6) Volver.");
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcionPeliculas(Object[][] matrizPeliculas, int opcion){
        if (opcion == 1) { //añadir
            ejecutarAgregarPelicula(matrizPeliculas);
        } else if (opcion == 2) { //buscar.
            ejecutarBuscarPelicula(matrizPeliculas);
        } else if (opcion == 3) { //actualizar.
            ejecutarActualizarPelicula(matrizPeliculas);
        } else if (opcion == 4) { //eliminar.
            ejecutarEliminarPelicula(matrizPeliculas);
        } else if (opcion == 5) { //ver todos.
            verMatrizPeliculas(matrizPeliculas);
        } else if (opcion == 6) { //volver al menú.
            System.out.println("Volviendo al menú general...");
        }
    }

    //Función menú.
    public static void menuPeliculas(Object [][] matrizPeliculas){
        while(true){
            mostrarOpcionesPeliculas();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1,6);
            ejecutarOpcionPeliculas(matrizPeliculas, opcion);
            if (opcion == 6){
                break;
            }
        }
    }

    //Funciones Series.

    //Función para crear la matriz de objetos.
    public static Object[][] matrizSeries(){
        return new Object[10][8];
    }

    //Transformar lo pedido en la función pedirStatus().
    public static String transformarStatusSerie(int opcion){
        String status = "";
        if (opcion == 1){
            status = "Sin empezar";
        } else if (opcion == 2){
            status = "Viendo";
        } else if (opcion == 3){
            status = "Terminada";
        }
        return status;
    }

    //Función para comprobar que si ya existe. Compara el título con la posición en la matriz, ambas cosas en minúsculas y sin espacios.
    public static boolean serieUnica(Object[][] matrizSeries, String titulo){
        String tituloIngresado = titulo.replace(" ","").toLowerCase();
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] != null) {
                String tituloBuscado = (String)matrizSeries[i][0];
                if (tituloBuscado.replace(" ","").toLowerCase().equals(tituloIngresado)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Función para obtener la fila en la que está la serie que se busca. Solo debe ser llamada si la serie fue encontrada (ya existe en la matriz). Se compara el título con la posición en la matriz, ambas cosas en minúsculas y sin espacios.
    public static int obtenerFilaSerie(Object[][] matrizSeries, String titulo){
        String tituloIngresado = titulo.replace(" ","").toLowerCase();
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] != null) {
                String tituloBuscado = (String)matrizSeries[i][0];
                if (tituloBuscado.replace(" ","").toLowerCase().equals(tituloIngresado)) {
                    return i;
                }
            }
        }
        return 0;
    }

    //Función para escribir la información de la serie.
    public static Object[][] escribirInfoSerie(Object[][] matrizSeries, String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, String status, int rating, String comentario, int fila){
        matrizSeries[fila][0] = titulo;
        matrizSeries[fila][1] = temporadas;
        matrizSeries[fila][2] = capitulos;
        matrizSeries[fila][3] = temporadaActual;
        matrizSeries[fila][4] = capituloActual;
        matrizSeries[fila][5] = status;
        matrizSeries[fila][6] = rating;
        matrizSeries[fila][7] = comentario;
        return matrizSeries;
    }

    //Mini menú para gestionar el agregar una serie.
    public static void agregarSerie(Object[][] matrizSeries, String titulo){
        if (serieUnica(matrizSeries,titulo)) { //Si la serie es única.
            if (espacioDisponible(matrizSeries)) { //Y si queda espacio disponible en la matriz.
                escribirInfoSerie(matrizSeries, titulo, pedirIntPositivo("Ingrese las temporadas totales: "), pedirIntPositivo("Ingrese los capítulos totales: "), pedirIntPositivo("Ingrese la temporada actual que está viendo: "), pedirIntPositivo("Ingrese el capítulo actual (de la temporada) en el que quedó: "), transformarStatusSerie(leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin empezar ; 2 = Viendo ; 3 = Terminada): ",1,3)), obtenerRating(), pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío): "), obtenerFilaVacia(matrizSeries));
                //la función leerOpciónLimitada(...), que devuelve un int, se utiliza como parámetro de transformarStatusSerie(...), que pide un int y retorna un String, para escribir correctamente el estado de visualización una de las 3 opciones disponibles.
                System.out.println("Serie guardada correctamente.");
            } else { //Si no hay espacio disponible.
                System.out.println("No queda espacio disponible para agregar series.");
            }
        } else { //Si la serie ya se encuentra en la matriz.
            System.out.println("La serie ya se encuentra registrada.");
        }
    }

    //Función para buscar una serie.
    public static void buscarSerie(Object[][] matrizSeries, String titulo){
        if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
            int fila = obtenerFilaSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
            System.out.println("Serie encontrada.");
            System.out.println("『 Título: "+matrizSeries[fila][0]+" | Temporadas: "+matrizSeries[fila][1]+" | Capítulos: "+matrizSeries[fila][2]+" | Temporada Actual: "+matrizSeries[fila][3]+" | Capítulo Actual (de temporada): "+matrizSeries[fila][4]+" | Estado: "+matrizSeries[fila][5]+" | Rating: "+matrizSeries[fila][6]+" | Comentarios: "+matrizSeries[fila][7]+" 』");
        } else {
            System.out.println("No se encontró la serie.");
        }
    }

    //Función para actualizar una serie.
    public static void actualizarSerie(Object[][] matrizSeries, String titulo){
        if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
            int fila = obtenerFilaSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
            escribirInfoSerie(matrizSeries, pedirString("Ingrese el nuevo título: "), pedirIntPositivo("Ingrese las temporadas totales: "), pedirIntPositivo("Ingrese los capítulos totales: "), pedirIntPositivo("Ingrese la temporada actual que está viendo: "), pedirIntPositivo("Ingrese el capítulo actual (de la temporada) en el que quedó: "), transformarStatusSerie(leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin empezar ; 2 = Viendo ; 3 = Terminada): ",1,3)), obtenerRating(), pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío): "), fila);
            //reemplaza la información de la serie en la fila donde ya está.
            System.out.println("Actualización realizada correctamente.");
        } else {
            System.out.println("No se encontró la serie.");
        }
    }

    //Función para eliminar una serie.
    public static void eliminarSerie(Object[][] matrizSeries, String titulo){
        if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
            int fila = obtenerFilaSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
            vaciarFila(matrizSeries,fila,7);
            System.out.println("Serie eliminada correctamente.");
        } else {
            System.out.println("No se encontró la serie.");
        }
    }

    //Función para mostrar todas las series.
    public static void mostrarSeries(Object[][] matrizSeries){
        System.out.println("LISTA DE SERIES");
        System.out.println("===================================");
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] != null) {
                System.out.println("『 Título: "+matrizSeries[i][0]+" | Temporadas: "+matrizSeries[i][1]+" | Capítulos: "+matrizSeries[i][2]+" | Temporada Actual: "+matrizSeries[i][3]+" | Capítulo Actual (de temporada): "+matrizSeries[i][4]+" | Estado: "+matrizSeries[i][5]+" | Rating: "+matrizSeries[i][6]+" | Comentarios: "+matrizSeries[i][7]+" 』");
            }
        }
        System.out.println("FIN DEL LISTADO.");
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpcionesSeries(){
        System.out.println("\nMenú de series:");
        System.out.println("1) Agregar serie.");
        System.out.println("2) Buscar serie.");
        System.out.println("3) Actualizar/modificar serie.");
        System.out.println("4) Eliminar serie.");
        System.out.println("5) Ver todas las series.");
        System.out.println("6) Volver.");
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcionSeries(Object[][] matrizSeries, int opcion){
        if (opcion == 1) { //agregar
            agregarSerie(matrizSeries,pedirString("Ingrese el título de la serie que quiere agregar: "));
        } else if (opcion == 2) { //buscar serie.
            buscarSerie(matrizSeries,pedirString("Ingrese el título de la serie que quiere buscar: "));
        } else if (opcion == 3) { //actualizar serie.
            actualizarSerie(matrizSeries,pedirString("Ingrese el título de la serie que quiere actualizar/modificar: "));
        } else if (opcion == 4) { //eliminar serie.
            eliminarSerie(matrizSeries,pedirString("Ingrese el título de la serie que quiere eliminar: "));
        } else if (opcion == 5) { //ver todas las series.
            mostrarSeries(matrizSeries);
        } else if (opcion == 6) { //volver al menú.
            System.out.println("Volviendo al menú general...");
        }
    }

    //Función menú.
    public static void menuSeries(Object[][] matrizSeries){
        while(true){
            mostrarOpcionesSeries();
            int opcion = leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1,6);
            ejecutarOpcionSeries(matrizSeries, opcion);
            if (opcion == 6) {
                break;
            }
        }
    }

}