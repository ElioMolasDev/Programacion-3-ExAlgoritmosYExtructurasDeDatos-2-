package modelo;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private Sudoku _sudoku;
    private SolverSudoku _solver;
    
    public Admin() {
        _sudoku = new Sudoku();
    }

    public void cargarValores(int[][] valores) {
        if (valores == null || valores.length != 9 || valores[0].length != 9) {
            throw new IllegalArgumentException("La matriz debe ser de 9x9");
        }
        
        _sudoku = new Sudoku();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int valor = valores[i][j];
                if (valor != 0) {
                    _sudoku.setCasilla(i, j, valor);
                }
            }
        }
    }

    public boolean hayConflictos() {
        return !detectarConflictos().isEmpty();
    }
    
    
    public List<String> detectarConflictos() {
        List<String> conflictos = new ArrayList<>();
        //Porque no se reutiliza o se modifico la clase sudoku para que se encargue de estos conflictos esta explicada en la documentacion
        conflictoEnFila(conflictos);
        conflictoEnColumna(conflictos);
        conflictoEnSUbTablero(conflictos);
        
        return conflictos;
    }
    
	private void conflictoEnSUbTablero(List<String> conflictos) {
		for (int bloqueF = 0; bloqueF < 3; bloqueF++) {
            for (int bloqueC = 0; bloqueC < 3; bloqueC++) {
                int[] conteo = new int[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int fila = bloqueF * 3 + i;
                        int col = bloqueC * 3 + j;
                        int valor = _sudoku.getCasilla(fila, col);
                        if (valor != 0) {
                            conteo[valor]++;
                            if (conteo[valor] > 1) {
                                conflictos.add("Conflicto: El número " + valor + 
                                             " se repite en la subcuadrícula " + 
                                             (bloqueF * 3 + bloqueC + 1));
                            }
                        }
                    }
                }
            }
        }
	}

	private void conflictoEnColumna(List<String> conflictos) {
		for (int col = 0; col < 9; col++) {
            int[] conteo = new int[10];
            for (int fila = 0; fila < 9; fila++) {
                int valor = _sudoku.getCasilla(fila, col);
                if (valor != 0) {
                    conteo[valor]++;
                    if (conteo[valor] > 1) {
                        conflictos.add("Conflicto: El número " + valor + 
                                     " se repite en la columna " + (col + 1));
                    }
                }
            }
        }
	}

	private void conflictoEnFila(List<String> conflictos) {
		for (int fila = 0; fila < 9; fila++) {
            int[] conteo = new int[10]; 
            for (int col = 0; col < 9; col++) {
                int valor = _sudoku.getCasilla(fila, col);
                if (valor != 0) {
                    conteo[valor]++;
                    if (conteo[valor] > 1) {
                        conflictos.add("Conflicto: El número " + valor + 
                                     " se repite en la fila " + (fila + 1));
                    }
                }
            }
        }
	}
    
	
    public int[][] generarSudokuAleatorio(int cantidad) {
        if (!valorRandomEnRango(cantidad)) {
            throw new IllegalArgumentException("La cantidad debe estar entre 1 y 40");
        }
        
        _sudoku = new Sudoku();
        _sudoku.armarTableroAleatorio(cantidad);
        return obtenerTablero();
    }
    
    public boolean esValidoValoresIniciales() {
        return _sudoku.tieneSolucionInicial();
    }
    
    public int[][] resolverSudoku() {
        _solver = new SolverSudoku(_sudoku);
        _sudoku = _solver.resolver();
        return obtenerTablero();
    }
    
    public int[][] obtenerTablero() {
        int[][] tablero = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablero[i][j] = _sudoku.getCasilla(i, j);
            }
        }
        return tablero;
    }
    
    public boolean sudokuSolucionado() {
        return _solver != null && _solver.solucionado();
    }
    
    public int getCantidadSoluciones() {
        return _solver != null ? _solver.getCantidadSoluciones() : 0;
    }
    
    public int[][] getSolucion(int indice) {
        if (_solver != null) {
            return _solver.getSolucion(indice);
        }
        return null;
    }
    
    public boolean alcanzadoLimiteMaximo() {
        return _solver != null && _solver.alcanzadoLimiteMaximo();
    }
    
    public boolean valorRandomEnRango(int cantidad) {
        return cantidad >= 1 && cantidad <= 40;
    }
    
    public void limpiarSudoku() {
        _sudoku = new Sudoku();
        _solver = null;
    }
}
