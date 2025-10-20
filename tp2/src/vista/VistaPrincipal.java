package vista;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal {

	private JFrame _pantallaInicial;
	private JLabel _lblTitulo, _lblNombre, _lblTango, _lblFolclore, _lblRock, _lblUrbano;
	private JTextField _textNombre;
	private JComboBox _boxValorTango, _boxValorFolclore, _boxValorRock, _boxValorUrbano ;
	private JButton _btnGenerarGrupo, _btnIngresarUsuario;
 
	public VistaPrincipal() {
		initialize();
	}

	private void initialize() {
		generarPantallaInicial();
		generarTitulo();
		generarLbls();
		generarTextField();
		generarBoxs();
		
		_btnIngresarUsuario = new JButton("Ingresar Usuario");
		_btnIngresarUsuario.setBounds(196, 304, 152, 27);
		_pantallaInicial.getContentPane().add(_btnIngresarUsuario);
		
		_btnGenerarGrupo = new JButton("Generar grupos ");
		_btnGenerarGrupo.setBounds(196, 343, 152, 27);
		_pantallaInicial.getContentPane().add(_btnGenerarGrupo);
	}

	private void generarTextField() {
		_textNombre = new JTextField();
		_textNombre.setBounds(200, 135, 222, 21);
		_pantallaInicial.getContentPane().add(_textNombre);
		_textNombre.setColumns(10);
	}

	private void generarBoxs() {
		_boxValorTango = new JComboBox();
		_boxValorTango.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		_boxValorTango.setBounds(321, 161, 101, 26);
		_pantallaInicial.getContentPane().add(_boxValorTango);

		_boxValorFolclore = new JComboBox();
		_boxValorFolclore.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		_boxValorFolclore.setBounds(321, 190, 101, 26);
		_pantallaInicial.getContentPane().add(_boxValorFolclore);

		_boxValorRock = new JComboBox();
		_boxValorRock.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		_boxValorRock.setBounds(321, 219, 101, 26);
		_pantallaInicial.getContentPane().add(_boxValorRock);

		_boxValorUrbano = new JComboBox();
		_boxValorUrbano.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		_boxValorUrbano.setBounds(321, 248, 101, 26);
		_pantallaInicial.getContentPane().add(_boxValorUrbano);
	}

	private void generarLbls() {
		_lblNombre = new JLabel("Nombre:");
		_lblNombre.setBounds(81, 137, 58, 17);
		_pantallaInicial.getContentPane().add(_lblNombre);

		_lblTango = new JLabel("Interes en Tango:");
		_lblTango.setBounds(81, 166, 222, 17);
		_pantallaInicial.getContentPane().add(_lblTango);

		_lblFolclore = new JLabel("Interes en Folclore:");
		_lblFolclore.setBounds(81, 195, 222, 17);
		_pantallaInicial.getContentPane().add(_lblFolclore);

		_lblRock = new JLabel("Interes en Rock:");
		_lblRock.setBounds(81, 224, 222, 17);
		_pantallaInicial.getContentPane().add(_lblRock);

		_lblUrbano = new JLabel("Interes en genero Urbano:");
		_lblUrbano.setBounds(81, 253, 222, 17);
		_pantallaInicial.getContentPane().add(_lblUrbano);
	}

	private void generarTitulo() {
		_lblTitulo = new JLabel("Ingresar Usuario");
		_lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 12));
		_lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		_lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		_lblTitulo.setBounds(196, 32, 150, 65);
		_pantallaInicial.getContentPane().add(_lblTitulo);
	}

	private void generarPantallaInicial() {
		_pantallaInicial = new JFrame();
		_pantallaInicial.setSize(550, 450);
		_pantallaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_pantallaInicial.getContentPane().setLayout(null);
	}
	
	public void agregarListenerIngresarUsuario(ActionListener listener) {
	    _btnIngresarUsuario.addActionListener(listener);
	}

	public void agregarListenerGenerarGrupos(ActionListener listener) {
	    _btnGenerarGrupo.addActionListener(listener);
	}
	
	public void limpiarCampos() {
		_textNombre.setText("");
	    _boxValorTango.setSelectedIndex(0);
	    _boxValorFolclore.setSelectedIndex(0);
	    _boxValorRock.setSelectedIndex(0);
	    _boxValorUrbano.setSelectedIndex(0);
	}

	public JFrame getFrame() {
		return _pantallaInicial;
	}

	public String get_textField() {
		return _textNombre.getText();
	}

	public JComboBox get_boxValorTango() {
		return _boxValorTango;
	}

	public JComboBox get_boxValorFolclore() {
		return _boxValorFolclore;
	}

	public JComboBox get_boxValorRock() {
		return _boxValorRock;
	}

	public JComboBox get_boxValorUrbano() {
		return _boxValorUrbano;
	}


}
