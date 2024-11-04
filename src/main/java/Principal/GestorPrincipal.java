package Principal;

public class GestorPrincipal {

	private GestorSerie gestorSerie;
	private GestorLibro gestorLibro;
	private GestorPelicula gestorPelicula;
	private GestorJuego gestorJuego;

	public void menuGeneral() {
		while(true) {
			mostrarMenus();
			int opcion = gestorSerie.utilidad().leerOpcionLimitada("Ingrese una opción: ", 1, 5);
			if (opcion == 5) {
				break;
			}
			ejecutarOpcionGeneral(opcion);
		}
	}

	public void ejecutarOpcionGeneral(int opcion) {
        switch (opcion) {
            case 1 -> gestorJuego.menuJuego();
            case 2 -> gestorLibro.menuLibro();
            case 3 -> gestorPelicula.menuPelicula();
            case 4 -> gestorSerie.menuSerie();
            case 5 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida.");
        }
	}

	public void mostrarMenus() {
		System.out.println("\nCHILL MANAGER");
		System.out.println("¿Qué deseas explorar?");
		System.out.println("1) Juegos.");
		System.out.println("2) Libros.");
		System.out.println("3) Películas.");
		System.out.println("4) Series.");
		System.out.println("5) Salir.");
	}

	public static void main(String[] args) {
		GestorPrincipal gestorPrincipal = new GestorPrincipal();
		gestorPrincipal.gestorSerie = new GestorSerie();
		gestorPrincipal.gestorLibro = new GestorLibro();
		gestorPrincipal.gestorPelicula = new GestorPelicula();
		gestorPrincipal.gestorJuego = new GestorJuego();
		gestorPrincipal.menuGeneral();
	}

}