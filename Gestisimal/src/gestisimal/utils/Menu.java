package gestisimal.utils;

public class Menu {
	private String titulo;
	private String[] opciones;

	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
	}

	public int gestionarMenu() {
		mostrar(titulo, opciones);
		return elegirOpcion(opciones);
	}

	private void mostrar(String titulo, String[] op) {
		System.out.println();
		System.out.println("          " + titulo + "           ");
		System.out.println("-------------------------------");
		for (int i = 0; i < op.length; i++) {
			System.out.println(i + 1 + ". " + op[i]);
		}

	}

	private static int elegirOpcion(String[] op) {
		int opMenu;
		do {
			System.out.println();
			opMenu = Teclado.leerEntero("Introduce la opcion del menú: ");
		} while ((opMenu < 1) || (opMenu > op.length));
		return opMenu;
	}

}
