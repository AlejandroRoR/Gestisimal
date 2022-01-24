package GestisimalBeta;

import java.util.Scanner;

public class Articulo {
	// Atributos
	private int codigo;
	private static int auto = 1;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	// Nunca negativas
	private int numUnidades;

	Articulo(String descripcion, double precioCompra, double precioVenta, int numUnidades) {
		this.codigo = Articulo.auto++;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.numUnidades = numUnidades;
	}

	public Articulo(int codigo) {
		this.codigo = codigo;
	}
	
	// Getters y Setters
	
	public int getCodigo() {
		return codigo;
	}
	
	private String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private double getPrecioCompra() {
		return precioCompra;
	}

	private void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	private double getPrecioVenta() {
		return precioVenta;
	}

	private void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}
	

//	public static Articulo creaArticulo1() {
//		String descrip;
//		double precioCom;
//		double precioVen;
//		int numeroUni;
//		Scanner teclado = new Scanner(System.in);
//		System.out.println("Descripción del articulo: ");
//		descrip = teclado.nextLine();
//		System.out.println("Precio compra del articulo: ");
//		precioCom = teclado.nextDouble();
//		System.out.println("Precio venta del articulo: ");
//		precioVen = teclado.nextDouble();
//		System.out.println("Número de unidades del articulo: ");
//		numeroUni = teclado.nextInt();
//
//		Articulo a = new Articulo(descrip, precioCom, precioVen, numeroUni);
//		return a;
//	}

	

	@Override
	public String toString() {
		return "\nArticulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra
				+ ", precioVenta=" + precioVenta + ", numUnidades=" + numUnidades + "]";
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
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
