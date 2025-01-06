package model;
/**
 * Enum que contiene los estados posibles de una actividad
 * Los cuales son "Sin empezar", "En progreso" y "Finalizado/a"
 */

public enum Estado {
	SIN_EMPEZAR("Sin empezar"),
	EN_PROGRESO("En progreso"),
	FINALIZADO("Finalizado/a");

	private String estado;

	/**
	 * Método que entrega el estado de la actividad
	 * @return El estado de la actividad
	 */

	public String getEstado() {
		return this.estado;
	}

	/**
	 * Constructor del enum Estado
	 * @param estado El estado de la actividad
	 */

	private Estado(String estado) {
		this.estado = estado;
	}
}