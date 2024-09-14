public class chillManager {
    public static void main(String[] args) {
    }

    //Funciones de series.

    //Función para crear la matriz de objetos.
    public static Object[][] matrizSeries(){
        return new Object[10][7];
    }

    //Función para comprobar que si ya existe.
    public static boolean serieUnica(Object[][] matrizSeries, String titulo){
        for (int i = 0; i < matrizSeries.length; i++) {
            if (matrizSeries[i][0] != null){
                if (matrizSeries[i][0] == titulo) {
                    return false;
                }
            }
        }
        return true;
    }

    //Función para obtener la fila en la que está la serie que se busca, esta solo se debe llamar luego de que la anterior sea "true".

    //Función para agregar los parámetros a la matriz
    public static Object[][] agregarInfoSerie(Object[][] matrizSeries, String titulo, int temporadas, int capitulos, int temporadaActual, int capituloActual, int rating, String comentario, int fila){
        matrizSeries[fila][0] = titulo;
        matrizSeries[fila][1] = temporadas;
        matrizSeries[fila][2] = capitulos;
        matrizSeries[fila][3] = temporadaActual;
        matrizSeries[fila][4] = capituloActual;
        matrizSeries[fila][5] = rating;
        matrizSeries[fila][6] = comentario;
        return matrizSeries;
    }

    //Función de mini menú de agregar una serie, que consiste en comprobar los métodos anteriores para decidir la acción correspondiente. Si no existe, ser agregada como nuevo, si ya existe, preguntar si se quiere modificar o agregar de todas maneras.

    //Función para mostrar todas las series.
    public static void mostrarSeries(Object[][] matrizSeries){
        for (int i = 0; i < matrizSeries.length; i++) {
           if (matrizSeries[i][0] != null) {
               System.out.println("Título: "+matrizSeries[i][0]+" | Temporadas: "+matrizSeries[i][1]+" | Capítulos: "+matrizSeries[i][2]+" | Temporada Actual: "+matrizSeries[i][3]+" | Capítulo Actual (de temporada): "+matrizSeries[i][4]+" | Rating: "+matrizSeries[i][5]+" | Comentarios: "+matrizSeries[i][6]);
           }
        }
    }

}
