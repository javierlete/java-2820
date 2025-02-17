package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import poo.Local;
import poo.Persona;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EjemploWindowBuilder {

	private JFrame ventana;
	private JTextField texto;
	private JTable tabla;
	private JLabel resultado;
	private DefaultTableModel dtm;
	private JTextField tfNombre;
	private JTextField tfEdad;
	private JTextField tfGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploWindowBuilder window = new EjemploWindowBuilder();
					window.ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public EjemploWindowBuilder() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		Local l = new Local("Bilbao", new Persona(), 10);

		l.entrar(new Persona());
		l.entrar(new Persona("Pedro", 20));
		l.entrar(new Persona("Juan", "Masculino", 40));
		l.entrar(new Persona("María", "Femenino", 50));
		l.entrar(new Persona("Silvestre", 50));

		initialize();

		dtm = (DefaultTableModel) tabla.getModel();

		dtm.addColumn("Nombre");
		dtm.addColumn("Género");
		dtm.addColumn("Edad");

		for (Persona p : l.getPersonas()) {
			dtm.addRow(new Object[] { p.getNombre(), p.getGenero(), p.getEdad() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 632, 270);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pSuperior = new JPanel();
		pSuperior.setBounds(0, 0, 100, 100);
		ventana.getContentPane().add(pSuperior, BorderLayout.NORTH);
		pSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel etiqueta = new JLabel("Nombre");
		pSuperior.add(etiqueta);

		texto = new JTextField();
		texto.setColumns(10);
		pSuperior.add(texto);

		JButton boton = new JButton("Saludar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado.setText("Hola " + texto.getText());
			}
		});
		pSuperior.add(boton);

		resultado = new JLabel("Aquí se verá el resultado");
		pSuperior.add(resultado);

		JPanel pCentral = new JPanel();
		ventana.getContentPane().add(pCentral);
		pCentral.setLayout(new BorderLayout(0, 0));

		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.rowAtPoint(e.getPoint());

				texto.setText(dtm.getValueAt(fila, 0).toString());
				
				tfNombre.setText(dtm.getValueAt(fila, 0).toString());
				tfGenero.setText(dtm.getValueAt(fila, 1) != null ? dtm.getValueAt(fila,  1).toString() : "");
				tfEdad.setText(dtm.getValueAt(fila, 2).toString());
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabla);
		pCentral.add(scrollPane);
		
		JPanel pSur = new JPanel();
		ventana.getContentPane().add(pSur, BorderLayout.SOUTH);
		GridBagLayout gbl_pSur = new GridBagLayout();
		gbl_pSur.columnWidths = new int[]{0, 0};
		gbl_pSur.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pSur.columnWeights = new double[]{0.0, 1.0};
		gbl_pSur.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pSur.setLayout(gbl_pSur);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		pSur.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		pSur.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Género");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		pSur.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfGenero = new JTextField();
		GridBagConstraints gbc_tfGenero = new GridBagConstraints();
		gbc_tfGenero.insets = new Insets(0, 0, 5, 0);
		gbc_tfGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfGenero.gridx = 1;
		gbc_tfGenero.gridy = 1;
		pSur.add(tfGenero, gbc_tfGenero);
		tfGenero.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edad");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		pSur.add(lblNewLabel, gbc_lblNewLabel);
		
		tfEdad = new JTextField();
		GridBagConstraints gbc_tfEdad = new GridBagConstraints();
		gbc_tfEdad.insets = new Insets(0, 0, 5, 0);
		gbc_tfEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEdad.gridx = 1;
		gbc_tfEdad.gridy = 2;
		pSur.add(tfEdad, gbc_tfEdad);
		tfEdad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		pSur.add(btnGuardar, gbc_btnGuardar);
	}
}
