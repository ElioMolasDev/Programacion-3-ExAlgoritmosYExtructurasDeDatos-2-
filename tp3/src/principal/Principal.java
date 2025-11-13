package principal;

import javax.swing.SwingUtilities;

import modelo.Admin;
import presentador.SudokuPresenter;
import vista.VistaPrincipal;

public class Principal {
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Admin admin = new Admin();
	            VistaPrincipal vista = new VistaPrincipal();
	            new SudokuPresenter(admin, vista);
	        });
	    }
}
