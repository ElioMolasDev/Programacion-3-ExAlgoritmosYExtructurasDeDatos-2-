package modelo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sudoku {
    private static final int TAMANIO = 9;
    private int[][] _tablero;
    
    public Sudoku() {
        _tablero = new int[TAMANIO][TAMANIO];
    }
    

    public boolean tieneSolucionInicial() {
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int col = 0; col < TAMANIO; col++) {
                int num = _tablero[fila][col];
                if (num != 0) {
                    _tablero[fila][col] = 0;
                    if (!numeroValidoParaSolucion(fila, col, num)) {
                        _tablero[fila][col] = num;
                        return false;
                    }
                    _tablero[fila][col] = num;
                }
            }
        }
        return true;
    }

    public boolean numeroValidoParaSolucion(int fila, int col, int num) {
        return !seRepiteNumEnFilaOColumna(fila, col, num) && 
               !seRepiteNumEnSubTablero(fila, col, num);
    }


    private boolean seRepiteNumEnSubTablero(int fila, int col, int num) {
        int filaInicial = fila - fila % 3;
        int columnaInicial = col - col % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (_tablero[filaInicial + i][columnaInicial + j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean seRepiteNumEnFilaOColumna(int fila, int col, int num) {
        for (int i = 0; i < TAMANIO; i++) {
            if (_tablero[fila][i] == num || _tablero[i][col] == num) {
                return true;
            }
        }
        return false;
    }


    public void setCasilla(int fila, int columna, int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("El número debe estar entre 0 y 9");
        }
        if (fila < 0 || fila >= TAMANIO) {
            throw new IllegalArgumentException("Fila debe estar entre 0 y 8");
        }
        if (columna < 0 || columna >= TAMANIO) {
            throw new IllegalArgumentException("Columna debe estar entre 0 y 8");
        }
        _tablero[fila][columna] = num;
    }
    
    public boolean solucionado() {
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int col = 0; col < TAMANIO; col++) {
                if (_tablero[fila][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getCasilla(int fila, int columna) {
        return _tablero[fila][columna];
    }


    public int getTamanio() {
        return TAMANIO;
    }

    public void armarTableroAleatorio(int cantidad) {
        if (cantidad < 1 || cantidad > 40) {
            throw new IllegalArgumentException("La cantidad debe estar entre 1 y 40");
        }

        limpiarTablero();

        Random random = new Random();
        Set<Integer> posiciones = new HashSet<>();
        while (posiciones.size() < cantidad) {
            posiciones.add(random.nextInt(81));
        }
        for (int pos : posiciones) {
            int fila = pos / TAMANIO;
            int col = pos % TAMANIO;
            boolean colocado = false;
            int intentos = 0;

            while (!colocado && intentos < 50) { //no implementamos backtrackin para el generar random si no pudo ingresar un valor en 50 intentos sale
                int num = random.nextInt(9) + 1;
                if (numeroValidoParaSolucion(fila, col, num)) {
                    _tablero[fila][col] = num;
                    colocado = true;
                }
                intentos++;
            }
        }
    }

    private void limpiarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                _tablero[i][j] = 0;
            }
        }
    }

    public int[][] getTablero() {
        int[][] copia = new int[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            System.arraycopy(_tablero[i], 0, copia[i], 0, TAMANIO);
        }
        return copia;
    }
}
