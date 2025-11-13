package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

	
    private Sudoku sudoku;

    @Before
    public void setUp() {
        sudoku = new Sudoku();
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroMayorANueveTest() {
        sudoku.setCasilla(0, 0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroNegativoTest() {
        sudoku.setCasilla(0, 0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroAFilaFueraDeRangoSuperiorTest() {
        sudoku.setCasilla(9, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroAFilaFueraDeRangoInferiorTest() {
        sudoku.setCasilla(-1, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroAColumnaFueraDeRangoSuperiorTest() {
        sudoku.setCasilla(0, 9, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarNumeroAColumnaFueraDeRangoInferiorTest() {
        sudoku.setCasilla(0, -1, 1);
    }

    @Test
    public void agregarCeroEsValidoTest() {
        sudoku.setCasilla(0, 0, 0);
        assertEquals(0, sudoku.getCasilla(0, 0));
    }

    @Test
    public void agregarUnNumeroValidoTest() {
        sudoku.setCasilla(0, 0, 4);
        assertEquals(4, sudoku.getCasilla(0, 0));
    }

    @Test
    public void sudokuVacioTieneSolucionTest() {
        assertTrue(sudoku.tieneSolucionInicial());
    }

    @Test
    public void sudokuConNumerosRepetidosEnFilaNoTieneSolucionTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(0, 1, 1);
        assertFalse(sudoku.tieneSolucionInicial());
    }

    @Test
    public void sudokuConNumerosRepetidosEnColumnaNoTieneSolucionTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(1, 0, 1);
        assertFalse(sudoku.tieneSolucionInicial());
    }

    @Test
    public void sudokuConNumerosRepetidosEnSubtableroNoTieneSolucionTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(1, 1, 1);
        assertFalse(sudoku.tieneSolucionInicial());
    }

    @Test
    public void numeroValidoEnPosicionVaciaTest() {
        assertTrue(sudoku.numeroValidoParaSolucion(0, 0, 5));
    }

    @Test
    public void numeroInvalidoPorFilaTest() {
        sudoku.setCasilla(0, 5, 3);
        assertFalse(sudoku.numeroValidoParaSolucion(0, 0, 3));
    }

    @Test
    public void numeroInvalidoPorColumnaTest() {
        sudoku.setCasilla(5, 0, 7);
        assertFalse(sudoku.numeroValidoParaSolucion(0, 0, 7));
    }

    @Test
    public void numeroInvalidoPorSubtableroTest() {
        sudoku.setCasilla(1, 1, 9);
        assertFalse(sudoku.numeroValidoParaSolucion(0, 0, 9));
    }

    @Test
    public void sudokuVacioNoEstaSolucionadoTest() {
        assertFalse(sudoku.solucionado());
    }

    @Test
    public void sudokuCompletoEstaSolucionadoTest() {
        int[][] tableroCompleto = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku.setCasilla(i, j, tableroCompleto[i][j]);
            }
        }
        
        assertTrue(sudoku.solucionado());
    }

    @Test
    public void getTamanioRetornaNueveTest() {
        assertEquals(9, sudoku.getTamanio());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void armarTableroAleatorioConCantidadCeroTest() {
        sudoku.armarTableroAleatorio(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void armarTableroAleatorioConCantidadMayorA40Test() {
        sudoku.armarTableroAleatorio(82);
    }

    @Test
    public void armarTableroAleatorioTest() {
        sudoku.armarTableroAleatorio(20);
        int contador = 0;    
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getCasilla(i, j) != 0) {
                    contador++;
                }
            }
        }
        
        assertTrue(contador <= 20);
    }

    @Test
    public void creacionDeCopiaTest() {
        sudoku.setCasilla(0, 0, 5);
        int[][] copia = sudoku.getTablero();
        copia[0][0] = 9;     
        assertEquals(5, sudoku.getCasilla(0, 0));
    }

    @Test
    public void tableroAleatorioRespetaReglasSudokuTest() {
        sudoku.armarTableroAleatorio(30);
        assertTrue(sudoku.tieneSolucionInicial());
    }
}






