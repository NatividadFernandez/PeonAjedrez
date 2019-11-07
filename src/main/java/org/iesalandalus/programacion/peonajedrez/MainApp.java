package org.iesalandalus.programacion.peonajedrez;

public class MainApp {

	static Peon peon;

	public static void main(String[] args) {

	}

	public static void mostrarPeon() {

		System.out.println(peon);
	}

	public static void mostrarMenu() {

		System.out.println("1.- Crear peón por defecto." 
				+ "\n2.- Crear peón de un color."
				+ "\n3.- Crear peón de un color y en una columna inicial "
				+ "\n4.- Mover el peón"
				+ "\n5.- Salir");
	}

}
