package Ejercicio3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class InsercionDirecta {

	private static int comparaciones;
	private static int intercambios;

	public static ArrayList<Compras> insercionDirecta(ArrayList<Compras> c) {

		comparaciones = 0;
		intercambios = 0;

		int n = c.size();

		for (int x = 1; x < n; x++) {

			Compras co = c.get(x);
			int j = x - 1;

			while (j >= 0 && c.get(j).precioTotalSinDescuento > co.precioTotalSinDescuento) {

				c.set(j + 1, c.get(j));
				j--;
				intercambios++;
				comparaciones++;
			}

			c.set(j + 1, co);
			intercambios++;

		}

		JOptionPane.showMessageDialog(null, "Comparaciones: " + comparaciones
				+ "\nIntercambios: " + intercambios, "INSERCION DIRECTA", JOptionPane.INFORMATION_MESSAGE);
		return c;

	}

}
