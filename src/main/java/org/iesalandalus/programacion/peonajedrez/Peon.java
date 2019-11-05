package org.iesalandalus.programacion.peonajedrez;

public class Peon {
	
	Color color;
	Posicion posicion;
	
	//Constructor por defecto
	public Peon() {
		
		this.posicion = new Posicion(7,'d');
		this.color = Color.NEGRO;
	}
	
	// Getters y Setters
	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		
		if(color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	private void setPosicion(Posicion posicion) {
		
		if(posicion == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar una columna nula.");
		}
		this.posicion = posicion;
	}
	
	

}
