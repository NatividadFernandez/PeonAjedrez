package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Peon {

	private Color color;
	private Posicion posicion;

	// Constructor por defecto
	public Peon() {

		this.posicion = new Posicion(7, 'd');
		this.color = Color.NEGRO;
	}

	// Constructor con un parámetro
	public Peon(Color color) {
		setColor(color);

		if (color.equals(Color.BLANCO)) {
			this.posicion = new Posicion(2, 'd');
		} else if (color.equals(Color.NEGRO)) {
			this.posicion = new Posicion(7, 'd');
		}
		this.color = color;
	}

	// Constructor con dos parámetros
	public Peon(Color color, char columna) {

		setColor(color);

		if (color.equals(Color.BLANCO)) {
			this.posicion = new Posicion(2, columna);
		} else if (color.equals(Color.NEGRO)) {
			this.posicion = new Posicion(7, columna);
		}
		this.color = color;
	}

	// Getters y Setters
	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {

		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;

	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {

		if (posicion == null) {
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}
		this.posicion = posicion;
	}

	// Método mover usando la dirección
	public void mover(Direccion direccion) throws OperationNotSupportedException {

		if (direccion == null) {
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}

		switch (direccion) {

		case IZQUIERDA:
			try {
				if (color.equals(Color.BLANCO)) {
					posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1));
				} else if (color.equals(Color.NEGRO)) {
					posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1));
				}

			} catch (IllegalArgumentException iae) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		case DERECHA:
			try {

				if (color.equals(Color.BLANCO)) {
					posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1));
				} else if (color.equals(Color.NEGRO)) {
					posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1));
				}

			} catch (IllegalArgumentException iae) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		}

	}

	// Método mover sobrecargado
	public void mover(int num) throws OperationNotSupportedException {

		try {
			switch (num) {
			
			case 2:
				if (color.equals(Color.BLANCO)) {
					if (posicion.getFila() == 2) {
						posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna()));
					} else {
						throw new OperationNotSupportedException(
								"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
					}
				} else if (color.equals(Color.NEGRO)) {
					if (posicion.getFila() == 7) {
						posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna()));
					} else {
						throw new OperationNotSupportedException(
								"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
					}
				}
				break;
			case 1:

				if (color.equals(Color.BLANCO)) {
					posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna()));

				} else if (color.equals(Color.NEGRO)) {
					posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna()));

				}
				break;
			default:
				throw new OperationNotSupportedException("ERROR: El peón sólo se puede mover 1 o 2 pasos.");
			}
		} catch (IllegalArgumentException iae) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		}
	}

	// Métodos hasCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Peon)) {
			return false;
		}
		Peon other = (Peon) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	//Método toString
	@Override
	public String toString() {
		return posicion + ", color=" + color;
	}
	
	
	
	
}
