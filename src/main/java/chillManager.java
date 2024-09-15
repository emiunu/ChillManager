import java.io.ObjectStreamClass;
import java.util.Scanner;

//Esta es la rama para crear las funciones de Libros.

public class chillManager {
    public static void main(String[] args) {
        menu();
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static Object[][] categoriasLibros() {
        Object [][] matrizLibros = new Object[10][6];
        matrizLibros[0] = new Object[]{(String)"ISBN",(String)"title",(String)"year",(String)"status",(String)"rating",(String)"commment"};
        return matrizLibros;
        //Se crea la primera fila con las diferentes categorias.
    }


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
        //Verificacion de existencia de libro unico por isbn
    }

    public static Object[][] agregarLibro(Object[][] matrizLibros,int ISBN,String titulo,String year,String status,String rating,String commment) {
        if(libroUnico(matrizLibros,ISBN)){
            for (int i = 0; i < matrizLibros.length; i++) {
            if (matrizLibros[i][0] == null) {
                matrizLibros[i][0] = ISBN;
                matrizLibros[i][1] = titulo;
                matrizLibros[i][2] = year;
                matrizLibros[i][3] = status;
                matrizLibros[i][4] = rating;
                matrizLibros[i][5] = commment;
                return matrizLibros;
            }
        }
        }
        System.out.println("Ya existe este libro en la biblioteca.");
        return null;
        //Fucion para agregar un libro nuevo dependiendo de ciertos parametros.
    }

    public static void mostrarOpciones(){
        System.out.println("\nMenú libros:");
        System.out.println("1) Agregar libro.");
        System.out.println("2) Buscar libro.");
        System.out.println("3) Consultar disponibilidad de un producto.");
        System.out.println("4) Ver todos los libros.");
        System.out.println("5) Eliminar libro o actualizar libro.");
        System.out.println("6) Salir.");
        System.out.print("Ingrese el número de la opción que desea seleccionar: ");
        //Funcion para imprimir las distintas opciones para la parte de libros
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

    public static void ejecutarOpcion(int opcion){
        if(opcion == 1){

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

    public static void menu(){
        boolean continuar = true;
        while(continuar){
            mostrarOpciones();
            int opcion = leerOpcion();
            ejecutarOpcion(opcion);
            System.out.print("¿Desea realizar otra operación? (1 = Sí ; 2 = No): ");
            int respuesta = scanner().nextInt();
            continuar = continuarMenu(respuesta);
        }
        scanner().close();
    }

}
