public class chillManager {
    public static void main(String[] args) {
    }

    public static Object[][] categoriasJuegos () {
        Object [][] matrizJuegos = new Object[10][6];
        matrizJuegos[0] = new Object[]{(String)"title",(String)"status",(String)"rating",(String)"comment",(String)"year",(String)"DLC"};
        return matrizJuegos;
    }

    public static boolean juegoUnico (Object [][] matrizJuegos, String titulo) {
        for (Object[] matrizJuego : matrizJuegos) {
            if (matrizJuego[0] != null) {
                if (matrizJuego[0].equals(titulo))
                    return false;
            }
        }
        return true;
    }
}
