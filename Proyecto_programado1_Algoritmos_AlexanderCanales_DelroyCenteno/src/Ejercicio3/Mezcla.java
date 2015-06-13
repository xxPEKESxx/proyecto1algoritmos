package Ejercicio3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mezcla {

	private static int[] facturas;
	private static int[] aux;
	private static int intercambios = 0;
	private static int comparaciones = 0;

	public static ArrayList<Object> ordenar(ArrayList<Compras> compras,
			ArrayList<Ventas> ventas) {

		intercambios = 0;
		comparaciones = 0;

		ArrayList<Object> comprasVentas = new ArrayList<Object>();
		comprasVentas.addAll(compras);
		comprasVentas.addAll(ventas);

		facturas = getFacturas(comprasVentas);
		aux = new int[facturas.length];
		mezclar(0, facturas.length - 1);
		comprasVentas = ordenarProductos(comprasVentas, facturas);

		JOptionPane.showMessageDialog(null, "Intercambios: " + intercambios
				+ "\nComparaciones: " + comparaciones, "MEZCLA", JOptionPane.INFORMATION_MESSAGE);

		return comprasVentas;

	}

	public static int[] getFacturas(ArrayList<Object> compras) {

		int[] facturas = new int[compras.size()];
		Compras c = null;
		Ventas v = null;
		for (int x = 0; x < compras.size(); x++)
			if (compras.get(x) instanceof Compras) {
				c = (Compras) compras.get(x);
				facturas[x] = c.numeroFactura;

			} else if (compras.get(x) instanceof Ventas) {
				v = (Ventas) compras.get(x);
				facturas[x] = v.numeroFactura;

			}

		return facturas;

	}

	private static ArrayList<Object> ordenarProductos(ArrayList<Object> lista,
			int[] facturas) {

		int pos = 0;
		ArrayList<Object> ordenadas = new ArrayList<Object>();
		Compras c = null;
		Ventas v = null;

		for (int x = 0; x < lista.size(); x++) {
			for (int y = 0; y < lista.size(); y++) {
				if (lista.get(y) instanceof Compras) {
					c = (Compras) lista.get(y);
					if (c.numeroFactura == facturas[pos]) {
						ordenadas.add(lista.get(y));
						break;
					}
				} else if (lista.get(y) instanceof Ventas) {
					v = (Ventas) lista.get(y);
					if (v.numeroFactura == facturas[pos]) {
						ordenadas.add(lista.get(y));
						break;
					}

				}
			}
			pos++;
		}

		return ordenadas;

	}

	private static void mezclar(int menor, int mayor) {

		if (menor < mayor) {

			int medio = menor + (mayor - menor) / 2;

			mezclar(menor, medio);

			mezclar(medio + 1, mayor);

			mezclar(menor, medio, mayor);

		}

	}

	private static void mezclar(int menor, int medio, int mayor) {

		for (int x = menor; x <= mayor; x++)
			aux[x] = facturas[x];

		int i = menor;
		int j = medio + 1;
		int k = menor;

		while (i <= medio && j <= mayor) {
			comparaciones++;
			if (aux[i] <= aux[j]) {
				intercambios++;
				facturas[k] = aux[i];
				i++;
			} else {
				intercambios++;
				facturas[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= medio) {
			intercambios++;
			facturas[k] = aux[i];
			k++;
			i++;
		}

	}
}
