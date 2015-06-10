package Ejercicio1;

import java.io.Serializable;
import java.util.ArrayList;

class NodoE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 873573506408389976L;
	Empleados empleado;
	NodoE izquierdo;
	NodoE derecho;

	NodoE() {
		empleado = null;
		izquierdo = null;
		derecho = null;
	}

}

public class ArbolEmpleados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2053385624080756039L;
	private NodoE actual;
	private NodoE raiz;
	ArrayList<Empleados> empleados = new ArrayList<Empleados>();
	boolean encontrado = false;
	int size;
	
	public ArbolEmpleados() {
		actual = null;
		raiz = null;
		size = 0;
	}

	
	/**
	 * Se inserta un empleado al arbol
	 * @param e - Empleado
	 * @return - String
	 */
	public boolean insertar(Empleados e) {
		boolean r = false;
		NodoE nuevoNodo = new NodoE();
		nuevoNodo.empleado = e;
		r = insertar(nuevoNodo, raiz);
		return r;
	}

	/**
	 * Inserta un nodo en el arbol
	 * @param nodo - Nodo a insertar
	 * @param padre - Nodo raiz
	 * @return
	 */
	private boolean insertar(NodoE nodo, NodoE padre) {
		boolean r = false;

		if (padre == null) {
			this.raiz = nodo;
			r = true;
			size++;

		} else {

			if (!(nodo.empleado.identificador == padre.empleado.identificador)) {

				if (nodo.empleado.identificador < padre.empleado.identificador) {

					if (padre.izquierdo == null) {
						padre.izquierdo = nodo;
						r = true;
					} else {
						insertar(nodo, padre.izquierdo);
					}

				} else {

					if (padre.derecho == null) {
						padre.derecho = nodo;
						r = true;
						size++;
					} else {
						insertar(nodo, padre.derecho);
					}

				}

			} else {
				r = false;
			}

		}

		return r;

	}

	/**
	 * Se busca un nodn por medio de la identificacion
	 * @param identi - Int identificacion de cliente
	 * @param raiz - Nodo raiz
	 */
	private void buscar(int identi, NodoE raiz) {

		if (raiz == null) {
			encontrado = false;

		} else if (identi == raiz.empleado.identificador) {

			actual = raiz;
			encontrado = true;

		} else if (identi < raiz.empleado.identificador) {
			buscar(identi, raiz.izquierdo);

		} else {
			buscar(identi, raiz.derecho);

		}

	}

	/***
	 * Muestra un empleado por su identificacion
	 * @param identi - Int indentificacion
	 * @return - String
	 */
	public String mostrarEmpleado(int identi) {
		String r = "";

		buscar(identi, raiz);
		if (encontrado) {
			r = "Nombre\tI.D\tPuesto\tSalario";
			r += "\n" + actual.empleado.nombre + "\t"
					+ actual.empleado.identificador + "\t"
					+ actual.empleado.puesto + "\t" + actual.empleado.salario;
		} else {
			r = "No encontrado";
		}

		return r;
	}

	// **************************

	/**
	 * Lista los empleados
	 * @return
	 */
	public String listarEmpleados() {
		String r = "";
		empleados.clear();
		if (raiz != null) {

			recorrerEnOrden(raiz);
			r += "\nEmpleados:\n\nNombre\tI.D\tPuesto\tSalario";
			for (int x = 0; x < empleados.size(); x++) {
				r += "\n" + empleados.get(x).nombre + "\t"
						+ empleados.get(x).identificador + "\t"
						+ empleados.get(x).puesto + "\t"
						+ empleados.get(x).salario;
			}

		} else {
			r = "Agencia sin empleados";
		}
		return r;
	}

	/**
	 * Recorre en EnOrden los empleados
	 * @param reco
	 */
	private void recorrerEnOrden(NodoE reco) {
		if (reco != null) {
			recorrerEnOrden(reco.izquierdo);
			empleados.add(reco.empleado);
			recorrerEnOrden(reco.derecho);
		}
	}

}
