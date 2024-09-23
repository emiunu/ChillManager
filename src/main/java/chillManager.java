import java.util.Scanner;

public class chillManager {

    public static void main(String[] args) {
        menuPeliculas(crearMatrizPeliculas());
    }

    // Función para crear matriz de pelicula
    public static Object[][] crearMatrizPeliculas(){
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

    public static Object[][] vaciarFila(Object [][] matriz, int fila, int columnas){
        for (int i = 0; i < columnas; i++) {
            matriz[fila][i] = null;
        }
        return matriz;
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

    //Función para llamar scanner
    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    //Función para scanner de texto; título, y género.
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

    //Función para ingresar int que sean números enteros positivos
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

    public static int pedirIntPositivo (String mensaje) {
        while (true) {
            int numero = pedirInt(mensaje);
            if (numero < 0) {
                System.out.println("Ingrese un número positivo.");
            } else {
                return numero;
            }
        }
    }

    public static int obtenerRating(){
        return leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 puntaje más alto): ", 1, 10);
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



    //Función para saber si hay espacio disponible, esto se utilizará cuando se quiera agregar mas alla del length de la matriz Peliculas
    public static boolean espacioDisponible(Object [][] matrizPeliculas){
        for (int i = 0; i < matrizPeliculas.length; i++){
            if(matrizPeliculas[i][0] == null){
                return true;
            }
        }
        return false;
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
            System.out.print("Volviendo al menú general...");
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

}
