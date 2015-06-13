package Ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;

public class Compras implements Serializable {

	/**
	 * Gnerado por el IDE
	 */
	private static final long serialVersionUID = -4916343553235328518L;

	int numeroFactura;

	String nombreProveedor;
	String cedulaJuridica;
	String nombre;

	int cantidadProductos;

	double precioUnitario;
	double montoDescuento;
	double descuento;
	double precioTotal;
	double precioTotalSinDescuento;
	double precioTotalConConDescuento;

	ArrayList<Producto> productos = new ArrayList<Producto>();

	public Compras(int factura, String proveedor, String cedula, String nombre,
			double descuento, ArrayList<Producto> productos) {
		numeroFactura = factura;
		nombreProveedor = proveedor;
		cedulaJuridica = cedula;
		this.nombre = nombre;
		this.descuento = descuento;
		this.productos.addAll(productos);
		cantidadProductos = productos.size();
		calcular();
		
	}

	private void calcular() {

		double aux = 0;
		for (Producto p : productos)
			aux += p.cantidadTotal * p.precioUnitario;

		precioTotal = aux;

		montoDescuento = precioTotal * descuento / 100.0;

		precioTotalSinDescuento = precioTotal;

		precioTotalConConDescuento = precioTotal - montoDescuento;

	}

}
