package gestisimal.negocio;

public class Articulo {
	// Atributos
	private int codigo;
	private static int auto = 1;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	// Nunca negativas
	private int numUnidades;

	Articulo(String descripcion, double precioCompra, double precioVenta, int numUnidades) throws ValorNegativoException {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setNumUnidades(numUnidades);
		setCodigo();
	}

	public Articulo(int codigo) {
		this.codigo = codigo;
	}

	// Getters y Setters
	private void setCodigo() {
		this.codigo = Articulo.auto++;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private int getNumUnidades() {
		return numUnidades;
	}

	private void setPrecioCompra(double precioCompra) throws ValorNegativoException {
		if (precioCompra < 0) {
			throw new ValorNegativoException("El precio de compra no puede ser negativo.");
		}
		this.precioCompra = precioCompra;
	}

	private void setPrecioVenta(double precioVenta) throws ValorNegativoException {
		if (precioVenta < 0) {
			throw new ValorNegativoException("El precio de venta no puede ser negativo.");
		}
		this.precioVenta = precioVenta;
	}

	private void setNumUnidades(int numUnidades) throws ValorNegativoException {
		if (numUnidades < 0) {
			throw new ValorNegativoException("Las Unidades no pueden ser negativas.");
		}
		this.numUnidades = numUnidades;

	}

	// Funciones

	void decrementaExistencias(int num) throws ValorNegativoException {
		setNumUnidades(getNumUnidades() - num);
	}

	void aumentarExistencias(int num) throws ValorNegativoException {
		setNumUnidades(getNumUnidades() + num);

	}

	public void modificarUnArticulo(String descripcion, double precioCompra, double precioVenta, int numUnidades)
			throws ValorNegativoException {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setNumUnidades(numUnidades);
	}

	// OVERRIDE
	@Override
	public String toString() {
		return "\nArticulo - Código=" + codigo + ", Descripción=" + descripcion + ", Precio de Compra=" + precioCompra
				+ "€, Precio de Venta=" + precioVenta + "€, Número de Unidades=" + numUnidades + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (this.codigo == other.codigo)
			return true;
		return false;
	}

}
