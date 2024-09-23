import java.util.Scanner;


//Esta es la rama para crear las funciones de Libros.

public class chillManager {
    public static void main(String[] args) {
        menuLibros(matrizLibros());
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

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

    public static int leerOpcionLimitada(String mensaje,int min, int max){
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


    //Función para obtener la fila en la que está el libro que se busca. Solo debe ser llamada si el libro ya fue encontrado (ya existe en la matriz).
    public static int obtenerFilaLibro(Object[][] matrizLibros, int isbn){
        for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] != null){
                if (matrizLibros[i][0].equals(isbn)){
                    return i;
                }
            }
        }
        return 0;
    }


    public static int obtenerRating(){
        return leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10);
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

    public static Object [][] vaciarFila(Object[][] matriz, int fila, int columnas) {
        for (int i = 0; i < columnas; i ++) {
            matriz[fila][i] = null;
        }
        return matriz;
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

}
