package model;

import java.util.ArrayList;

/**
 * Clase Gestor que se encarga de manejar las actividades
 */

public class Gestor {
	private ArrayList<Actividad> actividades;

	/**
	 * Constructor de la clase Gestor
	 */
	public Gestor() {
		this.actividades = new ArrayList<Actividad>();
	}

	/**
	 * Método que actualiza el ArrayList de Actividades del gestor
	 * @param actividades El nuevo ArrayList de actividades
	 */

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	/**
	 * Método que agrega una actividad al ArrayList de actividades
	 * @param actividad La actividad a agregar
	 */

	public void agregarActividad(Actividad actividad) {
		this.actividades.add(actividad);
	}

	/**
	 * Método que entrega el ArrayList de actividades
	 * @return El ArrayList de actividades
	 */

	public ArrayList<Actividad> getActividades() {
		return this.actividades;
	}

	/**
	 * Método que elimina una actividad del ArrayList de actividades
	 * @param actividad La actividad a eliminar
	 */

	public void eliminarActividad(Actividad actividad) {
		this.actividades.remove(actividad);
	}

}