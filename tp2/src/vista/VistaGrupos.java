package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Usuario;

public class VistaGrupos {

	private JFrame _frame;
	private JLabel _lblTitulo;
	private JLabel _lblPromedio1;
	private JLabel _lblPromedio2;
	private JPanel _panelGrupo1;
	private JPanel _panelGrupo2;

	private final String[] COLUMNAS = {"Nombre", "Tango", "Folclore", "Rock", "Urbano"};

	public VistaGrupos() {
		initialize();
	}

	private void initialize() {
		_frame = new JFrame();
		_frame.setTitle("Grupos de Afinidad Musical");
		_frame.setSize(1000, 500); 
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		
		_lblTitulo = new JLabel("Grupos de Usuarios: Intereses Similares");
		_lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 14));
		_lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		_lblTitulo.setBounds(10, 10, 964, 25);
		_frame.getContentPane().add(_lblTitulo);

		_panelGrupo1 = new JPanel(new BorderLayout());
		_panelGrupo1.setBounds(20, 50, 460, 400);
		_frame.getContentPane().add(_panelGrupo1);
		
		_panelGrupo2 = new JPanel(new BorderLayout());
		_panelGrupo2.setBounds(500, 50, 460, 400);
		_frame.getContentPane().add(_panelGrupo2);

		_lblPromedio1 = new JLabel("Promedio similaridad: -");
		_lblPromedio1.setFont(new Font("Open Sans", Font.ITALIC, 11));
		
		_lblPromedio2 = new JLabel("Promedio similaridad: -");
		_lblPromedio2.setFont(new Font("Open Sans", Font.ITALIC, 11));
	}

	public void mostrar() {
		_frame.setVisible(true);
		_frame.setLocationRelativeTo(null);
	}
	
	public void mostrarGrupos(List<Usuario> grupo1, double prom1, List<Usuario> grupo2, double prom2) {	
		mostrarTabla(_panelGrupo1, grupo1, "Grupo 1", _lblPromedio1);
		_lblPromedio1.setText(String.format("Promedio similaridad: %.2f", prom1));
		mostrarTabla(_panelGrupo2, grupo2, "Grupo 2", _lblPromedio2);
		_lblPromedio2.setText(String.format("Promedio Similaridad: %.2f", prom2));
	}
	
	private void mostrarTabla(JPanel panel, List<Usuario> usuarios, String titulo, JLabel lblPromedio) {
		panel.removeAll();
		JLabel lblGrupo = new JLabel(titulo + " (" + usuarios.size() + " Usuarios)", SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Open Sans", Font.BOLD, 12));
		panel.add(lblGrupo, BorderLayout.NORTH);
		DefaultTableModel model = new DefaultTableModel(COLUMNAS, 0);
		for (Usuario u : usuarios) {
			model.addRow(new Object[] {
				u.get_nombre(), 
				u.get_interesTango(), 
				u.get_interesFolclore(), 
				u.get_interesRock(), 
				u.get_interesUrbano()
			});
		}
		
		JTable tabla = new JTable(model);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(lblPromedio, BorderLayout.SOUTH);
		
		panel.revalidate();
		panel.repaint();
	}
}

