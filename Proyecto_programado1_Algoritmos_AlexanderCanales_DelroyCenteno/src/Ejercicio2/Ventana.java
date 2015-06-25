package Ejercicio2;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana extends JFrame implements ActionListener{
	private JTextField jtf_numero;
	private JTextField jtf_serie;
	private JTextField jtf_anio;
	private JComboBox<String> jcb_provincia;
	private JButton jbtn_agregar;
	private JButton jbtn_busca;
	private JButton jbtn_listatodo;
	private JTextField jtf_buscanumero;
	private JTextField jtf_buscaserie;
	private JTextArea jta_muestra;
	
	Info info = new Info();
	public Ventana() {
		setResizable(false);
		setSize(new Dimension(793, 326));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_1.setBounds(10, 25, 276, 261);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAgregando = new JLabel("AGREGANDO...");
		lblAgregando.setBounds(10, 11, 194, 14);
		panel_1.add(lblAgregando);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setBounds(10, 52, 63, 14);
		panel_1.add(lblNumero);
		
		jtf_numero = new JTextField();
		jtf_numero.setBounds(118, 49, 86, 20);
		panel_1.add(jtf_numero);
		jtf_numero.setColumns(10);
		
		JLabel lblSerie = new JLabel("Serie: ");
		lblSerie.setBounds(10, 77, 63, 14);
		panel_1.add(lblSerie);
		
		jtf_serie = new JTextField();
		jtf_serie.setBounds(118, 74, 86, 20);
		panel_1.add(jtf_serie);
		jtf_serie.setColumns(10);
		
		JLabel lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setBounds(10, 173, 106, 14);
		panel_1.add(lblProvincia);
		
		jcb_provincia = new JComboBox<String>();
		jcb_provincia.setBounds(85, 170, 151, 20);
		jcb_provincia.addItem("San Jose");
		jcb_provincia.addItem("Guanacaste");
		jcb_provincia.addItem("Heredia");
		jcb_provincia.addItem("Cartago");
		jcb_provincia.addItem("Limon");
		jcb_provincia.addItem("Puntarenas");
		jcb_provincia.addItem("Alajuela");
		
		panel_1.add(jcb_provincia);
		
		JLabel lblAo = new JLabel("A\u00F1o: ");
		lblAo.setBounds(10, 102, 63, 14);
		panel_1.add(lblAo);
		
		jtf_anio = new JTextField();
		jtf_anio.setBounds(118, 99, 86, 20);
		panel_1.add(jtf_anio);
		jtf_anio.setColumns(10);
		
		jbtn_agregar = new JButton("AGREGAR");
		jbtn_agregar.setBounds(10, 221, 106, 29);
		panel_1.add(jbtn_agregar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_2.setBounds(330, 25, 437, 261);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblBuscando = new JLabel("Buscando:");
		lblBuscando.setBounds(10, 11, 99, 14);
		panel_2.add(lblBuscando);
		
		JLabel lblNumero_1 = new JLabel("Numero: ");
		lblNumero_1.setBounds(10, 36, 90, 14);
		panel_2.add(lblNumero_1);
		
		JLabel lblSerie_1 = new JLabel("Serie: ");
		lblSerie_1.setBounds(10, 61, 99, 14);
		panel_2.add(lblSerie_1);
		
		jbtn_busca = new JButton("BUSCAR");
		jbtn_busca.setBounds(10, 227, 89, 23);
		panel_2.add(jbtn_busca);
		
		jbtn_listatodo = new JButton("LISTAR TODO");
		jbtn_listatodo.setBounds(117, 227, 124, 23);
		panel_2.add(jbtn_listatodo);
		
		jtf_buscanumero = new JTextField();
		jtf_buscanumero.setBounds(95, 33, 86, 20);
		panel_2.add(jtf_buscanumero);
		jtf_buscanumero.setColumns(10);
		
		jtf_buscaserie = new JTextField();
		jtf_buscaserie.setBounds(95, 58, 86, 20);
		panel_2.add(jtf_buscaserie);
		jtf_buscaserie.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 417, 130);
		panel_2.add(scrollPane);
		
		jta_muestra = new JTextArea();
		scrollPane.setViewportView(jta_muestra);
		
		
		jbtn_agregar.addActionListener( this);
		jbtn_busca.addActionListener(this);
		jbtn_listatodo.addActionListener(this);
		
	}

	
	public void AgregarSorteo() {
String provincia="";
		if (!(jtf_numero.getText().isEmpty())&& !(jtf_anio.getText().isEmpty() 
				&& jtf_serie.getText().isEmpty())) {

			int numero = Integer.parseInt(jtf_numero.getText());
			int serie = Integer.parseInt(jtf_serie.getText());
			String anio = jtf_anio.getText();
			if (jtf_numero.getText().length()==2 && jtf_serie.getText().length() ==3) {
				if (jcb_provincia.getSelectedItem().equals("Guanacaste")) {
					provincia="Guanacaste";
					
				}if (jcb_provincia.getSelectedItem().equals("Heredia")) {
					provincia="Heredia";
					
				}if (jcb_provincia.getSelectedItem().equals("San Jose")) {
					provincia="San Jose";
					
				}if (jcb_provincia.getSelectedItem().equals("Cartago")) {
					provincia="Cartago";
					
				}if (jcb_provincia.getSelectedItem().equals("Limon")) {
					provincia="Limon";
					
				}if (jcb_provincia.getSelectedItem().equals("Puntarenas")) {
					provincia="Puntarenas";
					
				}if (jcb_provincia.getSelectedItem().equals("Alajuela")) {
					provincia="Alajuela";
					
				}
				
				
				jta_muestra.setText(info.creaSorteo(numero, serie, anio, provincia, 0));
			}else {
				JOptionPane.showMessageDialog(null, "el numero debe de ser maximo 2 digitos y la serie contener 3 digitos ");
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Debe de llenar todos los espacios", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void listarSorteo() {
		String resul;
		resul = info.listarSorteos();
		jta_muestra.setText(resul);
	}
	
	
	public void buscarSorteo() {
		int numero = Integer.parseInt(jtf_buscanumero.getText());
		int serie = Integer.parseInt(jtf_buscaserie.getText());
		int codigo = numero+serie;
		String ver="Numero" + "\t" + "Serie " + "\t" + "Año" + "\t" + "Provincia"
				+ "\t" + "Posicion" + "\n";
		Sorteo sor = info.verSorteo(codigo);

	if (sor!=null) {
		ver+=sor.numero+"\t"+sor.serie+"\t"+sor.anio+"\t"+sor.provincia+"\t"+sor.posicion;
		
	}
	
	jta_muestra.setText(ver);
	
	}

	
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource()==jbtn_agregar) {
			AgregarSorteo();
		}
		
		if (accion.getSource() == jbtn_listatodo) {
			listarSorteo();
		}
		if (accion.getSource() == jbtn_busca) {
			buscarSorteo();
		}
		
	}
}
