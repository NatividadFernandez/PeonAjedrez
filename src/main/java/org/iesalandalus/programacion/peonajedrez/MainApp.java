package org.iesalandalus.programacion.peonajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Peon peon;

	public static void main(String[] args) {

		elegirOpcion();
		System.out.println(elegirOpcion());
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

}
