package Ejercicio3;

import javax.swing.JOptionPane;

public class ListaVentas {

	private Nodo primero;
	private Nodo actual;
	private int size;
	
	public ListaVentas(){
		primero = actual = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	/**
	 * Inserta una venta en la lista
	 * @param venta
	 */
	public void insertar(Ventas venta){
		
		Nodo nuevo = new Nodo();
		nuevo.venta = venta;
	
		if (!verificarExistencia(venta.numeroFactura)){
			
			if (getSize() > 0){
				actual = primero;
				while(actual.siguiente != null){
					actual = actual.siguiente;
				}
				actual.siguiente = nuevo;
				size++;
				
			} else {
				primero = nuevo;
				size++;
				
			}
			
			JOptionPane.showMessageDialog(null, "Venta agregada con exito");
			
		} else
			JOptionPane.showMessageDialog(null, "Ya existe una venta con ese numero de factura");
		
	}
	
	
	
	/**
	 * Verifica si existe una venta con el mismo numero de factura
	 * @param numeroFactura
	 * @return
	 */
	private boolean verificarExistencia(int numeroFactura){
		boolean flag = false;
		
		actual = primero;
		while(actual != null){
			if (actual.venta.numeroFactura == numeroFactura)
				flag = true;
			
			actual = actual.siguiente;
		}
		
		return flag;
	}
	
	
	/**
	 * Clase interna de Nodo
	 * @author Rodolfo
	 *
	 */
	private class Nodo {
		Nodo siguiente;
		Ventas venta;

		public Nodo() {
			siguiente = null;
		}
	}

}
