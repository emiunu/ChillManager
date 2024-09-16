import java.io.ObjectStreamClass;
import java.util.Scanner;

//Esta es la rama para crear las funciones de Libros.

public class chillManager {
    public static void main(String[] args) {
        iniciarLibros();
    }

    public static void iniciarLibros(){
        menu(matrizLibros());
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static Object[][] matrizLibros() {
        Object [][] matrizLibros = new Object[10][7];
        return matrizLibros;
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

    //Función para saber si existe espacio disponible en la matriz.
    public static boolean espacioDisponible(Object[][] matrizLibros){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] == null){
                return true;
            }
        }
        return false;
    }

    //Función para obtener la primera fila vacía disponible para agregar datos. Solo debe ser llamada si hay espacio disponible.
    public static int obtenerFilaVacia(Object[][] matrizLibros){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] == null){
                return i;
            }
        }
        return 0;
    }

    public static Object[][] escribirInfoLibro(Object[][] matrizLibros,int ISBN,String titulo,String autor,int year,String status,int rating,String commment, int fila){
        matrizLibros[fila][0] = ISBN;
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
                escribirInfoLibro(matrizLibros,isbn,pedirString("Dime el titulo del libro: "),pedirString("Dime el autor del libro: "),pedirInt("Dime el año del libro: "), transformarStatus(pedirStatus()),pedirRating(),pedirString("Ingrese un comentario sobre el libro: "),obtenerFilaVacia(matrizLibros));
            }else System.out.println("No hay espacio disponible para agregar un libro.");
        }else System.out.println("El libro ya se encuentra agregado.");
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
    public static void ejecutarOpcion(Object[][] matrizLibros, int opcion){
        if (opcion == 1) {
            agregarLibro(matrizLibros, pedirInt("Dime el isbn del libro: "));//agregar
        } else if (opcion == 2) {
            buscarLibro(matrizLibros,pedirInt("Dime el isbn del libro que quieres buscar: "));//buscar.
        } else if (opcion == 3) {
            actualizarLibro(matrizLibros,pedirInt("Dime el isbn del libro que quieres actualizar: ")    );//actualizar.
        } else if (opcion == 4) {
            eliminarLibro(matrizLibros, pedirInt("Dime el isbn del libro que quieres eliminar: "));//eliminar.
        } else if (opcion == 5) {
            mostrarLibros(matrizLibros);//ver todos.
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


    //Funcion que muestra las opciones de status de lecutra de libro.
    public static void opcionesStatusLibros(){
        System.out.println("Status Libro:");
        System.out.println("1. No leido");
        System.out.println("2. leyendo actualmente");
        System.out.println("3. Completado");
        System.out.print("Seleccione una opción: ");
    }

    //Función para obtener la fila en la que está el libro que se busca. Solo debe ser llamada si el libro ya fue encontrado (ya existe en la matriz).
    public static int obtenerFilaDeLibro(Object[][] matrizLibros, int isbn){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null){
                if (matrizLibros[i][1].equals(isbn)){
                    return i;
            }
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

    //Función para pedir el estado de visualización.
    public static int pedirStatus(){
        int opcion;
        while (true) {
            try {
                System.out.print("Ingrese el estado de lectura (1 = Sin leer ; 2 = Leyendo ; 3 = Terminado): ");
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
            int fila = obtenerFilaDeLibro(matrizLibros,isbn);
            System.out.println("Libro encontrado.");
            System.out.println("『 ISBN: "+matrizLibros[fila][0]+" | Titulo: "+matrizLibros[fila][1]+" | Autor: "+matrizLibros[fila][2]+" | Año: "+matrizLibros[fila][3]+" | Status: "+matrizLibros[fila][4]+" | Rating: "+matrizLibros[fila][5]+" | Comentarios: "+matrizLibros[fila][6]+" 』");
        }else System.out.println("Libro no encontrado.");
    }

    public static void actualizarLibro(Object[][]matrizLibros,int ISBN){
        if (!libroUnico(matrizLibros,ISBN)){
            int fila = obtenerFilaDeLibro(matrizLibros,ISBN);
            escribirInfoLibro(matrizLibros,ISBN,pedirString("Dime el nuevo titulo: "),pedirString("Dime el nuevo autor: "),pedirInt("Dime el nuevo año: "),transformarStatus(pedirStatus()),pedirRating(),pedirString("Dime un comentario del libro: "), fila);
        } else System.out.println("Libro no encontrado.");
    }

    public static Object[][] vaciarLibro(Object[][] matrizLibros,int fila){
            matrizLibros[fila][0] = null;
            matrizLibros[fila][1] = null;
            matrizLibros[fila][2] = null;
            matrizLibros[fila][3] = null;
            matrizLibros[fila][4] = null;
            matrizLibros[fila][5] = null;
            matrizLibros[fila][6] = null;
            return matrizLibros;
    }

    public static void eliminarLibro(Object[][] matrizLibros, int isbn){
        if (!libroUnico(matrizLibros,isbn)) { //Si la serie ya se encuentra en la matriz.
            int fila = obtenerFilaDeLibro(matrizLibros,isbn); //Obtener la fila donde está esa serie.
            vaciarLibro(matrizLibros,fila);
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No se encontró el libro. Asegúrese de ingresar el isbn de manera correcta.");
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
    }

}
