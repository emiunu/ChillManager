import java.util.Scanner;

public class chillManager {

    public static void main(String[] args) {}

    // Función para crear matriz de pelicula
    public static Object[][] crearMatrizPeliculas(){
        return new Object[10][7];
    }

    //Función para añadir valores a la matriz pelicula
    public static Object[][] annadirPelicula(Object[][] matrizPeliculas, String titulo, int anno, String genero, int duracion, String status,int valoracion, String comentario){
        if(peliculaUnica(matrizPeliculas,titulo)){         //Se verifica que el título no esté previamente guardado
            for (int i = 0; i < matrizPeliculas.length; i++) {
                if (matrizPeliculas[i][0] == null || matrizPeliculas[i][0] == "" ) {
                    matrizPeliculas[i][0] = titulo;
                    matrizPeliculas[i][1] = anno;
                    matrizPeliculas[i][2] = genero;
                    matrizPeliculas[i][3] = duracion;
                    matrizPeliculas[i][4] = status;
                    matrizPeliculas[i][5] = valoracion;
                    matrizPeliculas[i][6] = comentario;
                    break;
                }
            }
            return matrizPeliculas;
        }else{
            System.out.println("La pelicula " + titulo + " ya se encuentra guardada");
            return matrizPeliculas;
        }

    }

    //Funcion para visualizar datos guardados en la matriz
    public static void verMatrizPeliculas(Object[][] matrizPeliculas){
        for (int i = 0; i < matrizPeliculas.length; i++) {
            if (matrizPeliculas[i][0] == null) {
                continue;
            }else{
                System.out.println("Pelicula: " + matrizPeliculas[i][0] + "| Año: " + matrizPeliculas[i][1] + "| Género: " + matrizPeliculas[i][2] + "| Duración: " + matrizPeliculas[i][3] + "| Estado: " + matrizPeliculas[i][4]+ "| Valoracion: " + matrizPeliculas[i][5] + "| Comentario: " + matrizPeliculas[i][6]);

            }
        }
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
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
        return opcion;
    }


    //Función de ejecutar las opciones del menú.
    public static void ejecutarOpcion(Object[][] matrizSeries, int opcion){
        if (opcion == 1) { //agregar
        } else if (opcion == 2) { //buscar.
        } else if (opcion == 3) { //actualizar.
        } else if (opcion == 4) { //eliminar.
        } else if (opcion == 5) { //ver todos.
        } else if (opcion == 6) { //salir.
            System.out.print("A continuación, confirme. "); //se ejecutará el continuar en el menú.
        }
    }
    //Función booleana de continuar para el menú.
    public static boolean continuarMenu(int opcion){
        boolean continuar = true;
        if(opcion == 2){
            continuar = false;
            System.out.println("Cerrando menú... ¡Hasta luego!");
        } else if(opcion != 1){
            System.out.println("Opción no válida.");
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
            int respuesta = scanner().nextInt();
            continuar = continuarMenu(respuesta);
        }
        scanner().close();
    }

}
