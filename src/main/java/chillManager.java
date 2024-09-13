public class chillManager {
    public static void main(String[] args) {}

    // Función para crear matriz de pelicula
    public static Object[][] crearMatrizPeliculas(){
        return new Object[10][6];
    }

    //Función para añadir valores a la matriz pelicula
    public static Object[][] annadirPeliculas(Object[][] peliculas, String titulo, int anno, String genero, int duracion, int valoracion, String comentario){
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i][0] == null || peliculas[i][0] == "" ) {
                peliculas[i][0] = titulo;
                peliculas[i][1] = anno;
                peliculas[i][2] = genero;
                peliculas[i][3] = duracion;
                peliculas[i][4] = valoracion;
                peliculas[i][5] = comentario;
                break;
            }
        }
        return peliculas;
    }

    //Funcion para visualizar datos guardados en la matriz
    public static void verMatrizPeliculas(Object[][] peliculas){
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i][0] == null || peliculas[i][0] == "") {
                continue;
            }else{
                System.out.println("Pelicula: " + peliculas[i][0] + "| Año: " + peliculas[i][1] + "| Género: " + peliculas[i][2] + "| Duración: " + peliculas[i][3] + "| Valoracion: " + peliculas[i][4] + "| Comentario: " + peliculas[i][5]);

            }
        }
    }


}
