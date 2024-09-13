import java.io.ObjectStreamClass;

//Esta es la rama para crear las funciones de Libros.

public class chillManager {
    public static void main(String[] args) {

    }

    public static Object[][] categoriasLibros() {
        Object [][] matrizLibros = new Object[10][6];
        matrizLibros[0] = new Object[]{(String)"ISBN",(String)"title",(String)"year",(String)"status",(String)"rating",(String)"commment"};
        return matrizLibros;
        //Se crea la primera fila con las diferentes categorias.
    }
}
