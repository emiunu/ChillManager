import java.util.InputMismatchException;
import java.util.Scanner;

public class chillManager {

    public static void main(String[] args) {
        menu();
    }

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
        if (espacioDisponible(matrizPeliculas)){
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
                String status = ingresarStatus();
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
            if (matrizPeliculas[i][0].equals(titulo)) {
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
            String nuevoStatus = ingresarStatus();
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

    //Función para llamar scanner
    public static Scanner scanner(){
        return new Scanner(System.in);
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
    public static String ingresarStatus(){
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

    //Funcion que muestra las opciones de status
    public static void opcionesStatusPelicula(){
        System.out.println("Status de película:");
        System.out.println("1. Sin ver");
        System.out.println("2. Completado");
        System.out.print("Seleccione una opción: ");
    }

    //Funcion para ingresar rating
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
    public static boolean espacioDisponible(Object [][] matrizPeliculas){
        for (int i = 0; i < matrizPeliculas.length; i++){
            if(matrizPeliculas[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función imprimir opciones del menú.
    public static void mostrarOpciones(){
        System.out.println("\nMenú de Peliculas:");
        System.out.println("1) Agregar pelicula.");
        System.out.println("2) Buscar pelicula.");
        System.out.println("3) Actualizar/modificar pelicula.");
        System.out.println("4) Eliminar pelicula.");
        System.out.println("5) Ver todas las peliculas.");
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
            } catch(InputMismatchException e ){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }



    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcion(Object[][] matrizPeliculas, int opcion){
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
    //Función booleana de continuar para el menú.
    public static boolean continuarMenu(){
        int opcion;
        boolean continuar;
        while (true){
            try {
                opcion = scanner().nextInt();
                if(opcion == 2){
                    continuar = false;
                    System.out.println("Cerrando menú... ¡Hasta luego!");
                    break;
                } else if(opcion == 1){
                    continuar = true;
                    break;
                } else {
                    System.out.print("Ingrese una opción valida: ");
                }
            } catch (InputMismatchException e){
                System.out.print("Entrada no valida. Ingrese un numero: ");
            }

        }

        return continuar;
    }


    //Función menú.
    public static void menu(){
        boolean continuar = true;
        Object [][] matrizPeliculas = crearMatrizPeliculas();
        while(continuar){
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(matrizPeliculas, opcion);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
            continuar = continuarMenu();
        }
        scanner().close();
    }

}
