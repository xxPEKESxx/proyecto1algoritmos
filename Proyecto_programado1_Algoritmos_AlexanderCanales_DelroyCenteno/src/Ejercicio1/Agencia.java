package Ejercicio1;

import java.io.Serializable;


public class Agencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531278632925870312L;
	
	// Instancia del arbol de empleados que pertenece a la agencia
	ArbolEmpleados arbolEmpleados = new ArbolEmpleados();
	
	int codigo;
	
	String provincia;
	int cantidadPlanilla;
	int cantidadEmpleadosIngresados = 0;
	
	public Agencia(int codigo, String provincia, String canton, int cantidadEmpleados){
		
		this.provincia = provincia;
		this.codigo = codigo;
		this.cantidadPlanilla = cantidadEmpleados;
	}
	
	
}
