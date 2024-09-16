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

    //Función para pedir un String, junto con el mensaje correspondiente de para qué se utilizará.
    public static String pedirString(String mensaje){
        System.out.print(mensaje);
        return scanner().nextLine();
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
}
