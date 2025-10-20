package principal;

import presentacion.Presentador;
import modelo.AdministradorDeUsuarios;
import vista.VistaPrincipal;

public class AfinidadMusical {
	public static void main(String[] args) {
		VistaPrincipal vista = new VistaPrincipal();
		AdministradorDeUsuarios modelo = new AdministradorDeUsuarios();
		Presentador presentador = new Presentador(vista, modelo);		
		presentador.iniciar(); 
	}
}