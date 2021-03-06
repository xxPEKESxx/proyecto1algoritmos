package Ejercicio1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



class NodoA {

	Agencia agencia;
	NodoA izquierdo;
	NodoA derecho;

	NodoA() {
		agencia = null;
		izquierdo = null;
		derecho = null;
	}
	
	public boolean NodoHoja()
	  {
		 if(this.derecho == null && this.izquierdo == null) 
		 {
			 
			return true; 
		 }
		 else return false; 
	  }  

}

public class ArbolAgencias {

	NodoA raiz;
	NodoA actual;

	String[] provincias = { "Guanacaste", "Limon", "Alajuela", "San Jose",
			"Cartago", "Heredia", "Puntarenas" };

	ArrayList<String> recorrido = new ArrayList<String>();
	ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	ArrayList<Integer> agenciasDisponibles = new ArrayList<Integer>();
	ArrayList<Integer> agenciasIngresadas = new ArrayList<Integer>();
	int size;
	boolean encontrado = false;
	boolean eliminado = false;
	File fichero = null;

	public ArbolAgencias() {
		raiz = null;
		size = 0;
	}

	/**
	 * get size
	 * @return - size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Verifica el numero de agencia para luego asiganrle una provincia a la agencia
	 * @param codigo - Int odigo agencia
	 * @param canton - String canton
	 * @return
	 */
	public String verificarInsercion(int codigo, String canton) {

		String provincia = "";
		String re = "";

		if (codigo > 0 && codigo < 101) {
			provincia = "Guanacaste";

		} else if (codigo > 101 && codigo < 201) {
			provincia = "Limon";

		} else if (codigo > 201 && codigo < 301) {
			provincia = "Alajuela";

		} else if (codigo > 301 && codigo < 401) {
			provincia = "San Jose";

		} else if (codigo > 401 && codigo < 501) {
			provincia = "Cartago";

		} else if (codigo > 501 && codigo < 601) {
			provincia = "Heredia";

		} else if (codigo > 601 && codigo < 701) {
			provincia = "Puntarenas";

		}
		int cp = 25;
		do {
			cp = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese la cantidad de la planilla:"));
			if (cp >24 && cp < 201)
				break;
			JOptionPane.showMessageDialog(null, "EL numero minimo de Planilla debe ser de 25 y maximo 200");
		} while (true);

		NodoA nuevoNodo = new NodoA();
		Agencia nuevaAgencia = new Agencia(codigo, provincia, canton, cp);
		nuevoNodo.derecho = null;
		nuevoNodo.izquierdo = null;
		nuevoNodo.agencia = nuevaAgencia;
		re = insertar(nuevoNodo, this.raiz);

		return re;
	}

	/**
	 * Inserta un nodo. Es un metodo recursivo.
	 * Se busca un nodo a la izquierda o derecha dependiendo de la condicio
	 * @param nodo - Nodo a insertar
	 * @param padre - Nodo padre
	 * @return
	 */
	public String insertar(NodoA nodo, NodoA padre) {

		String r = "";

		if (padre == null) {
			this.raiz = nodo;
			r = "Agencia agregada con exito!";
			size++;

		} else {

			if (nodo.agencia.codigo < padre.agencia.codigo) {

				if (padre.izquierdo == null) {
					padre.izquierdo = nodo;
					r = "Agencia agregada con exito";
					size++;

				} else {
					insertar(nodo, padre.izquierdo);
				}

			} else {

				if (padre.derecho == null) {
					padre.derecho = nodo;
					r = "Agencia agregada con exito";
					size++;

				} else {
					insertar(nodo, padre.derecho);
				}

			}

		}

		return r;

	}

