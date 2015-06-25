package Ejercicio2;

import java.util.ArrayList;






public class Info {
	hashSorteo sorteo = new hashSorteo();
	
	public String creaSorteo(int numero, int serie, String anio,
			String provincia, int posicion) {

		String resul = "";

		resul = sorteo.insertar(new Sorteo(numero, serie, anio, provincia, posicion));

		return resul;
	}
	
	public String listarSorteos() {
		String resul = sorteo.listarSorteo();
		return resul;
	}
	
	public Sorteo verSorteo(int codigo) {

		Sorteo ex = sorteo.buscar(codigo);
		return ex;
	}

}
