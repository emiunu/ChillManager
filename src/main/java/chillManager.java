public class chillManager {
    public static void main(String[] args) {
    }

    //Funciones de series.

    public static Object[][] matrizSeries(){
        return new Object[10][7];
    }

    public static Object[][] agregarInfoSerie(Object[][] matrizSeries, String nombre, int temporadas, int capitulos, int temporadaActual, int capituloActual, int calificacion, String comentario){
        for (int i = 0; i < matrizSeries.length; i++) {
            matrizSeries[i][0] = nombre;
            matrizSeries[i][1] = temporadas;
            matrizSeries[i][2] = capitulos;
            matrizSeries[i][3] = temporadaActual;
            matrizSeries[i][4] = capituloActual;
            matrizSeries[i][5] = calificacion;
            matrizSeries[i][6] = comentario;
        }
        return matrizSeries;
    }
}
