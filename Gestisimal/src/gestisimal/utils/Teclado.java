package gestisimal.utils;

import java.util.Scanner;

public class Teclado {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Lee una cadena por teclado
	 * 
	 * @return
	 */
	private static String leerCadena() {
		return scanner.nextLine();
	}

	/**
	 * Muestra por pantalla el mensaje pasado por parametro
	 * 
	 * @param msj mensaje a mostrar pasado
	 * @return
	 */
	public static String leerCadena(String msj) {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena por teclado
	 * 
	 * @return
	 */
	private static char leerCaracter() {
		char caracter = 0;
		try {
			caracter = leerCadena().charAt(0);
		} catch (StringIndexOutOfBoundsException excep) {
			System.out.println("Has introducido mal los parámetros.");
		}
		return caracter;
	}

	/**
	 * Muestra por pantalla el mensaje pasado por parametro
	 * 
	 * @param msj mensaje a mostrar pasado
	 * @return
	 */
	public static char leerCaracter(String msj) {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee un numero entero por teclado.
	 * 
	 * @return
	 */
	private static int leerEntero() {
		int num = 0;
		try {
			num = Integer.parseInt(leerCadena());
		} catch (NumberFormatException excep) {
			System.out.println("Has introducido mal los parámetros.");
		}
		return num;

	}

	/**
	 * Muestra por pantalla el mensaje pasado por parametro.
	 * 
	 * @param msj mensaje a mostrar pasado
	 * @return
	 */
	public static int leerEntero(String msj) {
		System.out.print(msj);
		return leerEntero();

	}

	/**
	 * Lee un numero decimal por teclado.
	 * 
	 * @return
	 */
	private static double leerDecimal() {
		double num = 0;
		try {
			num = Double.parseDouble(leerCadena());
		} catch (NumberFormatException excep) {
			System.out.println("Has introducido mal los parámetros.");
		}
		return num;
	}

	/**
	 * Muestra por pantalla el mensaje pasado por parametro
	 * 
	 * @param msj mensaje a mostrar pasado
	 * @return
	 */
	public static double leerDecimal(String msj) {
		System.out.println(msj);
		return leerDecimal();
	}

}