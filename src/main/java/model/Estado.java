package model;
/**
 * Enumerado que contiene los estados posibles de una actividad
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
	 * Constructor del enumerado Estado
	 * @param estado El estado de la actividad
	 */

	private Estado(String estado) {
		this.estado = estado;
	}
}