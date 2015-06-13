package Ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class RecuperarGuardar {

	public static void guardar(ArrayList<?> lista) {

		try {

			JFileChooser chooser = new JFileChooser();
			File fichero = new File("--.dat");
			chooser.setSelectedFile(fichero);
			int seleccion = chooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {

				fichero = chooser.getSelectedFile();

				ObjectOutputStream output = new ObjectOutputStream(
						new FileOutputStream(fichero));

				for (int x = 0; x < lista.size(); x++) {
					output.writeObject(lista.get(x));
				}
				output.close();

			}

		} catch (IOException ioex) {
			ioex.printStackTrace();

		}

	}

	/**
	 * Recupera los productos de un archivo plano
	 * 
	 * @return
	 */
	public static ArrayList<Producto> recuperarProductos() {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {

			JFileChooser chooser = new JFileChooser();

			int seleccion = chooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {

				File fichero = chooser.getSelectedFile();

				ObjectInputStream input = new ObjectInputStream(
						new FileInputStream(fichero));

				Producto p = (Producto) input.readObject();
				while (p != null) {

					productos.add(p);

					try {
						p = (Producto) input.readUnshared();
					} catch (Exception ex) {
						break;
					}

				}

				input.close();

			}
		} catch (IOException ioex) {
			ioex.printStackTrace();

		} catch (ClassNotFoundException cnfex) {
			cnfex.printStackTrace();

		}

		return productos;

	}

	/**
	 * Recupera las ventas de un archivo plano
	 * 
	 * @return
	 */
	public static ArrayList<Ventas> recuperarVentas() {

		ArrayList<Ventas> ventas = new ArrayList<Ventas>();

		try {

			JFileChooser chooser = new JFileChooser();

			int seleccion = chooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				
				File fichero = chooser.getSelectedFile();
				
				ObjectInputStream input = new ObjectInputStream(
						new FileInputStream(fichero));

				Ventas v = (Ventas) input.readObject();
				while (v != null) {

					ventas.add(v);

					try {
						v = (Ventas) input.readUnshared();
					} catch (Exception ex) {
						break;
					}

				}

				input.close();

			}
		} catch (IOException ioex) {
			ioex.printStackTrace();

		} catch (ClassNotFoundException cnfex) {
			cnfex.printStackTrace();

		}

		return ventas;

	}

	public static ArrayList<Compras> recuperarCompras() {

		ArrayList<Compras> compras = new ArrayList<Compras>();

		try {

			JFileChooser chooser = new JFileChooser();

			int seleccion = chooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				
				File fichero = chooser.getSelectedFile();
				
				ObjectInputStream input = new ObjectInputStream(
						new FileInputStream(fichero));

				Compras c = (Compras) input.readObject();
				while (c != null) {

						compras.add(c);

					c = (Compras) input.readUnshared();

					try {
						c = (Compras) input.readUnshared();
					} catch (Exception ex) {
						break;
					}

				}

				input.close();

			}
		} catch (IOException ioex) {
			ioex.printStackTrace();

		} catch (ClassNotFoundException cnfex) {
			cnfex.printStackTrace();

		}

		return compras;

	}

}
