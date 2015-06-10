package Ejercicio1;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * Algoritmos - Tarea Programada 1 - Ejercicio 1
 * @author Rodolfo Sequeira B26375
 * @author Alexander Canales B11428
 * I semestre - 2014
 */
public class Florida_Bebidas_SA extends JFrame {

	/**
	 * Generado por el IDE
	 */
	private static final long serialVersionUID = 4286148739855335695L;

	private JTextArea jtxa_resultados;
	private JScrollPane jscrl_scroll;
	private JPanel jpnl_gestionEmpleados;
	private JPanel jpnl_gestionarAgencias;
	private JComboBox<Integer> jcbx_agenciasDisponibles;
	private JComboBox<String> jcbx_orden;
	private JComboBox<Integer> jcbx_agenciasAgregadasE;
	private JComboBox<Integer> jcbx_agenciasAgregadasA;
	private JPanel jpnl_agencias;

	ArrayList<Integer> agenciasDisponibles = new ArrayList<Integer>();
	ArrayList<Integer> agenciasIngresadas = new ArrayList<Integer>();

	ArbolAgencias arbolAgencias = new ArbolAgencias();
	private JTextField jtxt_canton;
	private JTextField jtxt_identificarEmpleado;
	private JButton jbtn_eliminarEmpleado;
	private JButton jbtn_agregarEmpleado;
	private JButton jbtn_bucarEmpleado;
	private JTextField jtxt_salarioEmpleado;
	private JComboBox<String> jcbx_puestos;
	private JTextField jtxt_nombreEmpleado;

