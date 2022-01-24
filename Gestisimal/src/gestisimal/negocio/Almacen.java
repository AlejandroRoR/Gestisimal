package gestisimal.negocio;

import java.util.ArrayList;

public class Almacen {

	private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
	
	/**
	 * Buscar si algun codigo esta en almacen.
	 * 
	 * @param codigo codigo pasado por el usuario
	 * @return almacen.contains
	 */
	public boolean buscarAlmacen(int codigo) {
		return almacen.contains(new Articulo(codigo));
	}
	
	/**
	 * Crea y añade un articulo al almacen.
	 * 
	 * @param descripcion descripcion del articulo pasado por usuario.
	 * @param precioCompra precio de compra del articulo pasado por usuario.
	 * @param precioVenta precio de venta del articulo pasado por usuario.
	 * @param numUnidades número de unidades del articulo pasado por usuario.
	 * @throws ValorNegativoException 
	 */
	public void annadirArticulo(String descripcion, double precioCompra, double precioVenta, int numUnidades) throws ValorNegativoException {
			almacen.add(new Articulo(descripcion, precioCompra, precioVenta, numUnidades));
	}
	
	/**
	 * Elimina un articulo del almacen.
	 * 
	 * @param codigo código del articulo pasado por usuario.
	 */
	public boolean eliminarArticulo(int codigo) {
		return almacen.remove(new Articulo(codigo));
	}
	
	/**
	 * Modifica el articulo
	 * 
	 * @param codigo
	 * @return 
	 * @throws ValorNegativoException 
	 * @throws CodigoNoExisteException 
	 */
	public void modificarUnArticulo(int codigo, String descripcion, double precioCompra, double precioVenta, int numUnidades) throws ValorNegativoException, CodigoNoExisteException {
		get(codigo).modificarUnArticulo(descripcion, precioCompra, precioVenta, numUnidades);
		
	}
	
	@Override
	public String toString() {
		return "Almacen [almacen=" + almacen + "]";
	}

	/**
	 * Incrementa el número de unidades del almacen.
	 * 
	 * @param codigo Código pasado por el usuario
	 * @param numUnidades Número de unidades pasadas por el usuario
	 * @throws ValorNegativoException 
	 * @throws CodigoNoExisteException 
	 */
	public void incrementarExistencias(int codigo, int numUnidades) throws ValorNegativoException, CodigoNoExisteException {
		get(codigo).aumentarExistencias(numUnidades);
	}

	/**
	 * Decrementa el número de unidades del almacen.
	 * 
	 * @param codigo Código pasado por el usuario
	 * @param numUnidades Número de unidades pasadas por el usuario
	 * @throws ValorNegativoException 
	 * @throws CodigoNoExisteException 
	 */
	public void decrementarExistencias(int codigo, int numUnidades) throws ValorNegativoException, CodigoNoExisteException {
		get(codigo).decrementaExistencias(numUnidades);
	}

	/**
	 * Devuelve el articulo del codigo pasado
	 * 
	 * @param codigo
	 * @return 
	 * @throws CodigoNoExisteException 
	 */
	private Articulo get(int codigo) throws CodigoNoExisteException {
		try {
			return almacen.get(almacen.indexOf(new Articulo(codigo)));
		} catch (IndexOutOfBoundsException e) {
			throw new CodigoNoExisteException("No existe en el almacen un articulo con ese código");
		} 
	}

}
