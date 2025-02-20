package ejemploswingjdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import ejemploconsolajdbc.ProductoDao;
import poo.Producto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploSwingJdbc {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTable tProductos;
	private DefaultTableModel modelo;

	private Producto productoSeleccionado = null;

	private ProductoDao dao = new ProductoDao("jdbc:sqlite:bdd/ejemplo.sqlite", "", "");
	private JTextArea taDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploSwingJdbc window = new EjemploSwingJdbc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploSwingJdbc() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(frame, "No se ha podido usar el aspecto del sistema");
		}

		initialize();

		modelo = (DefaultTableModel) tProductos.getModel();

		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");

		actualizarListado();
	}

	private void actualizarListado() {
		modelo.setRowCount(0);

		for (Producto p : dao.buscarTodos()) {
			modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getPrecio() });
		}
	}

	private void limpiarCuadros() {
		tfNombre.setText("");
		tfPrecio.setText("");
		taDescripcion.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pFormulario = new JPanel();
		frame.getContentPane().add(pFormulario, BorderLayout.NORTH);
		GridBagLayout gbl_pFormulario = new GridBagLayout();
		gbl_pFormulario.columnWidths = new int[] { 0, 0, 0 };
		gbl_pFormulario.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pFormulario.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pFormulario.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pFormulario.setLayout(gbl_pFormulario);

		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pFormulario.add(lblNewLabel, gbc_lblNewLabel);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		pFormulario.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Precio");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		pFormulario.add(lblNewLabel_1, gbc_lblNewLabel_1);

		tfPrecio = new JTextField();
		GridBagConstraints gbc_tfPrecio = new GridBagConstraints();
		gbc_tfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecio.gridx = 1;
		gbc_tfPrecio.gridy = 1;
		pFormulario.add(tfPrecio, gbc_tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		pFormulario.add(lblNewLabel_2, gbc_lblNewLabel_2);

		taDescripcion = new JTextArea();
		taDescripcion.setRows(4);
		GridBagConstraints gbc_taDescripcion = new GridBagConstraints();
		gbc_taDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_taDescripcion.fill = GridBagConstraints.BOTH;
		gbc_taDescripcion.gridx = 1;
		gbc_taDescripcion.gridy = 2;
		pFormulario.add(taDescripcion, gbc_taDescripcion);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		pFormulario.add(panel, gbc_panel);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto producto = new Producto(null, tfNombre.getText(), Double.parseDouble(tfPrecio.getText()), taDescripcion.getText());

				if(productoSeleccionado == null) {
					dao.insertar(producto);
				} else {
					producto.setId(productoSeleccionado.getId());
					
					dao.modificar(producto);
				}
				
				productoSeleccionado = null;
				
				limpiarCuadros();
				
				actualizarListado();
			}
		});
		panel.add(btnGuardar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("BORRAR");
				System.out.println(productoSeleccionado);

				if (productoSeleccionado == null) {
					return;
				}

				dao.borrar(productoSeleccionado.getId());

				productoSeleccionado = null;

				limpiarCuadros();

				actualizarListado();
			}

		});
		btnBorrar.setBackground(Color.RED);
		panel.add(btnBorrar);

		tProductos = new JTable();
		tProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tProductos.rowAtPoint(e.getPoint());
				int id = (int) modelo.getValueAt(fila, 0);

				productoSeleccionado = dao.buscarPorId(id);

				System.out.println("CLICK");
				System.out.println(productoSeleccionado);

				tfNombre.setText(productoSeleccionado.getNombre());
				tfPrecio.setText(productoSeleccionado.getPrecio().toString());
				taDescripcion.setText(productoSeleccionado.getDescripcion());
			}
		});

		JScrollPane pListado = new JScrollPane(tProductos);
		frame.getContentPane().add(pListado, BorderLayout.CENTER);

	}

}
