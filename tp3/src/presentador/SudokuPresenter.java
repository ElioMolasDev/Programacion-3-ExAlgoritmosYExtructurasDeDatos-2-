   
package presentador;

import javax.swing.*;
import modelo.Admin;
import vista.VistaPrincipal;
import vista.VistaSudoku;
import java.awt.event.ActionEvent;
import java.util.List;

public class SudokuPresenter {
    private final Admin _admin;
    private VistaSudoku _vistaSudoku;
    private VistaPrincipal _vistaPrincipal;
    private boolean[][] _valoresIniciales;
    private int _indiceSolucionActual;
    private int _totalSoluciones;
    private SwingWorker<ResultadoResolucion, Void> _trabajadorActual;

    public SudokuPresenter(Admin admin, VistaPrincipal vista) {
        this._admin = admin;
        this._vistaPrincipal = vista;
        this._vistaPrincipal.agregarListenerIniciar(this::iniciarVistaSudoku);
        this._indiceSolucionActual = 0;
        this._totalSoluciones = 0;
    }





    private void iniciarVistaSudoku(ActionEvent e) {
        _vistaPrincipal.getFrame().dispose();
        _vistaSudoku = new VistaSudoku();
        _vistaSudoku.getFrame().setVisible(true);
        _vistaSudoku.getFrame().setLocationRelativeTo(null);
        
        _vistaSudoku.addActionListeners(
                this::resolverSudoku,
                this::generarTableroAleatorio,
                this::limpiarTablero,
                this::volverVista,
                this::navegarAnterior,
                this::navegarSiguiente
        );
        
        _valoresIniciales = new boolean[9][9];
    }