	// ********************************
	/**
	 * Se muestran los nodos del arbol dependiendo del orden seleccionado
	 * @param orden - String orden
	 * @return - String
	 */
	public String listarPorRecorrido(String orden) {

		String re = "";
		recorrido.clear();

		if (orden.equals("EnOrden")) {
			re += "\nEnOrden:" + "\nC.d.P : Cantidad de planilla"
					+ "\nC.d.E: Cantidad de empleados ingresados"
					+ "\nCodigo:\tProvincia:\tCanton:\tC.d.P\tC.d.E";
			listarEnOrden();

		} else if (orden.equals("PreOrden")) {
			re += "\nPreOrden:" + "\nC.d.P : Cantidad de planilla"
					+ "\nC.d.E: Cantidad de empleados ingresados"
					+ "\nCodigo:\tProvincia:\tCanton:\tC.d.P\tC.d.E";
			listarPreOrden();

		} else if (orden.equals("PostOrden")) {
			re += "\nPostOrden:" + "\nC.d.P : Cantidad de planilla"
					+ "\nC.d.E: Cantidad de empleados ingresados"
					+ "\nCodigo:\tProvincia:\tCanton:\tC.d.P\tC.d.E";
			listarPostOrden();
		}

		for (int x = 0; x < recorrido.size(); x++) {
			re += recorrido.get(x);
		}
		return re;

	}

	// ********************************

	public void listarPreOrden() {
		listarPreOrden(raiz);
	}

	/**
	 * Se lista en preorden, guardando lo encontrado en un array de string
	 * @param reco
	 */
	private void listarPreOrden(NodoA reco) {
		if (reco != null) {
			recorrido.add("\n" + reco.agencia.codigo + "\t"
					+ reco.agencia.provincia + "\t" + reco.agencia.canton
					+ "\t" + reco.agencia.cantidadPlanilla + "\t"
					+ reco.agencia.cantidadEmpleadosIngresados);
			listarPreOrden(reco.izquierdo);
			listarPreOrden(reco.derecho);
		}
	}

	// ********************************

	public void listarEnOrden() {
		listarEnOrden(raiz);
	}

	/**
	 * Se lista en En orden, guardando lo encontrado en un array de string
	 * 
	 * @param reco
	 *            - Nodo raiz
	 */
	private void listarEnOrden(NodoA reco) {
		if (reco != null) {
			listarEnOrden(reco.izquierdo);
			recorrido.add("\n" + reco.agencia.codigo + "\t"
					+ reco.agencia.provincia + "\t" + reco.agencia.canton
					+ "\t" + reco.agencia.cantidadPlanilla + "\t"
					+ reco.agencia.cantidadEmpleadosIngresados);
			listarEnOrden(reco.derecho);
		}
	}

	// ********************************

	public void listarPostOrden() {
		listarPostOrden(raiz);
	}

	/**
	 * Se lista en postorden, guardando lo encontrado en un array de string
	 * 
	 * @param reco
	 *            - Nodo raiz
	 */
	private void listarPostOrden(NodoA reco) {
		if (reco != null) {
			listarPostOrden(reco.izquierdo);
			listarPostOrden(reco.derecho);
			recorrido.add("\n" + reco.agencia.codigo + "\t"
					+ reco.agencia.provincia + "\t" + reco.agencia.canton
					+ "\t" + reco.agencia.cantidadPlanilla + "\t"
					+ reco.agencia.cantidadEmpleadosIngresados);
		}
	}

	// ********************************

	/**
	 * Busca un nodo- Es un metodo recursivo que se llama si no se encuentra el
	 * nodo Se utiliza un nodo llamada actual para hacer la referencia al nodo
	 * encontrado
	 * 
	 * @param codigo
	 *            - Int codgo de la agencia
	 * @param padre
	 *            - Nodo raiz
	 */
	private void buscar(int codigo, NodoA padre) {

		if (padre == null) {
			encontrado = false;

		} else if (codigo == padre.agencia.codigo) {

			actual = padre;
			encontrado = true;

		} else if (codigo < padre.agencia.codigo) {
			buscar(codigo, padre.izquierdo);

		} else {
			buscar(codigo, padre.derecho);

		}

	}

