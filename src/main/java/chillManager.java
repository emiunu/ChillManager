import java.util.Scanner;

import com.sun.source.tree.BreakTree;

import java.util.InputMismatchException;

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
            return new Object[10][8];
        }

        //Función para pedir un Int, junto con el mensaje correspondiente de para qué se utilizará.
        public static int pedirInt(String mensaje){
            int valor;
            while (true) {
                try {
                    System.out.print(mensaje);
                    valor = scanner().nextInt();
                    break;
                } catch(Exception InputMismatchException) {
                    System.out.println("Entrada no válida. Ingrese un número. ");
                }
            }
            return valor;
        }

        //Función para ingresar un rating restringido entre 1 y 10.
        public static int pedirRating(){
            int rating;
            while (true) {
                try {
                    System.out.print("Ingrese su rating (del 1 al 10 ; 1 = puntaje más bajo ; 10 = puntaje más alto): ");
                    rating = scanner().nextInt();
                    if ((rating >= 1) && (rating <= 10)) {
                        break;
                    } else {
                        System.out.println("Opción inválida. Inténtelo nuevamente.");
                    }
                } catch(Exception InputMismatchException) {
                    System.out.println("Entrada no válida. Ingrese un número.");
                }
            }
            return rating;
        }

        //Función para pedir el estado de visualización.
        public static int pedirStatus(){
            int opcion;
            while (true) {
                try {
                    System.out.print("Ingrese el estado de visualización (1 = Sin empezar ; 2 = Viendo ; 3 = Terminada): ");
                    opcion = scanner().nextInt();
                    if ((opcion >= 1) && (opcion <= 3)) {
                        break;
                    } else {
                        System.out.println("Opción inválida. Inténtelo nuevamente.");
                    }
                } catch (Exception InputMismatchException) {
                    System.out.println("Entrada no válida. Ingrese un número.");
                }
            }
            return opcion;
        }

        //Transformar lo pedido en la función pedirStatus().
        public static String transformarStatus(int opcion){
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
        public static int obtenerFilaDeSerie(Object[][] matrizSeries, String titulo){
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

        //Función para saber si existe espacio disponible en la matriz.
        public static boolean espacioDisponible(Object[][] matrizSeries){
            for (int i = 0; i < matrizSeries.length; i++) {
                if (matrizSeries[i][0] == null){
                    return true;
                }
            }
            return false;
        }

        //Función para obtener la primera fila vacía disponible para agregar datos. Solo debe ser llamada si hay espacio disponible.
        public static int obtenerFilaVacia(Object[][] matrizSeries){
            for (int i = 0; i < matrizSeries.length; i++) {
                if (matrizSeries[i][0] == null){
                    return i;
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
                    escribirInfoSerie(matrizSeries, titulo, pedirInt("Ingrese las temporadas totales: "), pedirInt("Ingrese los capítulos totales: "), pedirInt("Ingrese la temporada actual que está viendo: "), pedirInt("Ingrese el capítulo actual (de la temporada) en el que quedó: "), transformarStatus(pedirStatus()), pedirRating(), pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío):"), obtenerFilaVacia(matrizSeries));
                    //la función pedirStatus(), que devuelve un int, se utiliza como parámetro de transformarStatus(...), que pide un int y retorna un String, para escribir correctamente el estado de visualización una de las 3 opciones disponibles.
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
                int fila = obtenerFilaDeSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
                System.out.println("Serie encontrada.");
                System.out.println("『 Título: "+matrizSeries[fila][0]+" | Temporadas: "+matrizSeries[fila][1]+" | Capítulos: "+matrizSeries[fila][2]+" | Temporada Actual: "+matrizSeries[fila][3]+" | Capítulo Actual (de temporada): "+matrizSeries[fila][4]+" | Estado: "+matrizSeries[fila][5]+" | Rating: "+matrizSeries[fila][6]+" | Comentarios: "+matrizSeries[fila][7]+" 』");
            } else {
                System.out.println("No se encontró la serie. Asegúrese de ingresar el título correctamente.");
            }
        }

        //Función para actualizar una serie.
        public static void actualizarSerie(Object[][] matrizSeries, String titulo){
            if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
                int fila = obtenerFilaDeSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
                escribirInfoSerie(matrizSeries, pedirString("Ingrese el nuevo título: "), pedirInt("Ingrese las temporadas totales: "), pedirInt("Ingrese los capítulos totales: "), pedirInt("Ingrese la temporada actual que está viendo: "), pedirInt("Ingrese el capítulo actual (de la temporada) en el que quedó: "), transformarStatus(pedirStatus()), pedirRating(), pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío):"), fila);
                //reemplaza la información de la serie en la fila donde ya está.
            } else {
                System.out.println("No se encontró la serie. Asegúrese de ingresar el título correctamente.");
            }
        }

        //Función para reemplazar todos los valores de la serie por null.
        public static Object[][] vaciarSerie(Object[][] matrizSeries, int fila){
            matrizSeries[fila][0] = null;
            matrizSeries[fila][1] = null;
            matrizSeries[fila][2] = null;
            matrizSeries[fila][3] = null;
            matrizSeries[fila][4] = null;
            matrizSeries[fila][5] = null;
            matrizSeries[fila][6] = null;
            matrizSeries[fila][7] = null;
            return matrizSeries;
        }

        //Función para eliminar una serie.
        public static void eliminarSerie(Object[][] matrizSeries, String titulo){
            if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
                int fila = obtenerFilaDeSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
                vaciarSerie(matrizSeries,fila);
            } else {
                System.out.println("No se encontró la serie. Asegúrese de ingresar el título correctamente.");
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
        }

        //Función imprimir opciones del menú.
        public static void mostrarOpcionesSeries(){
            System.out.println("\nMenú de series:");
            System.out.println("1) Agregar serie.");
            System.out.println("2) Buscar serie.");
            System.out.println("3) Actualizar/modificar serie.");
            System.out.println("4) Eliminar serie.");
            System.out.println("5) Ver todas las series.");
            System.out.println("6) Salir.");
            System.out.print("Ingrese el número de la opción que desea seleccionar: ");
        }

        //Función de leer la opción del menú dentro del rango de operaciones disponible.
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
                } catch(Exception InputMismatchException) {
                    System.out.print("Entrada no válida. Ingrese un número: ");
                }
            }
            return opcion;
        }

        //Función de ejecutar las opciones del menú.
        public static void ejecutarOpcion(Object[][] matrizSeries, int opcion){
            if (opcion == 1) { //agregar
                agregarSerie(matrizSeries,pedirString("Ingrese el título de la serie: "));
            } else if (opcion == 2) { //buscar serie.
                buscarSerie(matrizSeries,pedirString("Ingrese el título de la serie: "));
            } else if (opcion == 3) { //actualizar serie.
                actualizarSerie(matrizSeries,pedirString("Ingrese el título de la serie: "));
            } else if (opcion == 4) { //eliminar serie.
                eliminarSerie(matrizSeries,pedirString("Ingrese el título de la serie: "));
            } else if (opcion == 5) { //ver todas las series.
                mostrarSeries(matrizSeries);
            } else if (opcion == 6) { //salir del menú.
                System.out.print("A continuación, confirme. "); //se ejecutará el continuar en el menú.
            }
        }

        //Función booleana de continuar para el menú.
        public static boolean continuarMenu(){
            boolean continuar = true;
            int opcion;
            while (true) {
                try {
                    opcion = scanner().nextInt();
                    if (opcion == 1) {
                        break;
                    } else if (opcion == 2) {
                        continuar = false;
                        break;
                    } else {
                        System.out.print("Opción inválida. Inténtelo nuevamente: ");
                    }
                } catch (Exception InputMismatchException) {
                    System.out.print("Entrada no válida. Ingrese un número: ");
                }
            }
            return continuar;
        }

        //Función para iniciar la matriz con el menú.
        public static void iniciar(){
            menuSeries(matrizSeries());
        }

        //Función menú.
        public static void menuSeries(Object[][] matrizSeries){
            boolean continuar = true;
            while(continuar){
                mostrarOpcionesSeries();
                int opcion = leerOpcion();
                ejecutarOpcion(matrizSeries, opcion);
                System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
                continuar = continuarMenu();
            }
            System.out.println("Cerrando menú... ¡Hasta luego! ^^");
            scanner().close();
        }


        //Funciones de juegos
        public static Object[][] categoriasJuegos () { // inicializa la matriz de datos con las categorías en la primera fila
            return new Object[10][6];
        }

        public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
            for (int row = 0; row < matrizJuegos.length; row++) {
                if (matrizJuegos[row][0] != null) {
                    if (((String) matrizJuegos[row][0]).replace(" ", "").toLowerCase().equals(titulo.replace(" ", "").toLowerCase())) {
                        return false;
                    }
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
                    if (((String) matrizJuegos[i][0]).replace(" ", "").toLowerCase().equals(titulo.replace(" ", "").toLowerCase())){
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


        public static void gameMenu(){
            boolean pass = true;
            Object[][] juegos = categoriasJuegos();
            while(pass){
                mostrarOpciones();
                int option = escogerOpcion(1, 6);
                correrOpciones(juegos, option);
                System.out.print("¿Desea realizar otra operación? (1 = Sí ; 0 = No): ");
                boolean continuar = continuarMenu();
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
                System.out.println("No se encuentra el juego en el registro");
            }
        }

        public static void actualizarJuego (Object[][] matrizJuegos) {
            String nombreJuego = pedirString("Ingrese el nombre del juego a modificar: ");
            if (!juegoUnico(matrizJuegos, nombreJuego)) {
                System.out.println("Ingrese los datos del juego: ");
                modificarFila(matrizJuegos, pedirString("Ingrese el nuevo nombre: "), ingresarStatus(), ingresarAno(), ingresarDLC(), obtenerRating(), pedirString("Ingrese un comentario: "), obtenerFilaJuego(matrizJuegos, nombreJuego));
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
            String nombreJuego = pedirString("Ingrese el nombre del juego a eliminar: ");
            if (!juegoUnico(matrizJuegos, nombreJuego)) {
                hacerFilaNull(matrizJuegos, obtenerFilaJuego(matrizJuegos, nombreJuego));
            }
            return matrizJuegos;
        }

        //Funciones peliculas



    // Función para crear matriz de pelicula
    public static Object[][] crearMatrizPeliculas(){
        return new Object[10][7];
    }

    //Función para añadir valores a la matriz pelicula
    public static void annadirPelicula(Object[][] matrizPeliculas, String titulo, int anno, String genero, int duracion, String status,int rating, String comentario){
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
    public static void ejecutarAnnadirPelicula(Object [][] matrizPeliculas){
        if (espacioDisponiblePeliculas(matrizPeliculas)){
            System.out.print("Ingrese el titulo de la película: ");
            String titulo = ingresarString();
            boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
            if (peliculaUnica){
                System.out.print("Ingrese el año de la película: ");
                int anno = ingresarInt();
                System.out.print("Ingrese el genero de la película: ");
                String genero = ingresarString();
                System.out.print("Ingrese la duración de la película: ");
                int duracion = ingresarInt();
                String status = ingresarStatusPelicula();
                int rating = ingresarRating();
                String comentario = ingresarComentario();
                annadirPelicula(matrizPeliculas,titulo,anno,genero,duracion,status,rating,comentario);
                System.out.println("Película guardada correctamente.");
            } else {
                System.out.println("Esta película ya se encuentra guardada.");
            }
        } else {
            System.out.println("No hay espacio disponible en la matriz :(.");
        }
    }

    //Funcion para visualizar datos guardados en la matriz
    public static void verMatrizPeliculas(Object[][] matrizPeliculas){
        System.out.println("Listado de peliculas: ");
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] == null) {
                continue;
            }else{
                System.out.println("Pelicula: " + matrizPeliculas[i][0] + "| Año: " + matrizPeliculas[i][1] + "| Género: " + matrizPeliculas[i][2] + "| Duración: " + matrizPeliculas[i][3] + "| Estado: " + matrizPeliculas[i][4]+ "| Valoracion: " + matrizPeliculas[i][5] + "| Comentario: " + matrizPeliculas[i][6]);

            }
        }
        System.out.println("Fin del listado.");
    }

    //Función para eliminar peliculas de la matriz
    public static void eliminarPelicula(Object [][] matrizPeliculas, String titulo){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] != null && matrizPeliculas[i][0].equals(titulo)) {
                matrizPeliculas[i][0] = null;
                matrizPeliculas[i][1] = null;
                matrizPeliculas[i][2] = null;
                matrizPeliculas[i][3] = null;
                matrizPeliculas[i][4] = null;
                matrizPeliculas[i][5] = null;
                matrizPeliculas[i][6] = null;
                break;
            }
        }
    }

    //Función para ejecutar eliminar película
    public static void ejecutarEliminarPelicula(Object[][] matrizPeliculas){
        System.out.print("Ingrese el titulo de la película que quiere eliminar: ");
        String titulo = ingresarString();
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            eliminarPelicula(matrizPeliculas,titulo);
            System.out.println("Pelicula eliminada corrrectamente.");
        } else {
            System.out.println("Esta película no se encuentra guardada.");
        }
    }

    //Función para buscar película
    public static void buscarPelicula(Object [][] matrizPeliculas, String titulo){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if ( matrizPeliculas[i][0] != null && matrizPeliculas[i][0].equals(titulo)) {
                System.out.println("Pelicula: " + matrizPeliculas[i][0] + "| Año: " + matrizPeliculas[i][1] + "| Género: " + matrizPeliculas[i][2] + "| Duración: " + matrizPeliculas[i][3] + "| Estado: " + matrizPeliculas[i][4]+ "| Valoracion: " + matrizPeliculas[i][5] + "| Comentario: " + matrizPeliculas[i][6]);
                break;
            }
        }
    }

    //Función para ejecutar buscar película
    public static void ejecutarBuscarPelicula(Object [][] matrizPeliculas){
        System.out.print("Ingresa el titulo de la película que quieres buscar: ");
        String titulo = ingresarString();
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            System.out.println("Resultado de busqueda:");
            buscarPelicula(matrizPeliculas,titulo);
        } else {
            System.out.println("La pelicula no se encuentre guardada.");
        }
    }

    //Función para actualizar películas de la matriz
    public static void ejecutarActualizarPelicula(Object[][] matrizPeliculas){
        System.out.print("Ingrese el titulo de la película que quieres actualizar: ");
        String titulo = ingresarString();
        boolean peliculaUnica = peliculaUnica(matrizPeliculas,titulo);
        if (!peliculaUnica){
            int fila = conseguirNumeroFila(matrizPeliculas, titulo);
            System.out.print("Ingrese el titulo: ");
            String nuevoTitulo = ingresarString();
            System.out.print("Ingrese el año: ");
            int nuevoAnno = ingresarInt();
            System.out.print("Ingrese el genero: ");
            String nuevoGenero = ingresarString();
            System.out.print("Ingrese la duración: ");
            int nuevaDuracion = ingresarInt();
            String nuevoStatus = ingresarStatusPelicula();
            int nuevoRating = ingresarRating();
            String nuevoComentario = ingresarComentario();
            actualizarPelicula(matrizPeliculas,fila,nuevoTitulo,nuevoAnno,nuevoGenero,nuevaDuracion,nuevoStatus,nuevoRating,nuevoComentario);
        } else {
            System.out.println("La película no se encuentra guardada.");
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
    public static int conseguirNumeroFila(Object[][] matrizPeliculas, String titulo){
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


    //Función para scanner de texto; título, y género.
    public static String ingresarString(){
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

    //Función para ingresar int que sean números enteros positivos
    public static int ingresarInt() {
        int intIngresar;
        while (true) {
            try {
                intIngresar = scanner().nextInt();
                if (intIngresar > 0) {
                    break;
                } else {
                    System.out.print("El numero ingresado no es valido. Intente de nuevo: ");
                }


            } catch (InputMismatchException e) {
                System.out.print("Entrada no valida. Ingrese un numero: ");
            }
        }
        return intIngresar;
    }

    //Funcion para ingresar Status
    public static String ingresarStatusPelicula(){
        String status;
        int opcion;
        while(true){
            try{
                opcionesStatusPelicula();
                opcion = scanner().nextInt();
                if (opcion == 1){
                    status = "Sin ver.";
                    break;
                } else if (opcion == 2){
                    status = "Completado.";
                    break;
                }else{
                    System.out.println("El numero ingresado no es valido. Intente de nuevo. ");

                }

            } catch (InputMismatchException e){
                System.out.println("Entrada no valida. Ingrese un numero: ");
            }
        }
        return status;
    }

    //Función que muestra las opciones de status
    public static void opcionesStatusPelicula(){
        System.out.println("Status de película:");
        System.out.println("1. Sin ver");
        System.out.println("2. Completado");
        System.out.print("Seleccione una opción: ");
    }

    //Función para ingresar rating
    public static int ingresarRating(){
        int rating;
        while(true){
            try{
                System.out.print("Ingrese el rating (1 al 10): ");
                rating = scanner().nextInt();
                if (rating >= 1 && rating <=10){
                    break;
                } else {
                    System.out.println("El numero ingresado no es valido. Intente de nuevo. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida. Ingrese un numero: ");
            }
        }
        return rating;
    }

    public static String ingresarComentario(){
        String comentario;
        System.out.print("Ingrese el comentario a la película: ");
        comentario = scanner().nextLine();
        return comentario;
    }

    //Función para saber si hay espacio disponible, esto se utilizará cuando se quiera agregar mas alla del length de la matriz Peliculas
    public static boolean espacioDisponiblePeliculas(Object [][] matrizPeliculas){
        for (int i = 0; i < matrizPeliculas.length; i++){
            if(matrizPeliculas[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpcionesPeliculas(){
        System.out.println("\nMenú de Peliculas:");
        System.out.println("1) Agregar pelicula.");
        System.out.println("2) Buscar pelicula.");
        System.out.println("3) Actualizar/modificar pelicula.");
        System.out.println("4) Eliminar pelicula.");
        System.out.println("5) Ver todas las peliculas.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }

    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcionPeliculas(Object[][] matrizPeliculas, int opcion){
        if (opcion == 1) { //añadir
            ejecutarAnnadirPelicula(matrizPeliculas);
        } else if (opcion == 2) { //buscar.
            ejecutarBuscarPelicula(matrizPeliculas);
        } else if (opcion == 3) { //actualizar.
            ejecutarActualizarPelicula(matrizPeliculas);
        } else if (opcion == 4) { //eliminar.
            ejecutarEliminarPelicula(matrizPeliculas);
        } else if (opcion == 5) { //ver todos.
            verMatrizPeliculas(matrizPeliculas);
        } else if (opcion == 6) { //salir.
            System.out.print("A continuación, confirme. "); //se ejecutará el continuar en el menú.
        }
    }



    //Función menú.
    public static void menu(){
        boolean continuar = true;
        Object [][] matrizPeliculas = crearMatrizPeliculas();
        while(continuar){
            mostrarOpcionesPeliculas();
            int opcion = leerOpcion();
            ejecutarOpcionPeliculas(matrizPeliculas, opcion);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
            continuar = continuarMenu();
        }
        scanner().close();
    }

}