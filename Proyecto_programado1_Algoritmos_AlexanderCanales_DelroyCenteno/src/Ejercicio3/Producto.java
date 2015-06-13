package Ejercicio3;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * Generado por el IDE
	 */
	private static final long serialVersionUID = -5025952294244950098L;
	int codigo;
	String nombre;
	double precioUnitario;
	int cantidadTotal;

	public Producto(){	
	}
	
	public Producto(int codigo, String nombre, double precio, int cantidad){
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precio;
		this.cantidadTotal = cantidad;
		
	}
	
}