	/**
	 * Muestra una agencia a partir de la busqueda por medio de su codigo
	 * 
	 * @param codigo
	 *            - Int codigo de la agencia
	 * @return String
	 */
	public String mostrarAgencia(int codigo) {
		String r = "";
		buscar(codigo, raiz);

		if (size() > 0) {
			if (encontrado) {
				r = "Se ha encontrado!";
				r += "\n\nC.d.P : Cantidad de planilla"
						+ "\nC.d.E: Cantidad de empleados ingresados"
						+ "\nCodigo:\tProvincia:\tCanton:\tC.d.P\tC.d.E";
				r += "\n" + actual.agencia.codigo + "\t"
						+ actual.agencia.provincia + "\t"
						+ actual.agencia.canton + "\t"
						+ actual.agencia.cantidadPlanilla + "\t"
						+ actual.agencia.cantidadEmpleadosIngresados;
			} else {
				r = "No se ha encontrado!";
			}
		} else {
			r = "Sin agencias agregadas!";
		}

		return r;
	}

	/**
	 * Insertamos un Empleado en una agencia que se busca por su codigo
	 * 
	 * @param codigo
	 *            - Int codigo de la agencia a buscar
	 * @param e
	 *            - Empleado que se agregara
	 * @return String - Resultado que se seteara en el JTextArea
	 */
	public String insertarEmpleado(int codigo, Empleados e) {
		String r = "";
		boolean flag = false;
		encontrado = false;
		buscar(codigo, raiz);
		if (encontrado) {
			if (actual.agencia.cantidadEmpleadosIngresados <= actual.agencia.cantidadPlanilla)
				flag = actual.agencia.arbolEmpleados.insertar(e);
			else
				r = "La planila esta al maximo! No se pueden agregar mas empleados.";

		} else {
			r = "Agencia no encontrada!";
		}

		if (flag) {
			r = "Empleado agregado con exito!";
			actual.agencia.cantidadEmpleadosIngresados++;
		} else
			r = "Empleado ya ingresado!";
		return r;
	}

	/**
	 * Se busca una agencia determinada y luego en empleado
	 * 
	 * @param codigo
	 *            - Int codigo de la agencia
	 * @param identi
	 *            - Int identificacion del empleado
	 * @return - String texto que se setea en el JTextArea
	 */
	public String buscarEmpleado(int codigo, int identi) {
		String r = "";

		encontrado = false;
		buscar(codigo, raiz);

		if (encontrado) {
			r += actual.agencia.arbolEmpleados.mostrarEmpleado(identi);
		}

		return r;
	}

