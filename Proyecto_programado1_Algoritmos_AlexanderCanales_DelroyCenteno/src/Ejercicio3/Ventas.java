package Ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;

public class Ventas implements Serializable {

	/**
	 * Generado por el IDE
	 */
	private static final long serialVersionUID = 8491615419622632841L;

	int numeroFactura;
	String nombreCliente;
	int codigoVendedor;
	String nombre;
	int cantidadProductos;

	double totalSinIVA;
	double montoIVA = 15;
	double totalConIVA;

	ArrayList<Producto> productos;

	public Ventas(int factura, String nombreCliente, int vendedor,
			String nombre, ArrayList<Producto> p) {
		
		numeroFactura = factura;
		this.nombreCliente = nombreCliente;
		codigoVendedor = vendedor;
		this.nombre = nombre;
		
		productos = new ArrayList<Producto>();
		productos.addAll(p);
		
		cantidadProductos = productos.size();
		
		calcular();
	}
	
	private void calcular(){
		
		double aux = 0;
		for (Producto p : productos)
			aux += p.precioUnitario * p.cantidadTotal;
			
		
		totalSinIVA = aux;
		double por = totalSinIVA * montoIVA/100.0;
		totalConIVA = totalSinIVA + por;
		
	}
}
