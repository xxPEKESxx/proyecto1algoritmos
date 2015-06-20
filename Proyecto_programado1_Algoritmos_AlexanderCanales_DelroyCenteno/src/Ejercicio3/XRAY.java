package Ejercicio3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class XRAY extends JFrame {

	/**
	 * Generado por el IDE
	 */
	private static final long serialVersionUID = 9021423108884559329L;
	private JTextField jtxt_codigoProducto;
	private JTextField jtxt_nombreProducto;
	private JTextField jtxt_precioUnidad;
	private JTextField jtxt_cantidadProducto;
	private JTextField jtxt_cantidadProductosAVenta;
	private JTextField jtxt_numeroFacturaVenta;
	private JTextField jtxt_nombreCliente;
	private JTextField jtxt_codigoVendedor;
	private JTextField jtxt_nombreVenta;

	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private ArrayList<Producto> listaProductosAVenta = new ArrayList<Producto>();
	private ArrayList<Producto> listaProductosACompra = new ArrayList<Producto>();
	private ArrayList<Ventas> listaVentas = new ArrayList<Ventas>();
	private ArrayList<Compras> listaCompras = new ArrayList<Compras>();
	private boolean comprasOrdenadas = false;
	private boolean ventasOrdenadas = false;

	private JComboBox<Integer> jcbx_productos;
	private JTextArea jtxa_resultadoProductos;
	private JComboBox<Integer> jcbx_ventasAgregadas;
	private JTextArea jtxa_resultadoVentas;
	private JTextField jtxt_cedula;
	private JTextField jtxt_nombreCompra;
	private JTextField jtxt_numeroFacturaCompra;
	private JTextField jtxt_nombreProveedor;
	private JComboBox<Integer> jcbx_comprasAgregadas;
	private JTextArea jtxa_resultadoCompras;
	private JPanel jpnl_agregarVentas;
	private JTextField jtxt_descuentoCompra;
	private JComboBox<String> jcb_tipo;

	public XRAY() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(657, 428);

		JTabbedPane jtbs_tabs = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(jtbs_tabs, BorderLayout.CENTER);

		JPanel jpnl_productos = new JPanel();
		jtbs_tabs.addTab("Productos", null, jpnl_productos, null);
		jpnl_productos.setLayout(null);

		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(10, 11, 75, 14);
		jpnl_productos.add(lblProductos);

		jcbx_productos = new JComboBox<Integer>();
		jcbx_productos.setBounds(95, 8, 118, 20);
		jpnl_productos.add(jcbx_productos);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 250, 4);
		jpnl_productos.add(separator);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Agregar Producto",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 49, 203, 164);
		jpnl_productos.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 24, 75, 14);
		panel.add(lblCodigo);

		jtxt_codigoProducto = new JTextField();
		jtxt_codigoProducto.setBounds(95, 21, 86, 20);
		panel.add(jtxt_codigoProducto);
		jtxt_codigoProducto.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 49, 75, 14);
		panel.add(lblNombre);

		jtxt_nombreProducto = new JTextField();
		jtxt_nombreProducto.setBounds(95, 46, 86, 20);
		panel.add(jtxt_nombreProducto);
		jtxt_nombreProducto.setColumns(10);

		JLabel lblPrecioUnitario = new JLabel("Precio Uni:");
		lblPrecioUnitario.setBounds(10, 74, 75, 14);
		panel.add(lblPrecioUnitario);

		jtxt_precioUnidad = new JTextField();
		jtxt_precioUnidad.setBounds(95, 71, 86, 20);
		panel.add(jtxt_precioUnidad);
		jtxt_precioUnidad.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 99, 75, 14);
		panel.add(lblCantidad);

		jtxt_cantidadProducto = new JTextField();
		jtxt_cantidadProducto.setBounds(95, 96, 86, 20);
		panel.add(jtxt_cantidadProducto);
		jtxt_cantidadProducto.setColumns(10);

		JButton jbtn_agregarProducto = new JButton("Agregar");
		jbtn_agregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarProducto();
			}
		});
		jbtn_agregarProducto.setBounds(10, 124, 91, 23);
		panel.add(jbtn_agregarProducto);

		JPanel jpnl_opcionesProductos = new JPanel();
		jpnl_opcionesProductos.setBorder(new TitledBorder(null, "Opciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpnl_opcionesProductos.setBounds(10, 218, 230, 106);
		jpnl_productos.add(jpnl_opcionesProductos);
		jpnl_opcionesProductos.setLayout(null);

		JButton btnNewButton = new JButton("Ordenar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ordenarProductos();
			}
		});
		btnNewButton.setBounds(10, 23, 89, 23);
		jpnl_opcionesProductos.add(btnNewButton);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirProductos();
			}
		});
		btnMostrar.setBounds(104, 23, 89, 23);
		jpnl_opcionesProductos.add(btnMostrar);

		JButton jbtn_guardarProductos = new JButton("Guardar");
		jbtn_guardarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarProductos();
			}
		});
		jbtn_guardarProductos.setBounds(10, 57, 89, 23);
		jpnl_opcionesProductos.add(jbtn_guardarProductos);

		JButton jbtn_recuperarProductos = new JButton("Recuperar");
		jbtn_recuperarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperarProductos();
			}
		});
		jbtn_recuperarProductos.setBounds(104, 57, 116, 23);
		jpnl_opcionesProductos.add(jbtn_recuperarProductos);

		JScrollPane jscrl_resultadoProductos = new JScrollPane();
		jscrl_resultadoProductos
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoProductos
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoProductos.setBounds(287, 36, 349, 267);
		jpnl_productos.add(jscrl_resultadoProductos);

		jtxa_resultadoProductos = new JTextArea();
		jscrl_resultadoProductos.setViewportView(jtxa_resultadoProductos);

		JPanel jpnl_ventas = new JPanel();
		jtbs_tabs.addTab("Ventas", null, jpnl_ventas, null);
		jpnl_ventas.setLayout(null);

		JLabel lblVentasRealizadas = new JLabel("Ventas Realizadas");
		lblVentasRealizadas.setBounds(10, 11, 118, 14);
		jpnl_ventas.add(lblVentasRealizadas);

		jcbx_ventasAgregadas = new JComboBox<Integer>();
		jcbx_ventasAgregadas.setBounds(138, 8, 118, 20);
		jpnl_ventas.add(jcbx_ventasAgregadas);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 36, 274, 2);
		jpnl_ventas.add(separator_1);

		jpnl_agregarVentas = new JPanel();
		jpnl_agregarVentas.setBorder(new TitledBorder(null, "Agregar Venta",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpnl_agregarVentas.setBounds(10, 48, 274, 186);
		jpnl_ventas.add(jpnl_agregarVentas);
		jpnl_agregarVentas.setLayout(null);

		JLabel lblNFactura = new JLabel("N factura:");
		lblNFactura.setBounds(10, 26, 75, 14);
		jpnl_agregarVentas.add(lblNFactura);

		JLabel lblNewLabel = new JLabel("Nombre Cliente:");
		lblNewLabel.setBounds(10, 51, 108, 14);
		jpnl_agregarVentas.add(lblNewLabel);

		JLabel lblCodigoVendedor = new JLabel("Codigo vendedor:");
		lblCodigoVendedor.setBounds(10, 76, 108, 14);
		jpnl_agregarVentas.add(lblCodigoVendedor);

		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 101, 75, 14);
		jpnl_agregarVentas.add(lblNombre_1);

		JLabel lblNewLabel_1 = new JLabel("Cantidad productos:");
		lblNewLabel_1.setBounds(10, 126, 126, 14);
		jpnl_agregarVentas.add(lblNewLabel_1);

		JButton jbtn_agregarVenta = new JButton("Agregar");
		jbtn_agregarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVenta();
			}
		});
		jbtn_agregarVenta.setBounds(10, 151, 108, 20);
		jpnl_agregarVentas.add(jbtn_agregarVenta);

		jtxt_numeroFacturaVenta = new JTextField();
		jtxt_numeroFacturaVenta.setBounds(146, 23, 86, 20);
		jpnl_agregarVentas.add(jtxt_numeroFacturaVenta);
		jtxt_numeroFacturaVenta.setColumns(10);

		jtxt_nombreCliente = new JTextField();
		jtxt_nombreCliente.setBounds(146, 48, 86, 20);
		jpnl_agregarVentas.add(jtxt_nombreCliente);
		jtxt_nombreCliente.setColumns(10);

		jtxt_codigoVendedor = new JTextField();
		jtxt_codigoVendedor.setBounds(146, 73, 86, 20);
		jpnl_agregarVentas.add(jtxt_codigoVendedor);
		jtxt_codigoVendedor.setColumns(10);

		jtxt_nombreVenta = new JTextField();
		jtxt_nombreVenta.setBounds(146, 98, 86, 20);
		jpnl_agregarVentas.add(jtxt_nombreVenta);
		jtxt_nombreVenta.setColumns(10);

		JButton jbtn_agregarProductoAVenta = new JButton();
		jbtn_agregarProductoAVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProductoAVenta();
			}
		});
		jbtn_agregarProductoAVenta.setBounds(196, 123, 36, 32);
		jpnl_agregarVentas.add(jbtn_agregarProductoAVenta);
		jbtn_agregarProductoAVenta.setIcon(new ImageIcon(XRAY.class.getResource("/recursos/agregar.png")));

		jtxt_cantidadProductosAVenta = new JTextField("0");
		jtxt_cantidadProductosAVenta.setBounds(146, 123, 40, 20);
		jpnl_agregarVentas.add(jtxt_cantidadProductosAVenta);
		jtxt_cantidadProductosAVenta.setEditable(false);
		jtxt_cantidadProductosAVenta.setColumns(10);

		JPanel jpnl_opcionesVentas = new JPanel();
		jpnl_opcionesVentas.setBorder(new TitledBorder(null, "Opciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpnl_opcionesVentas.setBounds(10, 245, 274, 92);
		jpnl_ventas.add(jpnl_opcionesVentas);
		jpnl_opcionesVentas.setLayout(null);

		JButton jbtn_ordenarVentas = new JButton("Ordenar");
		jbtn_ordenarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarVentas();
			}
		});
		jbtn_ordenarVentas.setBounds(10, 24, 89, 23);
		jpnl_opcionesVentas.add(jbtn_ordenarVentas);

		JButton jbtn_mostrarVentas = new JButton("Mostrar");
		jbtn_mostrarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirVentas();
			}
		});
		jbtn_mostrarVentas.setBounds(128, 24, 89, 23);
		jpnl_opcionesVentas.add(jbtn_mostrarVentas);

		JButton jbtn_guadarVentas = new JButton("Guardar");
		jbtn_guadarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarVentas();
			}
		});
		jbtn_guadarVentas.setBounds(10, 58, 89, 23);
		jpnl_opcionesVentas.add(jbtn_guadarVentas);

		JButton jbtn_recuperarVentas = new JButton("Recuperar");
		jbtn_recuperarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperarVentas();
			}
		});
		jbtn_recuperarVentas.setBounds(128, 58, 122, 23);
		jpnl_opcionesVentas.add(jbtn_recuperarVentas);

		JScrollPane jscrl_resultadoVentas = new JScrollPane();
		jscrl_resultadoVentas
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoVentas
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoVentas.setBounds(310, 36, 326, 253);
		jpnl_ventas.add(jscrl_resultadoVentas);

		jtxa_resultadoVentas = new JTextArea();
		jscrl_resultadoVentas.setViewportView(jtxa_resultadoVentas);

		JPanel jpnl_compras = new JPanel();
		jtbs_tabs.addTab("Compras", null, jpnl_compras, null);
		jpnl_compras.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Agregar Compra",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 52, 268, 219);
		jpnl_compras.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("N Factura");
		lblNewLabel_2.setBounds(10, 22, 93, 14);
		panel_2.add(lblNewLabel_2);

		JLabel lblNombreProovedor = new JLabel("Nombre Proovedor");
		lblNombreProovedor.setBounds(10, 43, 118, 14);
		panel_2.add(lblNombreProovedor);

		JLabel lblNewLabel_3 = new JLabel("Cedula");
		lblNewLabel_3.setBounds(10, 68, 93, 14);
		panel_2.add(lblNewLabel_3);

		jtxt_numeroFacturaCompra = new JTextField();
		jtxt_numeroFacturaCompra.setBounds(138, 19, 86, 20);
		panel_2.add(jtxt_numeroFacturaCompra);
		jtxt_numeroFacturaCompra.setColumns(10);

		jtxt_nombreProveedor = new JTextField();
		jtxt_nombreProveedor.setBounds(138, 40, 86, 20);
		panel_2.add(jtxt_nombreProveedor);
		jtxt_nombreProveedor.setColumns(10);

		jtxt_cedula = new JTextField();
		jtxt_cedula.setBounds(138, 65, 86, 20);
		panel_2.add(jtxt_cedula);
		jtxt_cedula.setColumns(10);

		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setBounds(10, 93, 93, 14);
		panel_2.add(lblNombre_2);

		jtxt_nombreCompra = new JTextField();
		jtxt_nombreCompra.setBounds(138, 90, 86, 20);
		panel_2.add(jtxt_nombreCompra);
		jtxt_nombreCompra.setColumns(10);

		JButton jbtn_agregarCompra = new JButton("Agregar");
		jbtn_agregarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCompra();
			}
		});
		jbtn_agregarCompra.setBounds(10, 185, 89, 23);
		panel_2.add(jbtn_agregarCompra);

		JLabel lblProductos_1 = new JLabel("Productos");
		lblProductos_1.setBounds(10, 160, 93, 14);
		panel_2.add(lblProductos_1);

		JButton jbtn_agregarProductoACompra = new JButton("");
		jbtn_agregarProductoACompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarProductoACompra();
			}
		});
		jbtn_agregarProductoACompra.setIcon(new ImageIcon(XRAY.class.getResource("/recursos/agregar.png")));
		jbtn_agregarProductoACompra.setBounds(138, 146, 34, 30);
		panel_2.add(jbtn_agregarProductoACompra);

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(10, 118, 93, 14);
		panel_2.add(lblDescuento);

		jtxt_descuentoCompra = new JTextField();
		jtxt_descuentoCompra.setBounds(138, 115, 86, 20);
		panel_2.add(jtxt_descuentoCompra);
		jtxt_descuentoCompra.setColumns(10);

		JLabel jlbl_comprasAgregadas = new JLabel("Compras Agregados");
		jlbl_comprasAgregadas.setBounds(10, 11, 137, 14);
		jpnl_compras.add(jlbl_comprasAgregadas);

		jcbx_comprasAgregadas = new JComboBox<Integer>();
		jcbx_comprasAgregadas.setBounds(157, 8, 121, 20);
		jpnl_compras.add(jcbx_comprasAgregadas);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 36, 268, 2);
		jpnl_compras.add(separator_2);

		JScrollPane jscrl_resultadoCompras = new JScrollPane();
		jscrl_resultadoCompras
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoCompras
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscrl_resultadoCompras.setBounds(288, 46, 348, 212);
		jpnl_compras.add(jscrl_resultadoCompras);

		jtxa_resultadoCompras = new JTextArea();
		jscrl_resultadoCompras.setViewportView(jtxa_resultadoCompras);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Opciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 276, 437, 85);
		jpnl_compras.add(panel_3);
		panel_3.setLayout(null);

		JButton jbtn_ordenarCompras = new JButton("Odenar");
		jbtn_ordenarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (jcb_tipo.getSelectedItem().equals("Inserción directa")) {
					ordenarComprasinserciondirecta();
				}if (jcb_tipo.getSelectedItem().equals("Shell")) {
					ordenarComprasShell();
				} else {

				}
				
			}
		});
		jbtn_ordenarCompras.setBounds(315, 54, 96, 23);
		panel_3.add(jbtn_ordenarCompras);

		JButton jbtn_mostrarCompras = new JButton("Mostrar");
		jbtn_mostrarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirCompras();
			}
		});
		jbtn_mostrarCompras.setBounds(221, 54, 89, 23);
		panel_3.add(jbtn_mostrarCompras);

		JButton jbtn_guardarCompras = new JButton("Guardar");
		jbtn_guardarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCompras();
			}
		});
		jbtn_guardarCompras.setBounds(10, 54, 89, 23);
		panel_3.add(jbtn_guardarCompras);

		JButton jbtn_recuperarCompras = new JButton("Recuperar");
		jbtn_recuperarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperarCompras();
			}
		});
		jbtn_recuperarCompras.setBounds(101, 54, 118, 23);
		panel_3.add(jbtn_recuperarCompras);
		
		JLabel lblTiposDeOrdenamiento = new JLabel("TIPOS DE ORDENAMIENTO:");
		lblTiposDeOrdenamiento.setBounds(10, 22, 183, 14);
		panel_3.add(lblTiposDeOrdenamiento);
		
		jcb_tipo = new JComboBox<String>();
		jcb_tipo.setBounds(219, 19, 153, 20);
		jcb_tipo.addItem("Inserción directa");
		jcb_tipo.addItem("Shell");
		panel_3.add(jcb_tipo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Mezclar Listas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(457, 301, 179, 59);
		jpnl_compras.add(panel_1);

		JButton jbtn_mezclarComprasVentas = new JButton("Mezclar");
		panel_1.add(jbtn_mezclarComprasVentas);
		jbtn_mezclarComprasVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mezclarComprasVentas();
			}
		});

		setVisible(true);
		setLocationRelativeTo(null);

	}

	/**
	 * Metodo para agregar un producto a la lista
	 */
	private void agregarProducto() {

		int codigo = Integer.parseInt(jtxt_codigoProducto.getText());
		String nombre = jtxt_nombreProducto.getText();
		double precio = Double.parseDouble(jtxt_precioUnidad.getText());
		int canti = Integer.parseInt(jtxt_cantidadProducto.getText());

		listaProductos.add(new Producto(codigo, nombre, precio, canti));
		setProductosAgregados();
		JOptionPane.showMessageDialog(null, "Producto ingresado con exito!");

	}

	/**
	 * Ordena los productos por el metodo quicksort
	 */
	private void ordenarProductos() {
		listaProductos = QuickSort.quicksort(listaProductos);
	}

	/**
	 * Imprime los productos en el area de texto
	 */
	private void imprimirProductos() {
		String re = "";
		for (Producto producto : listaProductos) {

			re += "\nCodigo:\t" + producto.codigo;
			re += "\nNombre:\t" + producto.nombre;
			re += "\nPrecio:\t" + producto.precioUnitario;
			re += "\nCantidad:\t" + producto.cantidadTotal;
			re += "\n ***************************";
		}
		jtxa_resultadoProductos.setText(re);
	}

	/**
	 * Setea los productos en el combo box
	 */
	private void setProductosAgregados() {
		jcbx_productos.removeAllItems();
		for (Producto producto : listaProductos)
			jcbx_productos.addItem(producto.codigo);
	}

	/**
	 * Se recuperan los productos
	 */
	private void guardarProductos() {
		RecuperarGuardar.guardar(listaProductos);
	}

	/**
	 * Se recuperan los productos
	 */
	private void recuperarProductos() {
		listaProductos = RecuperarGuardar.recuperarProductos();
		setProductosAgregados();
	}

	/**
	 * Metodo para agregar una venta
	 */
	private void agregarVenta() {

		int factura = Integer.parseInt(jtxt_numeroFacturaVenta.getText());
		String nombreCliente = jtxt_nombreCliente.getText();
		int vendedor = Integer.parseInt(jtxt_codigoVendedor.getText());
		String nombre = jtxt_nombreVenta.getText();

		listaVentas.add(new Ventas(factura, nombreCliente, vendedor, nombre,
				listaProductosAVenta));

		setVentasAgregados();

		ventasOrdenadas = false;

		listaProductosAVenta.clear();

		jtxt_cantidadProductosAVenta.setText("0");

		JOptionPane.showMessageDialog(null, "Venta ingresada con exito!");

	}

	/**
	 * Se setean las ventas agregadas en el combo box
	 */
	private void setVentasAgregados() {
		jcbx_ventasAgregadas.removeAllItems();
		for (Ventas venta : listaVentas)
			jcbx_ventasAgregadas.addItem(venta.numeroFactura);
	}

	/**
	 * Ordena las ventas con el metodo de seleccion
	 */
	private void ordenarVentas() {
		listaVentas = Seleccion.seleccion(listaVentas);
		ventasOrdenadas = true;
		JOptionPane.showMessageDialog(null, "Ventas ordenadas con exito");
	}

	/**
	 * Imprimi las ventas en el area de texto
	 */
	
	private void imprimirVentas() {

		String re = "";
		for (Ventas venta : listaVentas) {

			re += "\nFactura:\t" + venta.numeroFactura;
			re += "\nNombre Cliente:\t" + venta.nombreCliente;
			re += "\nVendedor:\t" + venta.codigoVendedor;
			re += "\nNombre:\t" + venta.nombre;
			re += "\nCantidad Prod:\t" + venta.cantidadProductos;
			re += "\nTotal sin IVA:\t" + venta.totalSinIVA;
			re += "\nTotal con IVA:\t" + venta.totalConIVA;

			re += "\n ** Productos **";
			System.out.println(venta.productos.size());
			for (Producto p : venta.productos) {
				System.out.println("Entramos al for");
				re += "\n   Codigo\t" + p.codigo;
				re += "\n   Nombre\t" + p.nombre;
				re += "\n   Precio\t" + p.precioUnitario;
				re += "\n   Cantidad\t" + p.cantidadTotal + "\n";
			}

			re += "\n ***************************";

		}

		jtxa_resultadoVentas.setText(re);

	}

	/**
	 * Guarda la ventas en un archivo plano
	 */
	private void guardarVentas() {
		RecuperarGuardar.guardar(listaVentas);
	}

	/**
	 * Recupera las ventas en un archivo plano
	 */
	private void recuperarVentas() {
		listaVentas = RecuperarGuardar.recuperarVentas();
		setVentasAgregados();
	}

	/**
	 * Agrega un producto a la venta en proceso
	 */
	private void agregarProductoAVenta() {
		final JComboBox<Integer> pro = new JComboBox<Integer>();
		for (Producto p : listaProductos)
			pro.addItem(p.codigo);

		final JTextField nom = new JTextField();
		nom.setEditable(false);

		pro.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				if (ie.getStateChange() == ItemEvent.SELECTED) {
					int r = (Integer) pro.getSelectedItem();
					String n = "";
					for (Producto d : listaProductos)
						if (d.codigo == r)
							n = d.nombre;
					nom.setText(n);
				}
			}
		});

		final JTextField cant = new JTextField();

		Object[] op = { pro, nom, cant };

		if (JOptionPane.showConfirmDialog(null, op, "Seleccione su producto",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			int codigo = (Integer) pro.getSelectedItem();
			if (!cant.getText().isEmpty()) {
				int cantidad = Integer.parseInt(cant.getText());

				for (int x = 0; x < listaProductos.size(); x++) {
					if (listaProductos.get(x).codigo == codigo) {

						if (listaProductos.get(x).cantidadTotal >= cantidad
								&& cantidad > 0) {

							Producto p = new Producto(
									listaProductos.get(x).codigo,
									listaProductos.get(x).nombre,
									listaProductos.get(x).precioUnitario,
									cantidad);

							listaProductos.get(x).cantidadTotal -= cantidad;
							if (listaProductos.get(x).cantidadTotal == 0)
								listaProductos.remove(x);

							listaProductosAVenta.add(p);

							setProductosAgregados();

						} else {
							JOptionPane.showMessageDialog(null,
									"No hay suficiente en inventario");
							break;
						}

						jtxt_cantidadProductosAVenta.setText(String
								.valueOf(listaProductosAVenta.size()));
					}
				}
			}
		}
	}

	/**
	 * Se agrega una compra
	 */
	private void agregarCompra() {

		int factura = Integer.parseInt(jtxt_numeroFacturaCompra.getText());
		String nombreProveedor = jtxt_nombreProveedor.getText();
		String cedula = jtxt_cedula.getText();
		String nombre = jtxt_nombreCompra.getText();
		double descuento = Double.parseDouble(jtxt_descuentoCompra.getText());

		listaCompras.add(new Compras(factura, nombreProveedor, cedula, nombre,
				descuento, listaProductosACompra));

		listaProductos.addAll(listaProductosACompra);
		listaProductosACompra.clear();

		setCompasAgregadas();
		setProductosAgregados();
		comprasOrdenadas = false;

		JOptionPane.showMessageDialog(null, "Compra ingresada con exito!");

	}

	private void agregarProductoACompra() {

		final JTextField codigo = new JTextField("Codigo");

		final JTextField nom = new JTextField("Nombre");

		final JTextField cant = new JTextField("Cantidad");

		final JTextField precio = new JTextField("Precio");

		Object[] op = { codigo, nom, cant, precio };

		if (JOptionPane.showConfirmDialog(null, op,
				"Llene los datos del producto", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			int cod = Integer.parseInt(codigo.getText());
			String nombre = nom.getText();
			int cantidad = Integer.parseInt(cant.getText());
			double pre = Double.parseDouble(precio.getText());

			Producto p = new Producto(cod, nombre, pre, cantidad);

			listaProductosACompra.add(p);

			setProductosAgregados();

		}

	}

	/**
	 * Se setean las compras agregadas en el combo box
	 */
	private void setCompasAgregadas() {
		jcbx_comprasAgregadas.removeAllItems();
		for (Compras compra : listaCompras)
			jcbx_comprasAgregadas.addItem(compra.numeroFactura);
	}

	/**
	 * Se ordenan las compras por el metodo de insercion directa
	 */
	private void ordenarComprasinserciondirecta() {
		listaCompras = InsercionDirecta.insercionDirecta(listaCompras);
		comprasOrdenadas = true;
		JOptionPane.showMessageDialog(null, "Compras ordenadas con exito");
	}

	private void ordenarComprasShell(){
		listaCompras=Shell.shell(listaCompras);
		comprasOrdenadas = true;
		JOptionPane.showMessageDialog(null, "Compras ordenadas con exito");
		
	}
	/**
	 * Se imprimen las compras en el area de texto
	 */
	private void imprimirCompras() {

		String re = "";
		for (Compras compra : listaCompras) {

			re += "\nFactura:\t" + compra.numeroFactura;
			re += "\nProveedor:\t" + compra.nombreProveedor;
			re += "\nCedula:\t" + compra.cedulaJuridica;
			re += "\nNombre:\t" + compra.nombre;
			re += "\nCantidad Prod:\t" + compra.cantidadProductos;
			re += "\nPrecio total:\t" + compra.precioTotal;
			re += "\n% Descuento:\t" + compra.descuento;
			re += "\nMonto Descuento:\t" + compra.montoDescuento;
			re += "\nTotal con Descuento:\t"
					+ compra.precioTotalConConDescuento;
			re += "\nTotal sin Decuento:\t" + compra.precioTotalSinDescuento;

			re += "\n ***************************";
		}
		jtxa_resultadoCompras.setText(re);

	}

	private void guardarCompras() {
		RecuperarGuardar.guardar(listaCompras);
	}

	private void recuperarCompras() {
		listaCompras = RecuperarGuardar.recuperarCompras();
		setCompasAgregadas();
	}

	/**
	 * Se mezclan la dos listas de compras y ventas, y luego se muestran ya
	 * orenadas en el area de texto
	 */
	private void mezclarComprasVentas() {
		if (comprasOrdenadas && ventasOrdenadas) {
			ArrayList<Object> listaMezclada = Mezcla.ordenar(listaCompras,
					listaVentas);

			String re = "";
			Compras c = null;
			Ventas v = null;
			for (Object o : listaMezclada) {
				if (o instanceof Compras) {
					c = (Compras) o;
					re += "\n* Compra";
					re += "\nFactura:\t" + c.numeroFactura;
					re += "\nProveedor:\t" + c.nombreProveedor;
					re += "\nCedula:\t" + c.cedulaJuridica;
					re += "\nNombre:\t" + c.nombre;
					re += "\n ***************************";

				} else if (o instanceof Ventas) {
					v = (Ventas) o;
					re += "\n* Venta";
					re += "\nFactura:\t" + v.numeroFactura;
					re += "\nNombre Cliente:\t" + v.nombreCliente;
					re += "\nVendedor:\t" + v.codigoVendedor;
					re += "\nNombre:\t" + v.nombre;
					re += "\n ***************************";
				}

			}
			jtxa_resultadoCompras.setText(re);

		} else
			JOptionPane
					.showMessageDialog(null,
							"Las compras o las ventas no estan ordenadas.\nPor favor ordenelas.");
	}

	/**
	 * Metodo Main
	 * 
	 * @param ejercicio2
	 */
	public static void main(String[] ejercicio2) {
		new XRAY();
	}
}