    private void resolverSudoku(ActionEvent e) {
        try {
            int[][] valores = _vistaSudoku.obtenerValoresTablero();
            _admin.cargarValores(valores);

            if (_admin.hayConflictos()) {
                List<String> conflictos = _admin.detectarConflictos();
                StringBuilder mensaje = new StringBuilder("<html><b>Errores detectados:</b><br><br>");
                int limite = Math.min(conflictos.size(), 8);
                for (int i = 0; i < limite; i++) {
                    mensaje.append("• ").append(conflictos.get(i)).append("<br>");
                }
                
                if (conflictos.size() > 8) {
                    mensaje.append("<br>... y ").append(conflictos.size() - 8)
                          .append(" conflictos más.</html>");
                }
                
                JOptionPane.showMessageDialog(
                    _vistaSudoku.getFrame(),
                    mensaje.toString(),
                    "Valores inválidos",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            guardarValoresIniciales(valores);
            if (!_admin.esValidoValoresIniciales()) {
                _vistaSudoku.mostrarMensaje("Error: El Sudoku inicial no es válido.");
                return;
            }
            deshabilitarBotones();
            _trabajadorActual = new SwingWorker<ResultadoResolucion, Void>() {
                
                @Override
                protected ResultadoResolucion doInBackground() throws Exception {
                    // Este código se ejecuta en un hilo separado
                    int[][] solucion = _admin.resolverSudoku();
                    boolean resuelto = _admin.sudokuSolucionado();
                    int cantidadSoluciones = _admin.getCantidadSoluciones();
                    boolean limiteAlcanzado = _admin.alcanzadoLimiteMaximo();
                    
                    return new ResultadoResolucion(solucion, resuelto, cantidadSoluciones, limiteAlcanzado);
                }
                
                @Override
                protected void done() {
                    try {
                        ResultadoResolucion resultado = get();
                        procesarResultado(resultado);
                    } catch (InterruptedException ex) {
                        _vistaSudoku.mostrarMensaje("Resolucion cancelada");
                    } catch (Exception ex) {
                        _vistaSudoku.mostrarMensaje("Error al resolver el Sudoku ");
                        ex.printStackTrace();
                    } finally {
                        habilitarBotones();
                    }
                }
            };
            
            _vistaSudoku.mostrarMensaje("Buscando soluciones por favor espere...");
            _trabajadorActual.execute();
            
        } catch (IllegalArgumentException ex) {
            _vistaSudoku.mostrarMensaje("Error: " + ex.getMessage());
            habilitarBotones();
        } 
    }


    private void procesarResultado(ResultadoResolucion resultado) {
        if (!resultado.resuelto) {
            _vistaSudoku.mostrarMensaje("No existe solución para este Sudoku ");
            _vistaSudoku.ocultarNavegacion();
        } else {
        	
            _totalSoluciones = resultado.cantidadSoluciones;
            _indiceSolucionActual = 0;
            mostrarSolucionActual();
            
            if (_totalSoluciones == 1) {
                _vistaSudoku.ocultarNavegacion();
            } else {
                _vistaSudoku.mostrarNavegacion(1, _totalSoluciones);
                actualizarBotonesNavegacion();
            }

            if (_totalSoluciones > 1) {
                String mensajeDialogo = resultado.limiteAlcanzado 
                    ? "Se encontraron 1000000 o más soluciones posibles.\n" +
                      "Use los botones de navegación para ver las primeras 1000000 "
                    : "Este Sudoku tiene " + _totalSoluciones + " soluciones posibles.\n" +
                      "Use los botones de navegación para ver cada una.";
                
                JOptionPane.showMessageDialog(
                    _vistaSudoku.getFrame(),
                    mensajeDialogo,
                    "Múltiples soluciones encontradas",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    //estructura para guardar los tableros solucion
    private static class ResultadoResolucion {
        int[][] solucion;
        boolean resuelto;
        int cantidadSoluciones;
        boolean limiteAlcanzado;

        ResultadoResolucion(int[][] solucion, boolean resuelto, int cantidadSoluciones, boolean limiteAlcanzado) {
            this.solucion = solucion;
            this.resuelto = resuelto;
            this.cantidadSoluciones = cantidadSoluciones;
            this.limiteAlcanzado = limiteAlcanzado;
        }
    }
    
    
    private void deshabilitarBotones() {
        _vistaSudoku.habilitarBotonResolver(false);
        _vistaSudoku.habilitarBotonGenerar(false);
        _vistaSudoku.habilitarBotonLimpiar(false);
    }


    private void habilitarBotones() {
        _vistaSudoku.habilitarBotonResolver(true);
        _vistaSudoku.habilitarBotonGenerar(true);
        _vistaSudoku.habilitarBotonLimpiar(true);
    }


    private void navegarAnterior(ActionEvent e) {
        if (_indiceSolucionActual > 0) {
            _indiceSolucionActual--;
            mostrarSolucionActual();
            actualizarBotonesNavegacion();
        }
    }


    private void navegarSiguiente(ActionEvent e) {
        if (_indiceSolucionActual < _totalSoluciones - 1) {
            _indiceSolucionActual++;
            mostrarSolucionActual();
            actualizarBotonesNavegacion();
        }
    }

    private void mostrarSolucionActual() {
        int[][] solucion = _admin.getSolucion(_indiceSolucionActual);
        if (solucion != null) {
            _vistaSudoku.mostrarTablero(solucion, _valoresIniciales);
            _vistaSudoku.mostrarNavegacion(_indiceSolucionActual + 1, _totalSoluciones);
        }
    }


    private void actualizarBotonesNavegacion() {
        _vistaSudoku.habilitarBotonAnterior(_indiceSolucionActual > 0);
        _vistaSudoku.habilitarBotonSiguiente(_indiceSolucionActual < _totalSoluciones - 1);
    }


    private void generarTableroAleatorio(ActionEvent e) {
        try {
            String input = JOptionPane.showInputDialog(
                    _vistaSudoku.getFrame(),
                    "¿Cuántas casillas desea generar aleatoriamente? (1 - 40)\n",
                    "Generar Sudoku",
                    JOptionPane.QUESTION_MESSAGE
            );
            
            // Usuario canceló
            if (input == null) {
                return;
            }
            
            int cantidad = Integer.parseInt(input.trim());
            
            if (!_admin.valorRandomEnRango(cantidad)) {
                JOptionPane.showMessageDialog(
                        _vistaSudoku.getFrame(),
                        "Debe ingresar un número entre 1 y 40",
                        "Valor inválido",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            int[][] tablero = _admin.generarSudokuAleatorio(cantidad);
            _valoresIniciales = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    _valoresIniciales[i][j] = (tablero[i][j] != 0);
                }
            }
            _vistaSudoku.mostrarTablero(tablero, _valoresIniciales);
            _vistaSudoku.ocultarNavegacion();
            _vistaSudoku.mostrarMensaje("Se generaron " + cantidad + " casillas aleatorias.");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    _vistaSudoku.getFrame(),
                    "Debe ingresar un número válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    _vistaSudoku.getFrame(),
                    "Error al generar el sudoku: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        }
    }


    private void limpiarTablero(ActionEvent e) {
        if (_trabajadorActual != null && !_trabajadorActual.isDone()) {
            _trabajadorActual.cancel(true);
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(
                _vistaSudoku.getFrame(),
                "esta seguro de que desea limpiar el tablero?",
                "Confirmar limpieza",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            _admin.limpiarSudoku();
            _vistaSudoku.limpiarTablero();
            _valoresIniciales = new boolean[9][9];
            _indiceSolucionActual = 0;
            _totalSoluciones = 0;
            habilitarBotones();
        }
    }


    private void volverVista(ActionEvent e) {
        if (_trabajadorActual != null && !_trabajadorActual.isDone()) {
            _trabajadorActual.cancel(true);
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(
                _vistaSudoku.getFrame(),
                "Esta seguro de que desea volver? ",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            _vistaSudoku.getFrame().dispose();
            _vistaPrincipal = new VistaPrincipal();
            _vistaPrincipal.agregarListenerIniciar(this::iniciarVistaSudoku);
        }
    }

    private void guardarValoresIniciales(int[][] valores) {
        _valoresIniciales = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                _valoresIniciales[i][j] = (valores[i][j] != 0);
            }
        }
    }
    

}


