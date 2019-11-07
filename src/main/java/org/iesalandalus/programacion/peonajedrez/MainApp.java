package org.iesalandalus.programacion.peonajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Peon peon;

	public static void main(String[] args) {

		elegirColor();
		mostrarPeon();
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

		Color color= null;
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
			}
		} while (opcion < 1 || opcion > 2);

		return color;
	}

}
