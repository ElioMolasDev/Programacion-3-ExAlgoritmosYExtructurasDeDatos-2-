package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import modelo.Usuario;
import modelo.AdministradorDeUsuarios;
import vista.VistaGrupos;
import vista.VistaPrincipal;

public class Presentador implements ActionListener {
	private VistaPrincipal _vistaPrincipal;
	private AdministradorDeUsuarios adminUsuarios;
	
	public Presentador(VistaPrincipal vistaPrincipal, AdministradorDeUsuarios adminUsuarios) {
		this._vistaPrincipal = vistaPrincipal;
		this.adminUsuarios = adminUsuarios;
		this._vistaPrincipal.agregarListenerIngresarUsuario(this);
		this._vistaPrincipal.agregarListenerGenerarGrupos(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if ("Ingresar Usuario".equals(comando)) {
			ingresarUsuario();
		} else if ("Generar grupos ".equals(comando)) {
			mostrarVistaDeGrupos();
		}
	}

	private void ingresarUsuario() {
		try {
			String nombre = _vistaPrincipal.get_textField().trim();
			int tango = Integer.parseInt((String) _vistaPrincipal.get_boxValorTango().getSelectedItem());
			int folclore = Integer.parseInt((String) _vistaPrincipal.get_boxValorFolclore().getSelectedItem());
			int rock = Integer.parseInt((String) _vistaPrincipal.get_boxValorRock().getSelectedItem());
			int urbano = Integer.parseInt((String) _vistaPrincipal.get_boxValorUrbano().getSelectedItem());
			
			Usuario nuevoUsuario = new Usuario(nombre, tango, folclore, rock, urbano);
			adminUsuarios.agregarUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(_vistaPrincipal.getFrame(),
				"Usuario '" + nombre + "' ingresado. Total de usuarios: " + adminUsuarios.getCantidadUsuarios(), "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
			_vistaPrincipal.limpiarCampos();
			
		}catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(_vistaPrincipal.getFrame(), 
					"Error al ingresar usuario: " + e.getMessage(), 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}	
	}

	private void mostrarVistaDeGrupos() {
		VistaGrupos vistaGruposActual = new VistaGrupos();
		List<Set<Integer>> gruposIndices = adminUsuarios.generarGrupos();	
		Set<Integer> indicesDeUsuarioGrupo1 = gruposIndices.get(0);
		Set<Integer> indicesDeUsuarioGrupo2 = gruposIndices.get(1);	
		List<Usuario> grupo1 = adminUsuarios.obtenerUsuariosPorIndices(indicesDeUsuarioGrupo1);
        List<Usuario> grupo2 = adminUsuarios.obtenerUsuariosPorIndices(indicesDeUsuarioGrupo2);
		double prom1 = adminUsuarios.calcularPromedioSimilaridad(indicesDeUsuarioGrupo1);
		double prom2 = adminUsuarios.calcularPromedioSimilaridad(indicesDeUsuarioGrupo2);
		vistaGruposActual.mostrarGrupos(grupo1, prom1, grupo2, prom2);
		vistaGruposActual.mostrar();

	}

	public void iniciar() {
		_vistaPrincipal.getFrame().setVisible(true);
		_vistaPrincipal.getFrame().setLocationRelativeTo(null);
	}

}
