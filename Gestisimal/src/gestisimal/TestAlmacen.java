package gestisimal;

import gestisimal.negocio.Almacen;
import gestisimal.negocio.CodigoNoExisteException;
import gestisimal.negocio.ValorNegativoException;
import gestisimal.utils.Menu;
import gestisimal.utils.Teclado;

/**
 * GESTISIMAL
 * 
 * Autor: Alejandro Rodr�guez Romero
 * 
 * Fecha: 26/02/2020
 */

public class TestAlmacen {
	private static Almacen almacen = new Almacen();

	public static void main(String[] args) {
		String[] opciones = { "Listar Articulos", "A�adir Articulo", "Eliminar Articulo", "Modificar un Articulo",
				"Entrada Existencias", "Salida Existencias", "Salir", "Pruebas" };

		Menu menu = new Menu("GESTISIMAL", opciones);

		do {

			switch (menu.gestionarMenu()) {
			case 1:
				listarAlmacen();
				break;

			case 2:
				annadirArticulo();
				break;

			case 3:
				eliminarArticulo();
				break;

			case 4:
				modificarUnArticulo();
				break;

			case 5:
				incrementarUnidades();
				break;

			case 6:
				decrementarUnidades();
				break;

			case 7:
				System.out.println("Saliendo....");
				return;
				
			case 8:
				pruebasArticulo();
				break;

			default:
				System.out.println("Te has equivocado los datos introducidos no concuerdan. \n");
				break;

			}
		} while (true);
	}

	/**
	 * Opci�n 1 del men�. Que muestra el almacen por pantalla.
	 */
	private static void listarAlmacen() {
		System.out.println(almacen);

	}

	/**
	 * Opci�n 2 del men�. Que crea un articulo y lo a�ade al almacen.
	 * 
	 * @exception ValorNegativoException
	 */
	private static void annadirArticulo() {
		try {
			almacen.annadirArticulo(Teclado.leerCadena("Descripci�n del articulo: "),
					Teclado.leerDecimal("Precio compra del articulo: "), 
					Teclado.leerDecimal("Precio venta del articulo: "),
					Teclado.leerEntero("N�mero de unidades del articulo: "));
		} catch (ValorNegativoException e) {
			System.err.println("Error al a�adir el articulo. " + e.getMessage());
		}
	}

	/**
	 * Opci�n 3 del men�. Que elimina el articulo seleccionado.
	 */
	private static void eliminarArticulo() {
		if (!almacen.eliminarArticulo(Teclado.leerEntero("Dame el codigo del articulo que quieres borrar: "))) {
			System.out.println("Error al eliminar el articulo.");
		}

	}

	/**
	 * Opci�n 4 del men�. Que modifica el articulo seleccionado.
	 * 
	 * @exception CodigoNoExisteException
	 * @exception ValorNegativoException
	 */
	private static void modificarUnArticulo() {
		try {
			listarAlmacen();
			almacen.modificarUnArticulo(Teclado.leerEntero("Dame el codigo del articulo: "),
					Teclado.leerCadena("Descripci�n del articulo: "), 
					Teclado.leerDecimal("Precio compra del articulo: "),
					Teclado.leerDecimal("Precio venta del articulo: "), 
					Teclado.leerEntero("N�mero de unidades del articulo: "));
		} catch (ValorNegativoException | CodigoNoExisteException e) {
			System.err.println("Error al modificar el articulo. " + e.getMessage());
		}
	}

	/**
	 * Opci�n 5 del men�. Que aumenta el numero de unidades del art�culo.
	 * 
	 * @exception CodigoNoExisteException
	 * @exception ValorNegativoException
	 */
	private static void incrementarUnidades() {
		try {
			almacen.incrementarExistencias(Teclado.leerEntero("Dame el codigo del articulo: "),
					Teclado.leerEntero("Introduce las existencias que entran: "));
		} catch (ValorNegativoException | CodigoNoExisteException e) {
			System.err.println("Error al incrementar unidades. " + e.getMessage());
		}

	}

	/**
	 * Opci�n 6 del men�. Que decrementa el numero de unidades del art�culo.
	 * 
	 * @exception CodigoNoExisteException
	 * @exception ValorNegativoException
	 */
	private static void decrementarUnidades() {
		try {
			almacen.decrementarExistencias(Teclado.leerEntero("Dame el codigo del articulo: "),
					Teclado.leerEntero("Introduce las existencias en salida: "));
		} catch (ValorNegativoException | CodigoNoExisteException e) {
			System.err.println("Error al decrementar unidades. " + e.getMessage());
		}

	}

	/**
	 * Opci�n 8 del men�. A�ade automaticamente 3 articulos para probar el almacen.
	 * Pruebas de articulos.
	 * 
	 * @exception ValorNegativoException
	 */
	private static void pruebasArticulo() {
		try {
			almacen.annadirArticulo("aa", 12, 13, 4);
			almacen.annadirArticulo("bb", 22, 23, 5);
			almacen.annadirArticulo("cc", 32, 33, 6);
		} catch (ValorNegativoException e) {
			System.err.println("Error al a�adir el articulo. " + e.getMessage());
		}

		System.out.println("Prueba completada.");
	}

}
