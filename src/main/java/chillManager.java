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
}
