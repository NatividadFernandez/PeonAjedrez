package org.iesalandalus.programacion.peonajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Peon peon;

	public static void main(String[] args) {

		elegirColumnaInicial();
	}

	public static void mostrarPeon() {

		System.out.println(peon);

	}

	public static void mostrarMenu() {

		System.out.println("1.- Crear peón por defecto." + "\n2.- Crear peón de un color."
				+ "\n3.- Crear peón de un color y en una columna inicial " + "\n4.- Mover el peón" + "\n5.- Salir");
	}

	public static int elegirOpcion() {
		int opcion = 0;
		do {
			mostrarMenu();
			System.out.println(" ");
			System.out.println("Elige una de las opciones del menú");
			opcion = Entrada.entero();

		} while (opcion > 1 || opcion < 5);

		return opcion;
	}

	public static Color elegirColor() {

		Color color = null;
		int opcion = 0;

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
}
