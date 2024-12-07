package model;

import java.util.ArrayList;
import java.util.Vector;

import data.GestorDatos;
import model.Actividad;

public class Gestor {
	private ArrayList<Actividad> actividades;

	public Gestor() {
		this.actividades = new ArrayList<Actividad>();
	}

	public void agregarActividad(Actividad actividad) {
		this.actividades.add(actividad);
	}

	public void eliminarActividad(Actividad actividad) {
		this.actividades.remove(actividad);
	}

	public ArrayList<Actividad> getActividades() {
		return this.actividades;
	}

}