	/**
	 * Constructor
	 */
	public Florida_Bebidas_SA() {
		setTitle("Estrucitmo S.A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(1017, 412);

		JTabbedPane jtpn_tabs = new JTabbedPane(JTabbedPane.TOP);
		jtpn_tabs.setBounds(10, 11, 491, 352);
		getContentPane().add(jtpn_tabs);

		jtxa_resultados = new JTextArea();
		jtxa_resultados.setEditable(false);
		jtxa_resultados.setForeground(Color.RED);
		jtxa_resultados.setBackground(Color.BLACK);
		jscrl_scroll = new JScrollPane(jtxa_resultados);
		jscrl_scroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jscrl_scroll
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscrl_scroll.setBounds(551, 11, 440, 352);
		getContentPane().add(jscrl_scroll);

		jpnl_agencias = new JPanel();
		jtpn_tabs.addTab("Agencias", null, jpnl_agencias, null);
		jpnl_agencias.setLayout(null);

		JLabel jlbl_nombreAgencia = new JLabel("Agregar Agencia");
		jlbl_nombreAgencia.setBounds(10, 14, 120, 14);
		jpnl_agencias.add(jlbl_nombreAgencia);

		jpnl_gestionarAgencias = new JPanel();
		jpnl_gestionarAgencias.setBorder(new TitledBorder(null,
				"Gestionar Agencias", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		jpnl_gestionarAgencias.setBounds(10, 69, 447, 244);
		jpnl_agencias.add(jpnl_gestionarAgencias);
		jpnl_gestionarAgencias.setLayout(null);

		JLabel jlbl_codigoAgencia = new JLabel("Codigo de agencia:");
		jlbl_codigoAgencia.setEnabled(false);
		jlbl_codigoAgencia.setBounds(10, 33, 118, 14);
		jpnl_gestionarAgencias.add(jlbl_codigoAgencia);

		JButton jbtn_eliminarAgencia = new JButton("Eliminar");
		jbtn_eliminarAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		jbtn_eliminarAgencia.setEnabled(false);
		jbtn_eliminarAgencia.setBounds(10, 58, 89, 23);
		jpnl_gestionarAgencias.add(jbtn_eliminarAgencia);

		JButton jbtn_mostrarAgencia = new JButton("Mostrar");
		jbtn_mostrarAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAgencia();
			}
		});
		jbtn_mostrarAgencia.setEnabled(false);
		jbtn_mostrarAgencia.setBounds(109, 58, 89, 23);
		jpnl_gestionarAgencias.add(jbtn_mostrarAgencia);

		JSeparator jseparador1 = new JSeparator();
		jseparador1.setBounds(10, 92, 301, 2);
		jpnl_gestionarAgencias.add(jseparador1);

		JButton jbtn_buscarAgencia = new JButton("Buscar Agencia");
		jbtn_buscarAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarAgencia();
			}
		});
		jbtn_buscarAgencia.setEnabled(false);
		jbtn_buscarAgencia.setBounds(10, 103, 135, 23);
		jpnl_gestionarAgencias.add(jbtn_buscarAgencia);

		JSeparator jseparador2 = new JSeparator();
		jseparador2.setBounds(10, 171, 301, 2);
		jpnl_gestionarAgencias.add(jseparador2);

		JLabel jlbl_listarAgencias = new JLabel("Listar Agencias:");
		jlbl_listarAgencias.setEnabled(false);
		jlbl_listarAgencias.setBounds(10, 184, 101, 14);
		jpnl_gestionarAgencias.add(jlbl_listarAgencias);

		jcbx_orden = new JComboBox<String>();
		jcbx_orden.addItem("EnOrden");
		jcbx_orden.addItem("PreOrden");
		jcbx_orden.addItem("PostOrden");
		jcbx_orden.setEnabled(false);
		jcbx_orden.setBounds(126, 181, 135, 20);
		jpnl_gestionarAgencias.add(jcbx_orden);

		JButton jbtn_listar = new JButton("Listar");
		jbtn_listar.setEnabled(false);
		jbtn_listar.setBounds(10, 209, 89, 23);
		jbtn_listar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				listarPorOrden();
			}
		});
		jpnl_gestionarAgencias.add(jbtn_listar);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(321, 11, 6, 221);
		jpnl_gestionarAgencias.add(separator);

		JButton jbtn_guardar = new JButton("Guardar");
		jbtn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarArbol();
			}
		});
		jbtn_guardar.setEnabled(false);
		jbtn_guardar.setBounds(337, 71, 100, 23);
		jpnl_gestionarAgencias.add(jbtn_guardar);

		JButton jbtn_recuperar = new JButton("Recuperar");
		jbtn_recuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperarArbol();
			}
		});
		jbtn_recuperar.setBounds(337, 117, 100, 23);
		jpnl_gestionarAgencias.add(jbtn_recuperar);

		JButton btnBuscarAgenciaY = new JButton(
				"Buscar Agencia y listar empleados");
		btnBuscarAgenciaY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAgenciaYListarEmpleados();
			}
		});
		btnBuscarAgenciaY.setEnabled(false);
		btnBuscarAgenciaY.setBounds(10, 137, 251, 23);
		jpnl_gestionarAgencias.add(btnBuscarAgenciaY);

		jcbx_agenciasAgregadasA = new JComboBox<Integer>();
		jcbx_agenciasAgregadasA.setEnabled(false);
		jcbx_agenciasAgregadasA.setBounds(138, 30, 73, 20);
		jpnl_gestionarAgencias.add(jcbx_agenciasAgregadasA);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarAgencia();
			}
		});
		btnAgregar.setBounds(10, 39, 89, 23);
		jpnl_agencias.add(btnAgregar);

		jcbx_agenciasDisponibles = new JComboBox<Integer>();
		jcbx_agenciasDisponibles.setBounds(140, 11, 120, 20);
		jpnl_agencias.add(jcbx_agenciasDisponibles);

		jtxt_canton = new JTextField();
		jtxt_canton.setBounds(270, 11, 106, 20);
		jpnl_agencias.add(jtxt_canton);
		jtxt_canton.setColumns(10);

		JLabel label = new JLabel("<< Canton");
		label.setBounds(386, 14, 90, 14);
		jpnl_agencias.add(label);

		JPanel jpnl_empleados = new JPanel();
		jtpn_tabs.addTab("Empleados", null, jpnl_empleados, null);
		jpnl_empleados.setLayout(null);

		jpnl_gestionEmpleados = new JPanel();
		jpnl_gestionEmpleados.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Gestion de Empleados",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		jpnl_gestionEmpleados.setBounds(10, 11, 220, 234);
		jpnl_empleados.add(jpnl_gestionEmpleados);
		jpnl_gestionEmpleados.setLayout(null);

		JLabel jlbl_nombreEmpleado = new JLabel("Nombre:");
		jlbl_nombreEmpleado.setEnabled(false);
		jlbl_nombreEmpleado.setBounds(10, 84, 67, 14);
		jpnl_gestionEmpleados.add(jlbl_nombreEmpleado);

		jtxt_nombreEmpleado = new JTextField();
		jtxt_nombreEmpleado.setEnabled(false);
		jtxt_nombreEmpleado.setBounds(102, 81, 100, 20);
		jpnl_gestionEmpleados.add(jtxt_nombreEmpleado);
		jtxt_nombreEmpleado.setColumns(10);

		JLabel jlbl_identificador = new JLabel("Identificador:");
		jlbl_identificador.setEnabled(false);
		jlbl_identificador.setBounds(10, 59, 82, 14);
		jpnl_gestionEmpleados.add(jlbl_identificador);

		jtxt_identificarEmpleado = new JTextField();
		jtxt_identificarEmpleado.setEnabled(false);
		jtxt_identificarEmpleado.setBounds(102, 56, 100, 20);
		jpnl_gestionEmpleados.add(jtxt_identificarEmpleado);
		jtxt_identificarEmpleado.setColumns(10);

		JLabel jlbl_puestoEmpleado = new JLabel("Puesto:");
		jlbl_puestoEmpleado.setEnabled(false);
		jlbl_puestoEmpleado.setBounds(10, 109, 67, 14);
		jpnl_gestionEmpleados.add(jlbl_puestoEmpleado);

		jcbx_puestos = new JComboBox<String>();
		jcbx_puestos.addItem("Distribuidor");
		jcbx_puestos.addItem("Vendedor");
		jcbx_puestos.addItem("Bodegero");
		jcbx_puestos.setEnabled(false);
		jcbx_puestos.setBounds(102, 106, 100, 20);
		jpnl_gestionEmpleados.add(jcbx_puestos);

		JLabel jlbl_salario = new JLabel("Salario:");
		jlbl_salario.setEnabled(false);
		jlbl_salario.setBounds(10, 134, 67, 14);
		jpnl_gestionEmpleados.add(jlbl_salario);

		jtxt_salarioEmpleado = new JTextField();
		jtxt_salarioEmpleado.setEnabled(false);
		jtxt_salarioEmpleado.setBounds(102, 131, 100, 20);
		jpnl_gestionEmpleados.add(jtxt_salarioEmpleado);
		jtxt_salarioEmpleado.setColumns(10);

		JLabel jlbl_agencia = new JLabel("Agencia:");
		jlbl_agencia.setEnabled(false);
		jlbl_agencia.setBounds(10, 29, 67, 14);
		jpnl_gestionEmpleados.add(jlbl_agencia);

		jbtn_agregarEmpleado = new JButton("Agregar");
		jbtn_agregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEmpleado();
			}
		});
		jbtn_agregarEmpleado.setEnabled(false);
		jbtn_agregarEmpleado.setBounds(10, 159, 89, 23);
		jpnl_gestionEmpleados.add(jbtn_agregarEmpleado);

		jbtn_bucarEmpleado = new JButton("Buscar");
		jbtn_bucarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEmpleado();
			}
		});
		jbtn_bucarEmpleado.setEnabled(false);
		jbtn_bucarEmpleado.setBounds(112, 159, 89, 23);
		jpnl_gestionEmpleados.add(jbtn_bucarEmpleado);

		jbtn_eliminarEmpleado = new JButton("Eliminar");
		jbtn_eliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		jbtn_eliminarEmpleado.setEnabled(false);
		jbtn_eliminarEmpleado.setBounds(10, 193, 89, 23);
		jpnl_gestionEmpleados.add(jbtn_eliminarEmpleado);

		jcbx_agenciasAgregadasE = new JComboBox<Integer>();
		jcbx_agenciasAgregadasE.setEnabled(false);
		jcbx_agenciasAgregadasE.setBounds(102, 26, 100, 20);
		jpnl_gestionEmpleados.add(jcbx_agenciasAgregadasE);

		JButton jbtn_faq = new JButton();
		jbtn_faq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faq();
			}
		});
		jbtn_faq.setIcon(new ImageIcon(getClass().getResource(
				"/recursos/faq.png")));
		jbtn_faq.setBounds(240, 11, 45, 39);
		jpnl_empleados.add(jbtn_faq);

		initCombos();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	// ********************************

	/**
	 * Agrega una agencia al arbol de agencias
	 */
	public void agregarAgencia() {
		if (!(jcbx_agenciasDisponibles.getSelectedItem().toString().isEmpty())
				&& !(jtxt_canton.getText().isEmpty())) {
			int codigo = (Integer) jcbx_agenciasDisponibles.getSelectedItem();
			String canton = jtxt_canton.getText();
			String re = arbolAgencias.verificarInsercion(codigo, canton);
			jtxa_resultados.setText(re);

			for (int x = 0; x < agenciasDisponibles.size(); x++) {
				if (agenciasDisponibles.get(x) == codigo) {
					agenciasIngresadas.add(codigo);
					agenciasDisponibles.remove(x);
					break;
				}
			}
			activarPaneles();
			actualizarCombos();
		}
	}

	/**
	 * Lista las agencias del arbol por el orden seleccionado
	 */
	public void listarPorOrden() {
		String re = "";
		re = arbolAgencias.listarPorRecorrido(jcbx_orden.getSelectedItem()
				.toString());
		jtxa_resultados.setText(re);
	}

	/**
	 * Muestra una agencia
	 */
	public void mostrarAgencia() {
		String re = "";
		re = arbolAgencias.mostrarAgencia((Integer) jcbx_agenciasAgregadasA
				.getSelectedItem());
		jtxa_resultados.setText(re);
	}

	/**
	 * Busca una agencia
	 */
	public void buscarAgencia() {
		String d = JOptionPane.showInputDialog("Ingrese el codigo de agencia");
		String re = arbolAgencias.mostrarAgencia(Integer.parseInt(d));
		jtxa_resultados.setText(re);
	}

	/**
	 * Elimina una agencia
	 */
	public void eliminar() {
		JOptionPane.showMessageDialog(this, "No fuciona este boton.");
	}

	/**
	 * Agreg un empleado
	 */
	public void agregarEmpleado() {
		String n = jtxt_nombreEmpleado.getText();
		
		int i = Integer.parseInt(jtxt_identificarEmpleado.getText());
		
		int a = (Integer) jcbx_agenciasAgregadasE.getSelectedItem();
		String p = (String) jcbx_puestos.getSelectedItem();
		String s = jtxt_salarioEmpleado.getText();
		System.out.println(s);
		Empleados e = new Empleados(i, n, p, s);
		n = arbolAgencias.insertarEmpleado(a, e);
		jtxa_resultados.setText(n);
	}

	/**
	 * Busca un empleado
	 */
	public void buscarEmpleado() {
		if (!(jtxt_identificarEmpleado.getText().isEmpty())) {
			int a = (Integer) jcbx_agenciasAgregadasA.getSelectedItem();
			int i = Integer.parseInt(jtxt_identificarEmpleado.getText());
			String r = arbolAgencias.buscarEmpleado(a, i);
			jtxa_resultados.setText(r);
		} else {
			String d = JOptionPane
					.showInputDialog("Ingrese el identificador del empleado");
			int a = (Integer) jcbx_agenciasAgregadasA.getSelectedItem();
			String r = arbolAgencias.buscarEmpleado(a, Integer.parseInt(d));
			jtxa_resultados.setText(r);
		}

	}
	
	/**
	 * Guarda el arbol
	 */
	public void guardarArbol() {
		arbolAgencias.guardar();
	}

	/**
	 * Recupera el arbol
	 */
	public void recuperarArbol() {
		if (arbolAgencias != null) {
			arbolAgencias = null;
			arbolAgencias = new ArbolAgencias();
			agenciasIngresadas.clear();
			arbolAgencias.agenciasDisponibles = agenciasDisponibles;
			arbolAgencias.agenciasIngresadas = agenciasIngresadas;
			arbolAgencias.recuperar();
			agenciasDisponibles = arbolAgencias.agenciasDisponibles;
			agenciasIngresadas = arbolAgencias.agenciasIngresadas;
			actualizarCombos();
			activarPaneles();
		}
	}

	/**
	 * Busca una agencia y lista en EnOrden todos sus empleados
	 */
	public void buscarAgenciaYListarEmpleados() {
		String d = JOptionPane
				.showInputDialog("Ingrese el codigo de la agencia");
		String g = arbolAgencias.buscarAgenciaYListarEmpleados(Integer.parseInt(d));
		jtxa_resultados.setText(g);
	}

	// ********************************

	/**
	 * Muestra una pequeña ayuda 
	 */
	public void faq() {
		String re = "\t~ F.A.Q ~" + "\nPrimero se debe de crear una agencia."
				+ "\npara crearla debe ir a la tabs Agencias."
				+ "\nLas agencias se agregan simplemente escogiendo"
				+ "\nsu codigo."
				+ "\nLuego de agregar la agencia el codigo desaparece del"
				+ "\ncombo y se puede seleccionar para realizar las gestiones."
				+ "\n\nLuego se pueden gestionar las agencias."
				+ "\n* Se pueden elegir por medio de su codigo, no"
				+ "\nse pueden eliminar del arbol. Tambien se pueden"
				+ "\nmostrar, nada mas desplega su codigo y cantidad de "
				+ "\nempleados."
				+ "\n* La opcion de buscar agencia hace lo mismo que"
				+ "\n'Mostrar', solo que en este caso nos da la opcion de"
				+ "\nbuscar ingresando el codigo en una cuadro de texto."
				+ "\n* La opcion 'Buscar Agencia y Listar Clientes' muestra"
				+ "\nlos datos de la agencia y lista todos los clientes que "
				+ "\ntiene en orde 'EnOrden'."
				+ "\nLa opcion de 'Listar Agencias' nos permite elegir en"
				+ "\nque orden se dese listar la lista."
				+ "\n* Para gestionar los empleados se debe ir a la tab"
				+ "\n'Empleados'."
				+ "\n* Para agregar un empleado se deben de llenar todos los"
				+ "\ncampos."
				+ "\n* Para 'Buscar' un empleado basta tan solo elegir la"
				+ "\nagencia e ingresar su identificar."
				+ "\n* La opcion de 'Eliminar' tampoco funciona para este arbol."
				+ "\nSe deben tambien elegir la agencia e ingresar su identificador personal."
				+ "\n\nAlgoritmos - Tarea programada 1 - Ejercicio 2."
				+ "\nRodolfo Sequeira B26375"
				+ "\nAlexander Canales B11428";
		jtxa_resultados.setText(re);
	}

	// ********************************

	/**
	 * Activa o desactiva los paneles 
	 */
	public void activarPaneles() {
		if (arbolAgencias.size() > 0) {
			Component[] c = jpnl_gestionEmpleados.getComponents();
			for (Component com : c)
				com.setEnabled(true);

			Component[] co = jpnl_gestionarAgencias.getComponents();
			for (Component com : co)
				com.setEnabled(true);
		} else {
			Component[] c = jpnl_gestionEmpleados.getComponents();
			for (Component com : c)
				com.setEnabled(false);

			Component[] co = jpnl_gestionarAgencias.getComponents();
			for (Component com : co)
				com.setEnabled(false);
		}
	}

	/**
	 * Actualiza los JComboBox de las agencias disponibles y las agregadas
	 */
	public void actualizarCombos() {
		jcbx_agenciasDisponibles.removeAllItems();
		for (int x = 0; x < agenciasDisponibles.size(); x++) {
			jcbx_agenciasDisponibles.addItem(agenciasDisponibles.get(x));
		}
		jcbx_agenciasAgregadasE.removeAllItems();
		jcbx_agenciasAgregadasA.removeAllItems();
		for (int x = 0; x < agenciasIngresadas.size(); x++) {
			jcbx_agenciasAgregadasE.addItem(agenciasIngresadas.get(x));
			jcbx_agenciasAgregadasA.addItem(agenciasIngresadas.get(x));
		}
	}

	void initCombos() {
		for (int x = 10; x <= 700; x += 10) {
			agenciasDisponibles.add(x);
		}
		actualizarCombos();
	}

	// ********************************

	public static void main(String[] agh) {
		new Florida_Bebidas_SA();
	}
}
