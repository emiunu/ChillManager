import java.io.ObjectStreamClass;
import java.util.Scanner;

//Esta es la rama para crear las funciones de Libros.

public class chillManager {
    public static void main(String[] args) {
    }

    public static void iniciarLibros(){
        menu(matrizLibros());
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static Object[][] matrizLibros() {
        Object [][] matrizLibros = new Object[10][7];
        matrizLibros[0] = new Object[]{(String)"ISBN",(String)"title",(String)"autor",(String)"year",(String)"status",(String)"rating",(String)"commment"};
        return matrizLibros;
        //Se crea la primera fila con las diferentes categorias.
    }

    //Verificacion de existencia de libro unico por isbn
    public static boolean libroUnico(Object [][]matrizLibros,int ISBN){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null){
                if (matrizLibros[i][0].equals(ISBN)) {
                    return false;
                }
            }else{
                break;
            }
        }
        return true;
    }

    //Fucion para agregar un libro nuevo dependiendo de ciertos parametros.
    public static Object[][] agregarLibro(Object[][] matrizLibros,int ISBN,String titulo,String autor,String year,String status,String rating,String commment) {
        if(libroUnico(matrizLibros,ISBN)){
            for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] == null) {
                matrizLibros[i][0] = ISBN;
                matrizLibros[i][1] = titulo;
                matrizLibros[i][2] = autor;
                matrizLibros[i][3] = year;
                matrizLibros[i][4] = status;
                matrizLibros[i][5] = rating;
                matrizLibros[i][6] = commment;
                return matrizLibros;
            }
        }
        }
        System.out.println("Ya existe este libro en la biblioteca.");
        return null;
    }

    //Funcion para imprimir las distintas opciones para la parte de libros
    public static void mostrarOpciones(){
        System.out.println("\nMenú libros:");
        System.out.println("1) Agregar libro.");
        System.out.println("2) Buscar libro.");
        System.out.println("3) Actualizar/modificar libro.");
        System.out.println("4) Eliminar libro.");
        System.out.println("5) Ver todos los libros.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
    }

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
        //Esta funcion pide la opcion
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

    public static boolean continuarMenu(int opcion){
        boolean continuar = true;
        if(opcion == 2){
            continuar = false;
            System.out.println("Cerrando menú... ¡Hasta luego! ^^");
        } else if(opcion != 1){
            System.out.println("Opción no válida.");
        }
        return continuar;
    }

    public static void menu(Object [][]matrizLibros){
        boolean continuar = true;
        while(continuar){
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(matrizLibros,opcion);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
            int respuesta = scanner().nextInt();
            continuar = continuarMenu(respuesta);
        }
        scanner().close();
    }

    //Función para saber si existe espacio disponible.
    public static boolean espacioDisponible(Object[][] matrizLibros){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] == null){
                return true; //Devuelve true si la matriz encuentra algun espacio null, ya que si existe espacio.
            }
        }
        return false; //Devuelve false si no encuentra ningun espacio vacia.
    }

    //Funcion que muestra las opciones de status de lecutra de libro.
    public static void opcionesStatusLibros(){
        System.out.println("Status Libro:");
        System.out.println("1. No leido");
        System.out.println("2. leyendo actualmente");
        System.out.println("3. Completado");
        System.out.print("Seleccione una opción: ");
    }

    //Función para obtener la fila en la que está el libro que se busca. Solo debe ser llamada si el libro ya fue encontrado (ya existe en la matriz).
    public static int obtenerFilaDeSerie(Object[][] matrizSeries, String titulo){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][1].equals(titulo)){
                return i;
            }
        }
        return 0;
    }

    public static int pedirRating(){
        int rating;
        while (true) {
            try {
                System.out.print("Ingrese su rating (del 1 al 10): ");
                rating = scanner().nextInt();
                if ((rating >= 1) && (rating <= 10)) {
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

    public static int pedirAño(){
        int valor;
        while (true) {
            try {
                System.out.print("Ingrese el año del libro: ");
                valor = scanner().nextInt();
                break;
            } catch(Exception InputMismatchException){
                System.out.print("Entrada no válida. Ingrese un número. ");
            }
        }
        return valor;
    }

    public static String pedirTitulo(){
        System.out.print("Dime el titulo del libro: ");
        return scanner().nextLine();
    }

    public static String pedirAutor(){
        System.out.print("Dime el autor del libro: ");
        return scanner().nextLine();
    }

    public static String pedirComentario(){
        System.out.print("Dime un comentario del libro: ");
        return scanner().nextLine();
    }

    public static void buscarLibro(Object[][] matrizLibros, String isbn){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][1] != null) {
                if (matrizLibros[i][0].equals(isbn)) {
                    System.out.println("Se ha encontrado el libro.");
                }else {
                    System.out.println("No se ha encontrado el libro");
                }
            }else {
                System.out.println("No se ha encontrado el libro.");
            }
        }
    }

    public static void actualizarLibro(Object[][]matriz,int ISBN,String titulo,String autor,String year,String status,String rating,String commment){
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][1] != null) {
                if (matriz[i][0].equals(ISBN)) {
                    matriz[i][1] = titulo;
                    matriz[i][2] = autor;
                    matriz[i][3] = year;
                    matriz[i][4] = status;
                    matriz[i][5] = rating;
                    matriz[i][6] = commment;
                }else{
                    System.out.println("No se ha encontrado el libro.");
                }
            }
        }
    }

    public static void eliminarLibro(Object[][] matrizLibros,int fila){
        for (int i = 0; i < matrizLibros.length; i++) {
            matrizLibros[fila][0] = null;
            matrizLibros[fila][1] = null;
            matrizLibros[fila][2] = null;
            matrizLibros[fila][3] = null;
            matrizLibros[fila][4] = null;
            matrizLibros[fila][5] = null;
            matrizLibros[fila][6] = null;
            System.out.println("Se ha eliminado el libro.");
        }
    }

    public static String transformarStatus(int opcion){
        String status = "";
        if (opcion == 1){
            status = "Sin leer.";
        } else if (opcion == 2){
            status = "Leyendo.";
        } else if (opcion == 3){
            status = "Terminado.";
        }
        return status;
    }

    public static void mostrarLibros(Object[][] matrizLibros){
        System.out.println("LISTA DE LIBROS");
        System.out.println("===================================");
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null) {
                System.out.println("『 ISBN: "+matrizLibros[i][0]+" | Titulo: "+matrizLibros[i][1]+" | Autor: "+matrizLibros[i][2]+" | Año: "+matrizLibros[i][3]+" | Status: "+matrizLibros[i][4]+" | Rating: "+matrizLibros[i][5]+" | Comentarios: "+matrizLibros[i][6]+" 』");
            }
        }
    }

}
