public class chillManager {

    public static void main(String[] args) {}

    // Función para crear matriz de pelicula
    public static Object[][] crearMatrizPeliculas(){
        return new Object[10][6];
    }

    //Función para añadir valores a la matriz pelicula
    public static Object[][] annadirPelicula(Object[][] matrizPeliculas, String titulo, int anno, String genero, int duracion, int valoracion, String comentario){
        if(peliculaUnica(matrizPeliculas,titulo)){         //Se verifica que el título no esté previamente guardado
            for (int i = 0; i < matrizPeliculas.length; i++) {
                if (matrizPeliculas[i][0] == null || matrizPeliculas[i][0] == "" ) {
                    matrizPeliculas[i][0] = titulo;
                    matrizPeliculas[i][1] = anno;
                    matrizPeliculas[i][2] = genero;
                    matrizPeliculas[i][3] = duracion;
                    matrizPeliculas[i][4] = valoracion;
                    matrizPeliculas[i][5] = comentario;
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
            if (matrizPeliculas[i][0] == null || matrizPeliculas[i][0] == "") {
                continue;
            }else{
                System.out.println("Pelicula: " + matrizPeliculas[i][0] + "| Año: " + matrizPeliculas[i][1] + "| Género: " + matrizPeliculas[i][2] + "| Duración: " + matrizPeliculas[i][3] + "| Valoracion: " + matrizPeliculas[i][4] + "| Comentario: " + matrizPeliculas[i][5]);

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

}
