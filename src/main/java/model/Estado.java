package model;

public enum Estado {
	SIN_EMPEZAR("Sin empezar"),
	EN_PROGRESO("En progreso"),
	FINALIZADO("Finalizado/a");

	private String estado;

	public String getEstado() {
		return this.estado;
	}
	private Estado(String estado) {
		this.estado = estado;
	}
}