package Utilidades;

import java.util.Scanner;

public class Utilidad {

	/**
	 * 
	 * @param mensaje
	 */
	public String pedirString(String mensaje) {
		System.out.print(mensaje);
		String string;
		while (true){
			string = scanner().nextLine();
			if (string.isEmpty()){
				System.out.print("Por favor ingrese una entrada no vacía: ");
			}else{break;}
		}
		return string;
	}

	/**
	 * 
	 * @param mensaje
	 */
	public int pedirInt(String mensaje) {
		int value;
		while (true) {
			try {
				System.out.print(mensaje);
				value = scanner().nextInt();
				break;
			} catch(Exception InputMismatchException){
				System.out.print("Entrada no válida. Ingrese un número. "); // excepcion en caso de no ser numero
			}
		}
		return value;
	}

	/**
	 * 
	 * @param mensaje
	 * @param min
	 * @param max
	 */
	public int leerOpcionLimitada(String mensaje, int min, int max) {
		System.out.print(mensaje);
		int opcion;
		while (true) {
			try {
				opcion = scanner().nextInt();
				if ((opcion >= min) && (opcion <= max)) {
					break;
				} else {
					System.out.print("Opción sale del rango. Inténtelo nuevamente: ");
				}
			} catch(Exception InputMismatchException){
				System.out.print("Entrada no válida. Ingrese un número: ");
			}
		}
		return opcion;
	}

	public Scanner scanner() {
		return new Scanner(System.in);
	}

	/**
	 * 
	 * @param mensaje
	 */
	public int pedirIntPositivo(String mensaje) {
		while (true) {
			int numero = pedirInt(mensaje);
			if (numero < 0) {
				System.out.println("Ingrese un número positivo.");
			} else {
				return numero;
			}
		}
	}

}