	// ********************************
	public void elimina( int borrar){
		NodoA padre = raiz;
		NodoA actual = raiz;
		boolean detiene = false;
		
	if(raiz.agencia.codigo == borrar && raiz.derecho==null && raiz.izquierdo==null){
			 raiz=null;
			 JOptionPane.showMessageDialog(null,"Registro Eliminado ");		 			  
			  detiene=true;		 
		   }
	
	else if(raiz.agencia.codigo == borrar && raiz.izquierdo!=null && raiz.derecho!=null){
	        	  raiz=raiz.derecho; 
	            }
   
	else if(raiz.agencia.codigo == borrar && raiz.izquierdo!=null && raiz.derecho!=null){
		        	  raiz=raiz.izquierdo; 
		            }  	   
	
	else	if( raiz.agencia.codigo == borrar && raiz.derecho!=null && raiz.derecho!=null){//xx
			   
	if( raiz.derecho.NodoHoja() && raiz.izquierdo.NodoHoja() ){
			        	   raiz.derecho.izquierdo = raiz.izquierdo;
			        	   raiz=raiz.derecho;
			        	   listarPostOrden();
	}
			           
	else {//jj
		JOptionPane.showMessageDialog(null," Antes de ciclo");   
	   		NodoA temporal=raiz.izquierdo;					
	   		NodoA BuscaExtremo=raiz.derecho;
	   		NodoA FuturaRaiz = raiz.derecho;
	
	   //	padre.derecha=actual.izquierda;
	   	while(BuscaExtremo.izquierdo!=null){ //whileb 
	   		
	   		BuscaExtremo=BuscaExtremo.izquierdo;  
			JOptionPane.showMessageDialog(null,"Buscando Extremo izquierdo de Raiz Derecho");
			} //whileb 
			
                  BuscaExtremo.izquierdo=temporal;
				   raiz=null;
				   raiz=FuturaRaiz;											
				detiene = true;	
	   }//jj	
	
      }//xx
		           
		   
	while (detiene != true){///Whilerr
		
		JOptionPane.showMessageDialog(null,"ciclo");
		   				
	 if( actual.derecho!=null&& actual.izquierdo!=null){ 
		 
		 JOptionPane.showMessageDialog(null, "Lo sentimos , El registro que Desea borrar No existe" ) ;	 
	 }
		   				
	if(borrar > actual.agencia.codigo && actual.derecho!=null){
		    padre=actual;
		    actual=actual.derecho;
		}
		    	          
	if( borrar < actual.agencia.codigo && actual.izquierdo!=null) {
		    padre=actual;
		    actual=actual.izquierdo;
		}
	
	if(borrar == actual.agencia.codigo) {
	 Borra(actual,padre);
	 JOptionPane.showMessageDialog(null,"Entro");
	 detiene=true;
	}
	}///Whilerr
		     

		
}//// borrar
	
	
	public boolean Borra(NodoA actual, NodoA padre){
		
		if (actual == padre.izquierdo){  // CUANDO VA BORRAR EL LADO IZQUIERDO
		
		if(actual.derecho==null && actual.izquierdo==null  ){//gg
		          if(padre.izquierdo == actual){
				 			padre.izquierdo=null; 
				 			actual=null;
				 
				 			return true;
				 		}
		          
		          if (padre.derecho == actual){
					 	    padre.derecho =null; 
					 	    actual=null;
					 
					 			return true;
					 	}
		}//gg
			
		if(actual.derecho==null && actual.izquierdo==null ){//hh
					  
						padre.izquierdo=actual.izquierdo;  
						actual = null;
					
						return true;
			}//hh
					 
		if(actual.izquierdo==null && actual.derecho==null){//kk
						 
						 padre.izquierdo =actual.derecho;
						 actual=null;
						 
						 return true;
			}//kk
					
			if(actual.derecho!=null && actual.izquierdo!=null){//nn
						NodoA temporal=actual.izquierdo;					
						NodoA BuscaExtremo=actual.derecho;
						
						padre.izquierdo=actual.derecho;
			 while(BuscaExtremo.izquierdo!=null){  //wwhile
				 BuscaExtremo=BuscaExtremo.izquierdo;  
			    JOptionPane.showMessageDialog(null,"Buscando Extremo Izquierdo del actual derecha");
						  } //wwhile  
						   
			 BuscaExtremo.izquierdo=temporal;
	         actual=null; 
			
	         return true;
	         
			}//nn
			
	}// CUANDO VA BORRAR EL LADO IZQUIERDO 
			
			if(actual == padre.derecho){  // CUANDO VA BORRAR EN EL LADO DERECHO
				
				if(actual.derecho==null && actual.izquierdo==null){//oo
					
					if(padre.derecho == actual){
			 			padre.derecho=null; 
			 			actual=null;
			 
			 			return true;
			 		}
					
					if (padre.izquierdo == actual){
				 			padre.izquierdo =null; 
				 			actual=null;
				 
				 			return true;
				 }						
		}//oo
				
		if(actual.derecho!=null && actual.izquierdo==null) {
					  
						padre.derecho=actual.derecho;  
						actual = null;
					
						return true;
					 }
		
		if(actual.derecho==null && actual.izquierdo!=null){
							padre.derecho=actual.izquierdo;
							actual=actual.izquierdo;
					 }
					
	   if(actual.derecho!=null && actual.izquierdo!=null){//dd
								
		        NodoA temporal=actual.derecho;					
		        NodoA BuscaExtremo=actual.izquierdo;
						
				padre.derecho=actual.izquierdo;
				
	           while(BuscaExtremo.derecho!=null){  
	        	 
	        	BuscaExtremo=BuscaExtremo.derecho;  
	           JOptionPane.showMessageDialog(null,"Buscando Extremo derecho del actual izquierda");
				}  
						BuscaExtremo.derecho=temporal;
						actual=null; 
						
						return true;
					 }//dd
				  
		}// CUANDO VA BORRAR EN EL LADO DERECHO
			return true;
		}// borra
	/**
	 * Guarda las agencia en un archivo plano .dat. Utilizando el orden
	 * PreoOrden
	 */
	public void guardar() {

		JFileChooser chooser = new JFileChooser();
		fichero = new File("Arboles.dat");
		chooser.setSelectedFile(fichero);
		int seleccion = chooser.showSaveDialog(null);

		if (seleccion == JFileChooser.APPROVE_OPTION) {

			fichero = chooser.getSelectedFile();

			try {
				agencias.clear();
				ObjectOutputStream output = new ObjectOutputStream(
						new FileOutputStream(fichero));
				recorrerPreOrden(raiz);
				System.out.println(agencias.size());
				for (int x = 0; x < agencias.size(); x++) {
					Agencia age = agencias.get(x);
					output.writeObject(age);
				}
				output.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Recupera y crea el arbol de las agencias a partir del archivo .dat
	 */
	public void recuperar() {

		JFileChooser chooser = new JFileChooser();
		fichero = chooser.getSelectedFile();

		int seleccion = chooser.showOpenDialog(null);

		if (seleccion == JFileChooser.APPROVE_OPTION) {

			fichero = chooser.getSelectedFile();
			try {

				ObjectInputStream input = new ObjectInputStream(
						new FileInputStream(fichero));
				Agencia aux = (Agencia) input.readObject();
				while (aux != null) {
					if (aux instanceof Agencia) {
						agencias.add(aux);
						agenciasIngresadas.add(aux.codigo);
						for (int x = 0; x < agenciasDisponibles.size(); x++) {
							if (agenciasDisponibles.get(x) == aux.codigo) {
								agenciasDisponibles.remove(x);
							}
						}
					}
					try {
						aux = (Agencia) input.readUnshared();
					} catch (Exception ex) {
						break;
					}
				}

				input.close();
			} catch (IOException | ClassNotFoundException e) {

				e.printStackTrace();
			}

		}

		for (int x = 0; x < agencias.size(); x++) {

			NodoA nuevo = new NodoA();
			nuevo.agencia = agencias.get(x);
			this.insertar(nuevo, raiz);

		}

	}

	/**
	 * Recorre en orden PreOrden para llenar el arraylist con las agencias para
	 * ser guardadas en ese orden en el archivo .dat
	 * 
	 * @param reco
	 *            - Nodo raiz
	 */
	private void recorrerPreOrden(NodoA reco) {
		if (reco != null) {
			agencias.add(reco.agencia);
			recorrerPreOrden(reco.izquierdo);
			recorrerPreOrden(reco.derecho);
		}
	}

	// ********************************

	/**
	 * Listadas los empleados en orden: EnOrnden
	 */
	public String buscarAgenciaYListarEmpleados(int codigo) {

		String r = "";
		buscar(codigo, raiz);
		if (encontrado) {
			r += "C.d.P: Cantidad de planilla";
			r += "\nC.d.E: Cantidad de empleados agregados";
			r += "\n\nAgencia codigo:\t" + actual.agencia.codigo;
			r += "\nProvincia:\t" + actual.agencia.provincia;
			r += "\nCanton:\t" + actual.agencia.canton;
			r += "\nC.d.P:\t" + actual.agencia.cantidadPlanilla;
			r += "\nC.d.E:\t" + actual.agencia.cantidadEmpleadosIngresados;
			r += actual.agencia.arbolEmpleados.listarEmpleados();
		} else
			r = "No encontrado";

		return r;
	}

}