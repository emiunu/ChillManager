package model;
/**
 * Enum que contiene los estados posibles de una actividad
 * Los cuales son "Sin empezar", "En progreso" y "Finalizado/a"
 */

public enum Estado {
	/**
	 * Estado que indica que no se ha empezado a jugar/leer/ver la actividad.
	 */
	SIN_EMPEZAR("Sin empezar"),

	/**
	 * Estado que indica que se está en proceso de jugar/leer/ver la actividad.
	 */
	EN_PROGRESO("En progreso"),

	/**
	 * Estado que indica que se ha finalizado de jugar/leer/ver la actividad.
	 */
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