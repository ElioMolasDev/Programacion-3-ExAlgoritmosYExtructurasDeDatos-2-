package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;



public class VistaPrincipal {

    private JFrame _pantallaInicial;
    private JButton _btnInicio;
    private JLabel _lblTitulo;
    private JLabel lblNewLabel;
 

    public VistaPrincipal() {
        initialize();
    }

    private void initialize() {
        _pantallaInicial = new JFrame();
        _pantallaInicial.setSize(700, 450);
        _pantallaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _pantallaInicial.getContentPane().setLayout(null);

        _lblTitulo = new JLabel("Solucionador de Sudoku");
        _lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        _lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
        _lblTitulo.setBounds(197, 33, 285, 77);
        _pantallaInicial.getContentPane().add(_lblTitulo);

        _btnInicio = new JButton("Iniciar");
        _btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 18));
        _btnInicio.setBounds(278, 330, 145, 50);
        _pantallaInicial.getContentPane().add(_btnInicio);
        
        String explicacionDeUso= ("<html>Este programa resuelve un Sudoku dado. "
        		+ "Dicho Sudoku puede ser generado de manera aleatoria o ingresar valores manuales a las casillas"
        		+ "<ul><li>Generar: Ingrese un valor deseado entre 1 - 40 y genera un sudoku de manera aleatoria</li>"
        		+ "<li>el sudoku generado de manera aleatoria no necesariamente tendra solucion</li>"
        		+ "<li>Resolver: Busca la solucion del Sudoku actual</li>"
        		+ "<li>Limpiar: limpia los valores de las celdas del sudoku</li>"
        		+ "</ul></html>");
        lblNewLabel = new JLabel(explicacionDeUso);
        lblNewLabel.setBounds(106, 96, 470, 181);
        _pantallaInicial.getContentPane().add(lblNewLabel);

        _pantallaInicial.setLocationRelativeTo(null);
        _pantallaInicial.setVisible(true);

    }

    public void agregarListenerIniciar(ActionListener listener) {
	    _btnInicio.addActionListener(listener);
	}
    
    public JFrame getFrame() {
        return _pantallaInicial;
    }

    public void setFrame(JFrame frame) {
        this._pantallaInicial = frame;
    }
}
