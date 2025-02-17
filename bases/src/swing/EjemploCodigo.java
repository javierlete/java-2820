package swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EjemploCodigo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame ventana = new JFrame();
		
		JLabel etiqueta = new JLabel("Dime tu nombre"); 
		JTextField texto = new JTextField(10);
		JButton boton = new JButton("Saludar");
		JLabel resultado = new JLabel("                      ");
		
		boton.addActionListener(e -> resultado.setText("Hola " + texto.getText()));
		
		Container contenedor = ventana.getContentPane();
		
		contenedor.setLayout(new FlowLayout());
		
		contenedor.add(etiqueta);
		contenedor.add(texto);
		contenedor.add(boton);
		contenedor.add(resultado);
		
		ventana.pack();
		
		ventana.setVisible(true);
	}
}
