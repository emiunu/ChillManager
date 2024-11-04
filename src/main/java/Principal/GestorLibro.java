package Principal;

import Utilidades.Utilidad;

import java.util.*;


public class GestorLibro {

	private ArrayList<Libro> libros;

	public GestorLibro() {
		this.libros = new ArrayList<>();
	}

	public Utilidad utilidad(){
		return new Utilidad();
	}

	public void opcionesStatusLibro(){
		System.out.println("\nStatus de libro");
		System.out.println("1. Sin leer.");
		System.out.println("2. Leyendo.");
		System.out.println("3. Terminado.");
	}

	public String ingresarStatusLibro(){
		String status = "";
		opcionesStatusLibro();
		int opcion = utilidad().leerOpcionLimitada("Ingrese el numero correspondiente al estado del libro: ", 1, 3);
		status = switch (opcion){
			case 1 -> "Sin leer";
			case 2 -> "Leyendo";
			case 3 -> "Terminado";
			default -> status;
		};
		return status;
	}

	public void ejecutarAgregarLibro() {
		int isbnLibro = utilidad().pedirInt("Ingrese el isbn del libro: ");
		if (!libroUnicoIsbn(isbnLibro)) {
			System.out.println("El libro ya existe.");
		}else {
			agregarLibro(new Libro(isbnLibro, utilidad().pedirString("Ingrese el titulo: "), utilidad().pedirString("Ingrese el autor: "), utilidad().pedirInt("Ingrese el año de lanzamiento: "),ingresarStatusLibro(), utilidad().leerOpcionLimitada("Ingrese el rating del libro: ",0,10), utilidad().pedirString("Ingrese un comentario sobre el libro: ")));
		}
	}

	public void agregarLibro(Libro libro) {
		libros.add(libro);
	}

	public void ejecutarEliminarLibro() {
		int isbnLibro = utilidad().pedirInt("Ingrese el isbn del libro que desea eliminar: ");
		if(buscarLibroIsbn(isbnLibro) != null){
			libros.remove(buscarLibroIsbn(isbnLibro));
		}else System.out.println("El libro ya ha sido eliminado o no existe.");
	}

	public void eliminarLibro(Libro libro) {
		libros.remove(libro);
	}

	public void ejecutarModificarLibro() {
		int isbnLibro = utilidad().pedirIntPositivo("Ingrese el isbn del libro que desea modificar: ");
		if (buscarLibroIsbn(isbnLibro) != null) {
			modificarLibro(utilidad().pedirInt("Ingrese el nuevo isbn del libro: "),
					utilidad().pedirString("Ingrese el nuevo titulo: "),
					utilidad().pedirString("Ingrese el nuevo autor: "),
					utilidad().pedirInt("Ingrese en nuevo año de lanzamiento: "),
					ingresarStatusLibro(), utilidad().leerOpcionLimitada("Ingrese el nuevo rating del libro: ",0,10),
					utilidad().pedirString("Ingrese un comentario sobre el libro: "));
		}
		else System.out.println("El libro no existe.");
	}

	public void modificarLibro(int isbnLibro, String nuevoTitulo, String nuevoAutor, int nuevoAnno, String nuevoStatus, int nuevoRating, String nuevoComentario) {
		for (Libro libro : libros) {
			if (libro.getIsbn() == isbnLibro) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setAnno(nuevoAnno);
				libro.setStatus(nuevoStatus);
				libro.setRating(nuevoRating);
				libro.setComentario(nuevoComentario);
				break;
			}
		}

	}

	public void ejecutarBuscarLibro() {
		int isbnLibro = utilidad().pedirIntPositivo("Ingrese el isbn del libro que desea buscar: ");
		if (buscarLibroIsbn(isbnLibro) != null) {
			System.out.println(buscarLibroIsbn(isbnLibro).toString());
		}else System.out.println("El libro no existe.");
	}

	public Libro buscarLibroIsbn(int isbn) {
		for (Libro libro : libros) {
			if (libro.getIsbn() == isbn) {
				return libro;
			}
		}
		return null;
	}

	//Transformar en int del status a un string.
	public String transformarStatusLibro(int opcion){
		String status = "";
		if (opcion == 1){
			status = "Sin leer";
		} else if (opcion == 2){
			status = "Leyendo";
		} else if (opcion == 3){
			status = "Terminado";
		}
		return status;
	}

	public void mostrarTodos() {
		System.out.println("LISTA DE LIBROS");
		System.out.println("===================================");
		for (Libro libro : libros) {
			System.out.println(libro.toString());
		}
		System.out.println("FIN DEL LISTADO.");
	}

	public void ejecutarOpcionLibro(int opcion) {
		switch (opcion){
			case 1:
				ejecutarAgregarLibro();
				break;
			case 2:
				ejecutarBuscarLibro();
				break;
			case 3:
				ejecutarModificarLibro();
				break;
			case 4:
				ejecutarEliminarLibro();
				break;
			case 5:
				mostrarTodos();
				break;
			case 6:
				System.out.println("Volviendo al menú general...");
				break;
		}
	}

	public void menuLibro() {
		while (true){
			mostrarOpcionesLibros();
			int opcion = utilidad().leerOpcionLimitada("Ingrese una opcion: ",1,6);
			ejecutarOpcionLibro(opcion);
			if (opcion == 6){
				break;
			}
		}
	}

	public void mostrarOpcionesLibros() {
		System.out.println("\nMenu de Libros: ");
		System.out.println("1. Agregar Libro.");
		System.out.println("2. Buscar Libro.");
		System.out.println("3. Actualizar/modificar Libro.");
		System.out.println("4. Eliminar Libro.");
		System.out.println("5. Ver todos los Libros.");
		System.out.println("6. Volver.");
	}

	public boolean libroUnicoIsbn(int isbn) {
		for (Libro libro : libros) {
			if (libro.getIsbn() == isbn) {
				return false;
			}
		}
		return true;
	}

	//funciones que quizas implemente
	public boolean libroUnicoTitulo(String titulo) {
		for (Libro libro : libros) {
			if (libro.getTitulo().equals(titulo)) {
				return false;
			}
		}
		return true;
	}

	//funciones que quizas implemente
	public boolean isbnValido(int isbn) {
		int length = String.valueOf(isbn).length();
		if (length == 10 || length == 13) {
			return true;
		}
		return false;
	}
}