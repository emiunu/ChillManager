import java.util.InputMismatchException;
import java.util.Scanner;

public class chillManager {
    public static void main(String[] args) {
        menuSeries(matrizSeries());
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

    //Función para pedir un String, junto con el mensaje correspondiente de para qué se utilizará.
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

    //Función para saber si existe espacio disponible en la matriz.
    public static boolean espacioDisponible(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función para obtener la primera fila vacía disponible para agregar datos. Solo debe ser llamada si hay espacio disponible.
    public static int obtenerFilaVacia(Object[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null){
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

    //Función para reemplazar todos los valores de la serie por null.
    public static Object [][] vaciarFila(Object[][] matriz, int fila, int columnas) {
        for (int i = 0; i < columnas; i ++) {
            matriz[fila][i] = null;
        }
        return matriz;
    }

    //Función para eliminar una serie.
    public static void eliminarSerie(Object[][] matrizSeries, String titulo){
        if (!serieUnica(matrizSeries,titulo)) { //Si la serie ya se encuentra en la matriz.
            int fila = obtenerFilaSerie(matrizSeries,titulo); //Obtener la fila donde está esa serie.
            vaciarFila(matrizSeries,fila,8);
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
            System.out.print("Volviendo al menú general...");
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
