package org.iesalandalus.programacion.peonajedrez;

public class Peon {
	
	private Color color;
	private Posicion posicion;
	
	// Getters y Setters
	public Color getColor() {
		return color;
	}
	private void setColor(Color color) {
		
		if(color == null) {
			throw new IllegalArgumentException();
		}
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	

}
