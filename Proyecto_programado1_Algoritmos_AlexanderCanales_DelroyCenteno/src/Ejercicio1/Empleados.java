package Ejercicio1;

import java.io.Serializable;

public class Empleados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8704154167297698422L;
	int identificador;
	String nombre;
	String puesto;
	String salario;

	public Empleados(int identificador, String nombre, String puesto,
			String salario) {

		this.identificador = identificador;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;

	}

}
