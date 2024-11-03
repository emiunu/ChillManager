package Principal;
import java.util.*;

import Utilidades.Utilidad;

public class GestorJuego {

	private List<Juego> juegos;

	public Utilidad utilidad() {
		return new Utilidad();
	}

	public void opcionesStatusJuego() {
		System.out.println("Status de Videojuego:");
		System.out.println("1. Sin jugar.");
		System.out.println("2. Jugando.");
		System.out.println("3. Completado.");
	}

	public String ingresarStatusJuego() {
		String status = "";
		opcionesStatusJuego();
		int opcion = utilidad().leerOpcionLimitada("Ingrese el número correspondiente al status del juego: ", 1, 3);
        status = switch (opcion) {
            case 1 -> "Sin jugar";
            case 2 -> "Jugando";
            case 3 -> "Completado";
            default -> status;
        };
		return status;
	}

	public void ejecutarAgregarJuego() {
		String nombreJuego = utilidad().pedirString("Ingrese el nombre del juego: ");
		if (!juegoUnico(nombreJuego)) {
			System.out.println("El juego ya existe.");
		} else {
			agregarJuego(new Juego(nombreJuego, utilidad().pedirIntPositivo("Ingrese el año de lanzamiento: "), utilidad().pedirIntPositivo("Ingrese la cantidad de DLCs: "), ingresarStatusJuego(), utilidad().leerOpcionLimitada("Ingrese el rating del juego: ", 0, 10), utilidad().pedirString("Ingrese un comentario: ")));
		}
	}

	// siento que es innecesaria esta funcion, ya que es solo una linea.

	public void agregarJuego(Juego juegoAAgregar) {
		juegos.add(juegoAAgregar);
	}

	public void ejecutarEliminarJuego() {
		String nombreJuego = utilidad().pedirString("Ingrese el nombre del juego a eliminar: ");
		if (juegoUnico(nombreJuego)) {
			System.out.println("El juego no existe.");
		} else {
			eliminarJuego(buscarJuego(nombreJuego));
			System.out.println("Juego eliminado.");
		}
	}

	// Esta si siento que esta bien, porque es mas de una linea

	public void eliminarJuego(Juego juego) {
		for (Juego juegosAgregados : juegos) {
			if (juegosAgregados.getNombre().equals(juego.getNombre())) {
				juegos.remove(juegosAgregados);
				break;
			}
		}
	}

	public void ejecutarModificarJuego() {
		String nombreJuego = utilidad().pedirString("Ingrese el nombre del juego a modificar: ");
		if (juegoUnico(nombreJuego)) {
			System.out.println("El juego no existe.");
		} else {
			modificarJuego(nombreJuego);
		}
	}

	public void modificarJuego(String nombre) {
		for (Juego juego : juegos) {
			if (juego.getNombre().equals(nombre)) {
				juego.setNombre(utilidad().pedirString("Ingrese el nuevo nombre del juego: "));
				juego.setFecha(utilidad().pedirIntPositivo("Ingrese el nuevo año de lanzamiento: "));
				juego.setDlc(utilidad().pedirIntPositivo("Ingrese la nueva cantidad de DLCs: "));
				juego.setStatus(ingresarStatusJuego());
				juego.setRating(utilidad().leerOpcionLimitada("Ingrese el nuevo rating del juego: ", 0, 10));
				juego.setComentario(utilidad().pedirString("Ingrese un nuevo comentario: "));
				break;
			}
		}
	}

	public void ejecutarBuscarJuego() {
		String nombreJuego = utilidad().pedirString("Ingrese el nombre del juego a buscar: ");
		if (juegoUnico(nombreJuego)) {
			System.out.println("El juego no existe.");
		} else {
			mostrarJuego(buscarJuego(nombreJuego));
		}
	}

	// Esta funcion siento que igualmente es innecesaria, por lo menos como tengo definido el ToString.

	public void mostrarJuego(Juego juego) {
		System.out.println(juego);
	}

	public Juego buscarJuego(String nombre) {
		for (Juego juego : juegos) {
			if (juego.getNombre().equals(nombre)) {
				return juego;
			}
		}
		return null;
	}

	public void mostrarTodos() {
		for (Juego juego : juegos) {
			System.out.println(juego);
		}
	}

	public void ejecutarOpcionJuego(int opcion) {
		switch (opcion) {
			case 1:
				ejecutarAgregarJuego();
				break;
			case 2:
				ejecutarBuscarJuego();
				break;
			case 3:
				ejecutarModificarJuego();
				break;
			case 4:
				ejecutarEliminarJuego();
				break;
			case 5:
				mostrarTodos();
				break;
			case 6:
				break;
		}
	}

	public void mostrarOpcionesJuegos() {
		System.out.println("\nMenú de Juegos:");
		System.out.println("1) Agregar juego.");
		System.out.println("2) Buscar juego.");
		System.out.println("3) Actualizar/modificar juego.");
		System.out.println("4) Eliminar juego.");
		System.out.println("5) Ver todos los juegos.");
		System.out.println("6) Volver.");
	}

	public void menuJuego() {
		while (true) {
			mostrarOpcionesJuegos();
			int opcion = utilidad().leerOpcionLimitada("Ingrese una opción: ", 1, 6);
			ejecutarOpcionJuego(opcion);
			if (utilidad().leerOpcionLimitada("¿Desea realizar otra operación? (1. Sí / 2. No): ", 1, 2) == 2) {
				break;
			}
		}
	}

	public boolean juegoUnico(String nombre) {
		for (Juego juego : juegos) {
			if (juego.getNombre().equals(nombre)) {
				return false;
			}
		}
		return true;
	}

	public GestorJuego() {
		juegos = new ArrayList<Juego>();
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

	public static void main(String[] args) {
		GestorJuego gestorJuego = new GestorJuego();
		gestorJuego.menuJuego();
	}

}