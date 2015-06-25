package Ejercicio2;

import java.util.ArrayList;

import javax.swing.JOptionPane;





public class hashSorteo {

	private Sorteo[] posiciones;
	private int primo = 101;
	int posicion=0;
	public hashSorteo() {
		posiciones = new Sorteo[100];
	}

	public String insertar(Sorteo sor) {

		int pos = funcionModulo(sor.numero+sor.serie);
		String re = "";

		if (posiciones[pos] == null) {
			posiciones[pos] = sor;
			sor.posicion=pos;
			re = "Sorteo agregado con exito";

		} else {
			JOptionPane.showMessageDialog(null, "El el numero y serie ya existe");
			re = "El Sorteo ya existe";
		}

		return re;
	}

	private int funcionModulo(int codi) {

		return (codi % primo);

	}



	public Sorteo buscar(int codigo) {

		Sorteo sor = null;

		int pos = funcionModulo(codigo);

		if (posiciones[pos] != null){
			sor = posiciones[pos];
		sor.posicion=pos;
		}else
			JOptionPane.showMessageDialog(null, "El numero y serie no existen");

		return sor;

	}

	public String listarSorteo() {

		String re = "Numero" + "\t" + "Serie " + "\t" + "Año" + "\t" + "Provincia"
				+ "\t" + "Posicion" + "\n";
		for (Sorteo sor : posiciones)
			if (sor != null)
				re += sor.numero + "\t" + sor.serie + "\t" + sor.anio + "\t"
						+ sor.provincia+ "\t" + sor.posicion + "\n";

		return re;
	}

	public ArrayList<Sorteo> getLlaves() {
		ArrayList<Sorteo> sor = new ArrayList<Sorteo>();
		for (Sorteo e : posiciones)
			if (e != null)
				sor.add(e);

		return sor;
	}

}
