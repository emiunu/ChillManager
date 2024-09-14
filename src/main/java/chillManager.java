public class chillManager {
    public static void main(String[] args) {
        Object[][] juegos = categoriasJuegos();
    }

    public static Object[][] categoriasJuegos () {
        Object [][] matrizJuegos = new Object[10][6];
        matrizJuegos[0] = new Object[]{(String)"title",(String)"status",(String)"year",(String)"DLC",(String)"rating",(String)"comment"};
        return matrizJuegos;
    }

    public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
        for (int row = 1; row < matrizJuegos.length; row++) {
            if (matrizJuegos[row][0] != null) {
                if (matrizJuegos[row][0].equals(titulo))
                    return false;
            }
        }
        return true;
    }

    public static Object[][] modificarFila (Object[][] matriz, String titulo, String status, int year, int dlc, int rating, String comment, int row) {
        matriz[row] = new Object[]{(String) titulo, (String) status, (Integer) year, (Integer) dlc, (Integer) rating, (String) comment};
        return matriz;
    }

    public static Object[][] agregarJuego (Object[][] matrizJuegos, String titulo, String status, int year, int dlc, int rating, String comment) {
        if (juegoUnico(matrizJuegos, titulo)) {
            for (int i = 0; i < matrizJuegos.length; i++) {
                if (matrizJuegos[i][0] == null) {
                    modificarFila(matrizJuegos, titulo, status, year, dlc, rating, comment, i );
                    return matrizJuegos;
                }
            }
        }
        System.out.println("El juego ya se encuentra agregado.");
        return matrizJuegos;
    }
    public static void mostrarJuegos (Object[][] matrizJuegos) {
        System.out.println(matrizJuegos[0][0] + " | " + matrizJuegos[0][1] + " | " + matrizJuegos[0][2] + " | " + matrizJuegos[0][3] + " | " + matrizJuegos[0][4] + " | " + matrizJuegos[0][5] + " | ");
        for (int row = 1; row < matrizJuegos.length; row++) {
            if (matrizJuegos[row][0] != null) {
                System.out.println(matrizJuegos[row][0] + " | " + matrizJuegos[row][1] + " | " + matrizJuegos[row][2] + " | " + matrizJuegos[row][3] + " | " + matrizJuegos[row][4] + " | " + matrizJuegos[row][5] + " | ");
            } else {
                break;
            }
        }
    }
}
