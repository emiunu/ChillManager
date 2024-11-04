package Principal;
import Utilidades.Utilidad;

import java.util.*;

public class GestorSerie {

	private ArrayList<Serie> series;

	public GestorSerie(){
		this.series = new ArrayList<>();
	}

	public Utilidad utilidad(){
		return new Utilidad();
	}

	public String transformarStatusSerie(int opcion){
		String status = "";
		if (opcion == 1){
			status = "Sin empezar";
		} else if (opcion == 2){
			status = "Viendo";
		} else if (opcion == 3){
			status = "Terminada";
		}
		return status;
	}

	//Convertir los String en cadenas sin espacios y en minúsculas para una comparación más acertada.
	public String minusSinEspacios(String cadena){
		return cadena.replace(" ","").toLowerCase();
	}

	public boolean serieUnica(String titulo) {
		for (Serie serieEnLista : this.series) {
			if (Objects.equals(minusSinEspacios(titulo), minusSinEspacios(serieEnLista.getTitulo()))) { //si se encuentra la serie.
				return false;
			}
		}
		return true;
	}

	public void ejecutarAgregarSerie() {
		String titulo = utilidad().pedirString("Ingrese el título de la serie que quiere agregar: ");
		if (serieUnica(titulo)) { //si NO se encuentra la serie.
			Serie serie = new Serie(titulo,
					utilidad().pedirIntPositivo("Ingrese las temporadas totales: "),
					utilidad().pedirIntPositivo("Ingrese los capítulos totales: "),
					utilidad().pedirIntPositivo("Ingrese la temporada actual que está viendo: "),
					utilidad().pedirIntPositivo("Ingrese el capítulo actual (de la temporada) en el que quedó: "),
					transformarStatusSerie(utilidad().leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin empezar ; 2 = Viendo ; 3 = Terminada): ",1,3)),
					utilidad().leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10),
					utilidad().pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío): "));
			agregarSerie(serie);
			System.out.println("Serie guardada correctamente.");
		} else {
			System.out.println("La serie ya se encuentra registrada.");
		}
	}

	public void agregarSerie(Serie serie) {
		series.add(serie);
	}

	public void ejecutarBuscarSerie() {
		String titulo = utilidad().pedirString("Ingrese el título de la serie que quiere buscar: ");
		if(!serieUnica(titulo)) { //si se encuentra la serie.
			System.out.println("Serie encontrada.");
			mostrarSerie(buscarSerie(titulo));
		} else {
			System.out.println("No se encontró la serie.");
		}
	}

	public Serie buscarSerie(String titulo) {
		for (Serie serieEnLista : this.series) {
			if (Objects.equals(minusSinEspacios(titulo), minusSinEspacios(serieEnLista.getTitulo()))) {
				return serieEnLista;
			}
		}
		return null;
	}

	public void ejecutarModificarSerie() {
		String titulo = utilidad().pedirString("Ingrese el título de la serie que quiere actualizar/modificar: ");
		if (!serieUnica(titulo)) { //si se encuentra la serie.
			System.out.println("Serie encontrada. A continuación se le pedirán los nuevos datos.");
			Serie nuevosDatos = new Serie(titulo,
					utilidad().pedirIntPositivo("Ingrese las temporadas totales: "),
					utilidad().pedirIntPositivo("Ingrese los capítulos totales: "),
					utilidad().pedirIntPositivo("Ingrese la temporada actual que está viendo: "),
					utilidad().pedirIntPositivo("Ingrese el capítulo actual (de la temporada) en el que quedó: "),
					transformarStatusSerie(utilidad().leerOpcionLimitada("Ingrese el estado de visualización (1 = Sin empezar ; 2 = Viendo ; 3 = Terminada): ",1,3)),
					utilidad().leerOpcionLimitada("Ingrese su rating (del 1 al 10; 1 = puntaje más bajo ; 10 = puntaje más alto): ", 1, 10),
					utilidad().pedirString("Ingrese un comentario (Escribir un espacio si quiere dejar vacío): "));
			modificarSerie(titulo,nuevosDatos);
			System.out.println("Actualización realizada correctamente.");
		} else {
			System.out.println("No se encontró la serie.");
		}
	}

	public void modificarSerie(String tituloOriginal, Serie nuevosDatos) {
		Serie serieOriginal = buscarSerie(tituloOriginal);
		serieOriginal.setTitulo(nuevosDatos.getTitulo());
		serieOriginal.setTemporadas(nuevosDatos.getTemporadas());
		serieOriginal.setCapitulos(nuevosDatos.getCapitulos());
		serieOriginal.setTemporadaActual(nuevosDatos.getTemporadaActual());
		serieOriginal.setCapituloActual(nuevosDatos.getCapituloActual());
		serieOriginal.setStatus(nuevosDatos.getStatus());
		serieOriginal.setRating(nuevosDatos.getRating());
		serieOriginal.setComentario(nuevosDatos.getComentario());
	}

	public void ejecutarEliminarSerie() {
		String titulo = utilidad().pedirString("Ingrese el título de la serie que quiere eliminar: ");
		if (!serieUnica(titulo)) { //si se encuentra la serie.
			eliminarSerie(buscarSerie(titulo));
			System.out.println("Serie eliminada correctamente.");
		} else {
			System.out.println("No se encontró la serie.");
		}
	}

	public void eliminarSerie(Serie serie) {
		series.remove(serie);
	}

	public void mostrarSerie(Serie serie) {
		System.out.println(serie.toString());
	}

	public void mostrarTodasSeries() {
		System.out.println("LISTA DE SERIES");
		System.out.println("===================================");
		for (Serie serieEnLista : this.series) {
			mostrarSerie(serieEnLista);
		}
		System.out.println("FIN DEL LISTADO.");
	}

	public void mostrarOpcionesSerie(){
		System.out.println("\nMenú de series:");
		System.out.println("1) Agregar serie.");
		System.out.println("2) Buscar serie.");
		System.out.println("3) Actualizar/modificar serie.");
		System.out.println("4) Eliminar serie.");
		System.out.println("5) Ver todas las series.");
		System.out.println("6) Volver.");
	}

	public void ejecutarOpcionSerie(int opcion) {
		if (opcion == 1) { //agregar serie.
			ejecutarAgregarSerie();
		} else if (opcion == 2) { //buscar serie.
			ejecutarBuscarSerie();
		} else if (opcion == 3) { //actualizar serie.
			ejecutarModificarSerie();
		} else if (opcion == 4) { //eliminar serie.
			ejecutarEliminarSerie();
		} else if (opcion == 5) { //ver todas las series.
			mostrarTodasSeries();
		} else if (opcion == 6) { //volver al menú.
			System.out.println("Volviendo al menú general...");
		}
	}

	public void menuSerie() {
		while (true) {
			mostrarOpcionesSerie();
			int opcion = utilidad().leerOpcionLimitada("Ingrese el número de la opción que desea seleccionar: ",1,6);
			ejecutarOpcionSerie(opcion);
			if (opcion == 6) {
				break;
			}
		}
	}

}