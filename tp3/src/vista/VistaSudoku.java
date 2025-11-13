package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;

public class VistaSudoku {

    private JFrame _frame;
    private static final int TAMANIO = 9;
    private JTextField[][] _tablero = new JTextField[TAMANIO][TAMANIO];
    private final JButton _btnResolver = new JButton("Resolver");
    private final JButton _btnGenerar = new JButton("Generar tablero");
    private final JButton _btnVolver = new JButton("Volver");
    private final JButton _btnLimpiar = new JButton("Limpiar");
    private final JButton _btnAnterior = new JButton("← Anterior");
    private final JButton _btnSiguiente = new JButton("Siguiente →");
    private final JLabel _lblInfo = new JLabel("Ingrese los valores", SwingConstants.CENTER);
    private final JLabel _lblNavegacion = new JLabel("", SwingConstants.CENTER);
    private JPanel _panelNavegacion;
    private JPanel buttonPanel_1;

    public VistaSudoku() {
        initialize();
    }

    private void initialize() {
        _frame = new JFrame();
        _frame.setTitle("Sudoku - Solver con Backtracking");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.getContentPane().setLayout(new BorderLayout());

        JPanel gridPanel = crearPanelTablero();
        JPanel buttonPanel = crearPanelBotones();
        _panelNavegacion = crearPanelNavegacion();

        _frame.getContentPane().add(_lblInfo, BorderLayout.NORTH);
        _frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
        _frame.getContentPane().add(_panelNavegacion, BorderLayout.EAST);
        _frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        _panelNavegacion.setVisible(false);
        
        _frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
    }

    private JPanel crearPanelTablero() {
        JPanel gridPanel = new JPanel(new GridLayout(TAMANIO, TAMANIO));
        Font font = new Font("SansSerif", Font.BOLD, 20);

        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                JTextField celda = new JTextField();
                celda.setHorizontalAlignment(JTextField.CENTER);
                celda.setFont(font);
                celda.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) || c == '0' || celda.getText().length() >= 1) {
                            e.consume();
                        }
                    }
                });

                int top = (i % 3 == 0) ? 2 : 1;
                int left = (j % 3 == 0) ? 2 : 1;
                int bottom = ((i + 1) % 3 == 0) ? 2 : 1;
                int right = ((j + 1) % 3 == 0) ? 2 : 1;
                celda.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

                _tablero[i][j] = celda;
                gridPanel.add(celda);
            }
        }
        return gridPanel;
    }

    private JPanel crearPanelBotones() {
        buttonPanel_1 = new JPanel();
        buttonPanel_1.add(_btnResolver);
        buttonPanel_1.add(_btnGenerar);
        buttonPanel_1.add(_btnLimpiar);
        buttonPanel_1.add(_btnVolver);
        return buttonPanel_1;
    }

    private JPanel crearPanelNavegacion() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.setLayout(new BorderLayout());
        
        JPanel botonesPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel_1.add(_btnAnterior);
        _btnAnterior.setFont(new Font("SansSerif", Font.BOLD, 14));
        buttonPanel_1.add(_btnSiguiente);
        _btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        _lblNavegacion.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        panel.add(_lblNavegacion, BorderLayout.NORTH);
        panel.add(botonesPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        return panel;
    }

    public void addActionListeners(ActionListener resolver, ActionListener generar, 
                                   ActionListener limpiar, ActionListener volver,
                                   ActionListener anterior, ActionListener siguiente) {
        _btnResolver.addActionListener(resolver);
        _btnGenerar.addActionListener(generar);
        _btnLimpiar.addActionListener(limpiar);
        _btnVolver.addActionListener(volver);
        _btnAnterior.addActionListener(anterior);
        _btnSiguiente.addActionListener(siguiente);
    }

    public int[][] obtenerValoresTablero() {
        int[][] valores = new int[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                String texto = _tablero[i][j].getText().trim();
                if (texto.isEmpty()) {
                    valores[i][j] = 0;
                } else {
                    try {
                        valores[i][j] = Integer.parseInt(texto);
                    } catch (NumberFormatException e) {
                        valores[i][j] = 0;
                    }
                }
            }
        }
        return valores;
    }

    public void mostrarTablero(int[][] valores, boolean[][] valoresIniciales) {
        if (valores == null || valores.length != TAMANIO) {
            return;
        }

        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (valores[i][j] == 0) {
                    _tablero[i][j].setText("");
                } else {
                    _tablero[i][j].setText(String.valueOf(valores[i][j]));
                }
                if (valoresIniciales != null && valoresIniciales[i][j]) {
                    _tablero[i][j].setEditable(false);
                    _tablero[i][j].setBackground(new Color(220, 220, 220));
                    _tablero[i][j].setForeground(Color.BLACK);
                } else {
                    _tablero[i][j].setEditable(true);
                    _tablero[i][j].setBackground(Color.WHITE);
                    _tablero[i][j].setForeground(new Color(0, 100, 200));
                }
            }
        }
    }

    public void limpiarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                _tablero[i][j].setText("");
                _tablero[i][j].setEditable(true);
                _tablero[i][j].setBackground(Color.WHITE);
                _tablero[i][j].setForeground(Color.BLACK);
            }
        }
        ocultarNavegacion();
        mostrarMensaje("Tablero limpiado. Ingrese nuevos valores.");
    }

    public void mostrarNavegacion(int actual, int total) {
        _lblNavegacion.setText("<html><center>Solución " + actual + " de " + total + 
                             "<br>(Navegue entre soluciones)</center></html>");
        _panelNavegacion.setVisible(true);
        _frame.pack();
    }
    
    public void ocultarNavegacion() {
        _panelNavegacion.setVisible(false);
        _frame.pack();
    }

    public void habilitarBotonResolver(boolean habilitar) {
        _btnResolver.setEnabled(habilitar);
    }

    public void habilitarBotonGenerar(boolean habilitar) {
        _btnGenerar.setEnabled(habilitar);
    }

    public void habilitarBotonLimpiar(boolean habilitar) {
        _btnLimpiar.setEnabled(habilitar);
    }

    public void habilitarBotonAnterior(boolean habilitar) {
        _btnAnterior.setEnabled(habilitar);
    }

    public void habilitarBotonSiguiente(boolean habilitar) {
        _btnSiguiente.setEnabled(habilitar);
    }

    public void mostrarMensaje(String mensaje) {
        _lblInfo.setText(mensaje);
    }

    public JFrame getFrame() {
        return _frame;
    }
}