package Ejercicio3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuickSort {

	private static int comparaciones;
	private static int intercambios;

	public static ArrayList<Producto> quicksort(ArrayList<Producto> p) {
		comparaciones = 0;
		intercambios = 0;
		ArrayList<Producto> pr = quicksort(p, 0, p.size() - 1);
		JOptionPane.showMessageDialog(null, "Comparaciones: " + comparaciones
				+ "\nIntercambios: " + intercambios, "QUICK SORT", JOptionPane.INFORMATION_MESSAGE);
		return pr;
	}

	public static ArrayList<Producto> quicksort(ArrayList<Producto> pro,
			int izq, int der) {

		if (izq >= der)
			return pro;

		int i = izq;
		int d = der;

		if (izq != der) {

			int pivote;
			Producto aux;

			pivote = izq;

			while (izq != der) {

				while (pro.get(der).cantidadTotal >= pro.get(pivote).cantidadTotal
						&& izq < der) {
					der--;
					comparaciones++;
				}
				while (pro.get(izq).cantidadTotal < pro.get(pivote).cantidadTotal
						&& izq < der) {
					izq++;
					comparaciones++;
				}
				if (der != izq) {

					aux = pro.get(der);
					pro.set(der, pro.get(izq));
					pro.set(izq, aux);
					intercambios++;

				}

				if (izq == der) {

					quicksort(pro, i, izq - 1);
					quicksort(pro, izq + 1, d);

				}

			}

		} else
			return pro;

		return pro;

	}

}
