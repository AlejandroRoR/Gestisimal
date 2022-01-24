package GestisimalBeta;

import java.util.Scanner;

public class TestAlmacen {
	public static void main (String[] args) {
		int opcion;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("  Bienvenido al Almacen  ");
		System.out.println("-------------------------");
		
		//MENU
		do {
			System.out.println();
			System.out.println("          Men�           ");
			System.out.println("-------------------------");
			System.out.println("1. Listar Articulos");
			System.out.println("2. A�adir Articulo");
			System.out.println("3. Eliminar Articulo");
			System.out.println("4. Entrada Existencias");
			System.out.println("5. Salida Existencias");
			System.out.println("6. Listar un Articulo");
			System.out.println("7. Salir");
			System.out.println("18. Pruebas");
			System.out.println();
			System.out.println("Introduce el numero del men�: ");
			opcion = teclado.nextInt();
			
			switch (opcion) {
			case 1:
				Almacen.listarAlmacen();
				break;
			case 2:
				annadirArticulo();
				
				break;
			case 3:
				Almacen.listarAlmacen();
				System.out.println("C�digo del articulo: ");
				int codigo = teclado.nextInt();
				
				if (!Almacen.eliminarArticulo(codigo)) {
					System.err.println("C�digo incorrecto. El �rticulo no se ha podido eliminar. ");
				}
				break;
			case 4:
				incrementarUnidades(teclado);
				
				break;
			case 5:
				decrementarUnidades(teclado);
				
				break;
			case 6:
				System.out.println("Introduce el c�digo del articulo: ");
				int num = teclado.nextInt();
				Almacen.listarArticulo(num);
				break;
			case 7:
				System.out.println("Saliendo....");
				break;
			case 18:
				System.out.println(Almacen.buscarAlmacen(53));
				
				pruebasArticulo();
				
				break;
			
			default:
				System.out.println("Te has equivocado los datos introducidos no concuerdan.");
				System.out.println();
				break;
			}
		} while (opcion!=7);
	}

	public static void decrementarUnidades(Scanner teclado) {
		Almacen.listarAlmacen();
		int num;
		
		System.out.println("C�digo del articulo: ");
		int codigo = teclado.nextInt();
		while (!Almacen.buscarAlmacen(codigo)) {
			System.err.println("C�digo incorrecto. El �rticulo no existe. ");
			System.out.println("C�digo del articulo: ");
			codigo = teclado.nextInt();
		}
		do {
			System.out.println("Introduce la cantidad en positivo: ");
			num = teclado.nextInt();
		} while (num < 0);
		Almacen.decrementarExistencias(codigo, num);
	}

	public static void incrementarUnidades(Scanner teclado) {
		Almacen.listarAlmacen();
		int num;
		
		System.out.println("C�digo del articulo: ");
		int codigo = teclado.nextInt();
		while(!Almacen.buscarAlmacen(codigo)){
			System.err.println("C�digo incorrecto. El �rticulo no existe. ");
			System.out.println("C�digo del articulo: ");
			codigo = teclado.nextInt();
		}
		do {
			System.out.println("Introduce la cantidad en positivo: ");
			num = teclado.nextInt();
		} while (num < 0);
		Almacen.incrementarExistencias(codigo, num);
	}

	public static void annadirArticulo() {
		//Almacen.a�adirArticulo(Articulo.creaArticulo());
		
		String descripcion;
		double precioCompra;
		double precioVenta;
		int numeroUnidades;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Descripci�n del articulo: ");
		descripcion = teclado.nextLine();
		System.out.println("Precio compra del articulo: ");
		precioCompra = teclado.nextDouble();
		System.out.println("Precio venta del articulo: ");
		precioVenta = teclado.nextDouble();
		System.out.println("N�mero de unidades del articulo: ");
		numeroUnidades = teclado.nextInt();
		
		Almacen.a�adirArticulo(descripcion, precioCompra, precioVenta, numeroUnidades);
		
	}
	//PRUEBAS
	public static void pruebasArticulo() {
		Almacen.a�adirArticulo("aa", 12, 13, 4);
		Almacen.a�adirArticulo("bb", 22, 23, 5);
		Almacen.a�adirArticulo("cc", 32, 33, 6);
		
	}
	
}
