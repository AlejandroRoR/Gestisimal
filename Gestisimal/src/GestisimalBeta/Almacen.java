package GestisimalBeta;

import java.util.ArrayList;

public class Almacen {

	private static ArrayList<Articulo> almacen = new ArrayList<Articulo>();
		
	/**
	 * Añadir un articulo al almacen.
	 * 
	 * @param
	 * @return 
	 * @return
	 */
	public static boolean buscarAlmacen(int codigo) {
		boolean flag = false;
		for (int i = 0; i < almacen.size(); i++) {
			if (almacen.get(i).getCodigo()==codigo) {
                flag = true;
            }
		}
		return flag;
	}
	
	public static boolean eliminarArticulo(int codigo) {
		return almacen.remove(new Articulo(codigo));
	}

	public static void listarAlmacen() {
		System.out.println(almacen);
	}
	
	public static void listarArticulo(int num) {
		almacen.get(num);
	}

//	public static void listarAlmacen1() {
//		for (int i = 0; i < almacen.size(); i++) {
//			System.out.println(almacen.get(i));
//		}
//	}

	public static void incrementarExistencias(int codigo, int numUnidades) {
		Articulo a=almacen.get(codigo-1);
		a.setNumUnidades(a.getNumUnidades()+numUnidades);
	}

	public static void decrementarExistencias(int codigo, int numUnidades) {
		Articulo a=almacen.get(codigo-1);
		a.setNumUnidades(a.getNumUnidades()-numUnidades);
		if (a.getNumUnidades() < 0) {
			a.setNumUnidades(0);
		}
	}

	public static void añadirArticulo(String descripcion, double precioCompra, double precioVenta, int numUnidades) {

		almacen.add(new Articulo(descripcion, precioCompra, precioVenta, numUnidades));

	}

}
