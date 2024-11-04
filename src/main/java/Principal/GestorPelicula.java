package Principal;

import Utilidades.Utilidad;

import java.util.*;

public class GestorPelicula {

	private ArrayList<Pelicula> peliculas;

	public GestorPelicula() {
		this.peliculas = new ArrayList<>();
	}

	public Utilidad utilidad(){
		return new Utilidad();
	}

	public String ingresarStatusPelicula(){
		String status = "";
		opcionesStatusPelicula();
		int opcion = utilidad().leerOpcionLimitada("Seleccione una opción: ",1, 2);
		if (opcion == 1){
			status = "Sin ver";
		} else {
			status = "Completado";
		}
		return status;
	}

	public void opcionesStatusPelicula(){
		System.out.println("Status de película:");
		System.out.println("1. Sin ver.");
		System.out.println("2. Completado.");
	}

	public void ejecutarAgregarPelicula() {
		String titulo = utilidad().pedirString("Ingrese el titulo de la película que quiere agregar: ");
		if (peliculaUnica(titulo)){
			Pelicula pelicula = new Pelicula(titulo, utilidad().pedirIntPositivo("Ingrese el año de la película: "),utilidad().pedirString("Ingrese el género de la película: "), utilidad().pedirIntPositivo("Ingrese la duración de la película (minutos): "), ingresarStatusPelicula(),utilidad().leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10),utilidad().pedirString("Ingrese un comentario: "));
			agregarPelicula(pelicula);
			System.out.println("Película guardada correctamente.");
		} else {
			System.out.println("La película ya se encuentra registrada.");
		}

	}


	public void agregarPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	public void ejecutarEliminarPelicula() {
		String titulo = utilidad().pedirString("Ingrese el titulo de la película que quiere eliminar: ");
		if (!peliculaUnica(titulo)){
			eliminarPelicula(buscarPelicula(titulo));
			System.out.println("Película eliminada correctamente.");

		} else {
			System.out.println("No se encontró la película");

		}

	}


	public void eliminarPelicula(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}



	public void ejecutarModificarPelicula() {
		String titulo = utilidad().pedirString("Ingrese el titulo de la película que quiere actualizar/modificar: ");
		if (!peliculaUnica(titulo)){
			modificarPelicula(titulo, nuevoTitulo(titulo), utilidad().pedirIntPositivo("Ingrese el año: "), utilidad().pedirString("Ingrese el género: "), utilidad().pedirIntPositivo("Ingrese la duración: "), ingresarStatusPelicula(),utilidad().leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10), utilidad().pedirString("Ingrese comentario: "));
			System.out.println("Actualización realizada correctamente.");
		} else {
			System.out.println("No se encontró la película.");

		}
	}

	public String nuevoTitulo(String titulo){
		String nuevoTitulo = "";
		while (true){
			nuevoTitulo = utilidad().pedirString("Ingrese el nuevo titulo: ");
			if (peliculaUnica(nuevoTitulo) || nuevoTitulo.equals(titulo)){
				break;
			}
			System.out.print("Titulo no valido. Intente nuevamente. ");
		}
		return nuevoTitulo;
	}


	public void modificarPelicula(String titulo, String nuevoTitulo, int nuevoAnno, String nuevoGenero, int nuevaDuracion, String nuevoStatus, int nuevoRating, String nuevoComentario ) {
		for (Pelicula pelicula : peliculas){
			if (pelicula.getTitulo().equals(titulo)){
				pelicula.setTitulo(nuevoTitulo);
				pelicula.setAnno(nuevoAnno);
				pelicula.setGenero(nuevoGenero);
				pelicula.setDuracion(nuevaDuracion);
				pelicula.setStatus(nuevoStatus);
				pelicula.setRating(nuevoRating);
				pelicula.setComentario(nuevoComentario);
				break;
			}
		}
	}



	public void ejecutarBuscarPelicula() {
		String titulo = utilidad().pedirString("Ingresa el titulo de la película que quiere buscar: ");
		if (!peliculaUnica(titulo)){
			System.out.println("Película encontrada.");
			mostrarPelicula(buscarPelicula(titulo));
		} else {
			System.out.println("No se encontró la película.");
		}
	}


	public Pelicula buscarPelicula(String titulo) {
		for (Pelicula pelicula : peliculas){
			if (pelicula.getTitulo().equals(titulo)){
				return pelicula;
			}
		}
		return null;
	}


	public void mostrarPelicula(Pelicula pelicula) {
		System.out.println(pelicula.toString());
	}

	public void mostrarTodos() {
		System.out.println("LISTA DE PELÍCULAS");
		System.out.println("===================================");
		for (Pelicula pelicula : peliculas){
			mostrarPelicula(pelicula);
		}
		System.out.println("FIN DEL LISTADO.");
	}




	public void ejecutarOpcionPelicula(int opcion) {
		if (opcion == 1) { //añadir
			ejecutarAgregarPelicula();
		} else if (opcion == 2) { //buscar.
			ejecutarBuscarPelicula();
		} else if (opcion == 3) { //actualizar.
			ejecutarModificarPelicula();
		} else if (opcion == 4) { //eliminar.
			ejecutarEliminarPelicula();
		} else if (opcion == 5) { //ver todos.
			mostrarTodos();
		} else if (opcion == 6) { //volver al menú.
			System.out.println("Volviendo al menú general...");
		}
	}

	public void mostrarOpcionesPeliculas(){
		System.out.println("\nMenú de Películas:");
		System.out.println("1) Agregar película.");
		System.out.println("2) Buscar película.");
		System.out.println("3) Actualizar/modificar película.");
		System.out.println("4) Eliminar película.");
		System.out.println("5) Ver todas las películas.");
		System.out.println("6) Volver.");
	}

	public void menuPelicula() {
		while (true){
			mostrarOpcionesPeliculas();
			int opcion = utilidad().leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ", 1, 6);
			ejecutarOpcionPelicula(opcion);
			if (opcion == 6){
				break;
			}
		}
	}

	public boolean peliculaUnica(String titulo) {
		for (Pelicula pelicula : peliculas){
			if (pelicula.getTitulo().equals(titulo)){
				return false;
			}
		}
		return true;
	}
}