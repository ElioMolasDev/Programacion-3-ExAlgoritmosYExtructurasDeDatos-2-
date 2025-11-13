package modelo;

import java.util.ArrayList;
import java.util.List;

public class SolverSudoku {
    private int _tamanio;
    private Sudoku _sudoku;
    private List<int[][]> _soluciones;
    private static final int MAX_SOLUCIONES = 1000000;
    
    public SolverSudoku(Sudoku s) {
        _sudoku = s;
        _tamanio = s.getTamanio();
        _soluciones = new ArrayList<>();
    }
    
    public Sudoku resolver() {
    	if(!_sudoku.tieneSolucionInicial())
    		throw new IllegalArgumentException("No tiene solucion el tablero sudoku");
        _soluciones.clear();
        Sudoku copia = copiarSudoku(_sudoku);
        backtrackTodasSoluciones(copia);
        
        if (!_soluciones.isEmpty()) {
            aplicarSolucion(_sudoku, _soluciones.get(0));
        }
        
        return _sudoku;
    }

    private void backtrackTodasSoluciones(Sudoku sudoku) {
        if (_soluciones.size() >= MAX_SOLUCIONES) {
            return;
        }
        
        int[] pos = buscarVacio(sudoku);
        
        if (pos == null) {
            _soluciones.add(copiarTablero(sudoku.getTablero()));
            return;
        }
        
        int fila = pos[0];
        int columna = pos[1];
        
        for (int numero = 1; numero <= 9; numero++) {
            if (sudoku.numeroValidoParaSolucion(fila, columna, numero)) {
                sudoku.setCasilla(fila, columna, numero);
                backtrackTodasSoluciones(sudoku);
                sudoku.setCasilla(fila, columna, 0);
            }
        }
    }

    private int[] buscarVacio(Sudoku sudoku) {
        for (int i = 0; i < _tamanio; i++) {
            for (int j = 0; j < _tamanio; j++) {
                if (sudoku.getCasilla(i, j) == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private Sudoku copiarSudoku(Sudoku original) {
        Sudoku copia = new Sudoku();
        for (int i = 0; i < _tamanio; i++) {
            for (int j = 0; j < _tamanio; j++) {
                int valor = original.getCasilla(i, j);
                if (valor != 0) {
                    copia.setCasilla(i, j, valor);
                }
            }
        }
        return copia;
    }

    private int[][] copiarTablero(int[][] original) {
        int[][] copia = new int[_tamanio][_tamanio];
        for (int i = 0; i < _tamanio; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, _tamanio);
        }
        return copia;
    }

    private void aplicarSolucion(Sudoku sudoku, int[][] solucion) {
        for (int i = 0; i < _tamanio; i++) {
            for (int j = 0; j < _tamanio; j++) {
                sudoku.setCasilla(i, j, solucion[i][j]);
            }
        }
    }

    public boolean solucionado() {
        return !_soluciones.isEmpty() && _sudoku.solucionado();
    }

    public int getCantidadSoluciones() {
        return _soluciones.size();
    }

    public List<int[][]> getSoluciones() {
        return new ArrayList<>(_soluciones);
    }

    public int[][] getSolucion(int indice) {
        if (indice >= 0 && indice < _soluciones.size()) {
            return copiarTablero(_soluciones.get(indice));
        }
        return null;
    }

    public boolean alcanzadoLimiteMaximo() {
        return _soluciones.size() >= MAX_SOLUCIONES;
    }
}

