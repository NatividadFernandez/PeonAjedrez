package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Peon peon;

	public static void main(String[] args) {
		boolean opcion = true;
		do {

			mostrarMenu();
			ejecutarOpcion(elegirOpcion());

		} while (opcion == true);
	}

	public static void mostrarPeon() {
		try {

			System.out.println(peon.toString());
		} catch (NullPointerException n) {

		}

	}

	public static void mostrarMenu() {

		System.out.println(" ");
		System.out.println("** MENÚ PRINCIPAL **" + "\n1.- Crear peón por defecto." + "\n2.- Crear peón de un color."
				+ "\n3.- Crear peón de un color y en una columna inicial " + "\n4.- Mover el peón" + "\n5.- Salir");
	}

	public static int elegirOpcion() {
		int opcion = 0;
		do {
			System.out.println(" ");
			System.out.println("Elige una de las opciones del menú");
			opcion = Entrada.entero();

		} while (opcion < 1 || opcion > 5);

		return opcion;
	}

	public static Color elegirColor() {

		int opcion = 0;
		Color color = null;

		do {
			System.out.println("Menú colores peón");
			System.out.println("1.-Blanco" + "\n2.-Negro");
			System.out.println(" ");
			System.out.println("Elige uno de los colores:");
			opcion = Entrada.entero();

			switch (opcion) {

			case 1:
				color = Color.BLANCO;
				break;
			case 2:
				color = Color.NEGRO;
				break;

			default:
				System.out.println("Opción no válida");
				System.out.println(" ");
				break;
			}
		} while (opcion < 1 || opcion > 2);

		return color;
	}

	public static char elegirColumnaInicial() {

		int opcion = 0;
		char columna = ' ';

		do {
			System.out.println("Menú columnas iniciales");
			System.out.println(
					"1.- A" + "\n2.- B" + "\n3.- C" + "\n4.- D" + "\n5.- E" + "\n6.- F" + "\n7.- G" + "\n8.- H");
			System.out.println(" ");
			System.out.println("Elige una columna para iniciar:");
			opcion = Entrada.entero();

			switch (opcion) {

			case 1:
				columna = 'a';
				break;
			case 2:
				columna = 'b';
				break;
			case 3:
				columna = 'c';
				break;
			case 4:
				columna = 'd';
				break;
			case 5:
				columna = 'e';
				break;
			case 6:
				columna = 'f';
				break;
			case 7:
				columna = 'g';
				break;
			case 8:
				columna = 'h';
				break;

			default:
				System.out.println("Opción no válida");
				System.out.println(" ");
				break;
			}

		} while (opcion < 1 || opcion > 8);

		return columna;
	}

	public static void mostrarMenuMovimientos() {

		System.out.println("Menú movimientos");
		System.out.println("1.- Avanzar peón un paso." + "\n2.- Avanzar peón dos pasos."
				+ "\n3.- Avanzar peón hacia la izquierda." + "\n4.- Avanzar peón hacia la derecha.");
	}

	public static int elegirMovimiento() {

		int opcion = 0;
		do {
			System.out.println(" ");
			System.out.println("Elige una de las opciones del menú");
			opcion = Entrada.entero();

		} while (opcion < 1 || opcion > 4);

		return opcion;
	}

	public static void realizarMovimiento(int opcion) throws OperationNotSupportedException {

		Direccion direccion = null;

		switch (opcion) {

		case 1:
			peon.mover(1);
			break;
		case 2:
			try {
				peon.mover(2);
			} catch (OperationNotSupportedException o) {
				System.out.println(
						"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
			}
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			peon.mover(direccion);
			break;
		case 4:
			direccion = Direccion.DERECHA;
			peon.mover(direccion);
			break;
		default:
			System.out.println("Opción no válida");
			System.out.println(" ");
			break;

		}

	}

	public static void crearPeonDefecto() {
		peon = new Peon();
	}

	public static void crearPeonColor() {
		peon = new Peon(elegirColor());
	}

	public static void crearPeonColorColumna() {
		peon = new Peon(elegirColor(), elegirColumnaInicial());
	}

	public static void mover() {

		if (peon == null) {

			System.out.println("Debes crear antes un peón.");
		} else {

			mostrarMenuMovimientos();
			try {
				realizarMovimiento(elegirMovimiento());
			} catch (OperationNotSupportedException e) {
				System.out.println("Imposible mover el peón porque te sales del tablero");
			}
		}

	}

	public static void ejecutarOpcion(int opcion) {

		switch (opcion) {

		case 1:
			System.out.println("** Crear peón por defecto **");
			crearPeonDefecto();
			mostrarPeon();
			break;
		case 2:
			System.out.println("** Crear peón de un color **");
			crearPeonColor();
			mostrarPeon();
			break;
		case 3:
			System.out.println("** Crear peón de un color y en una columna inicial **");
			crearPeonColorColumna();
			mostrarPeon();
			break;
		case 4:
			System.out.println("** Mover el peón **");
			mover();
			mostrarPeon();
			break;
		case 5:
			System.out.println("** Salir **");
			System.out.println("¡¡¡¡ADIOS!!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Opción no válida");
			System.out.println(" ");
			break;
		}

	}
}
