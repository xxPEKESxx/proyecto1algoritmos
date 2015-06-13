package Ejercicio3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Seleccion {

	private static int intercambios = 0;
	private static int comparaciones = 0;

	public static ArrayList<Ventas> seleccion(ArrayList<Ventas> ventas) {

		intercambios = 0;
		comparaciones = 0;

		for (int x = 0; x < ventas.size(); x++) {

			int minimo = x;

			for (int y = x + 1; y < ventas.size(); y++) {

				if (ventas.get(y).numeroFactura < ventas.get(minimo).numeroFactura) {
					intercambios++;
					minimo = y;
				}

			}

			Ventas aux2 = ventas.get(x);
			ventas.set(x, ventas.get(minimo));
			ventas.set(minimo, aux2);
			comparaciones++;
		}

		JOptionPane.showMessageDialog(null, "Intercambios: " + intercambios
				+ "\nComparaciones: " + comparaciones, "SELECCION", JOptionPane.INFORMATION_MESSAGE);

		return ventas;

	}

}
