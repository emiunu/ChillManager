package model;

import java.util.ArrayList;

public class Gestor {
	private ArrayList<Actividad> actividades;

	public Gestor() {
		this.actividades = new ArrayList<Actividad>();
	}

	public void agregarActividad(Actividad actividad) {
		this.actividades.add(actividad);
	}

	public ArrayList<Actividad> getActividades() {
		return this.actividades;
	}

	public void eliminarActividad(Actividad actividad) {
		this.actividades.remove(actividad);
	}

}