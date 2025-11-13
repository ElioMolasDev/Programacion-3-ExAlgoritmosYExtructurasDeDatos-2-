package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class SolverSudokuTest {

    private Sudoku sudoku;
    private SolverSudoku solver;

    @Before
    public void setUp() {
        sudoku = new Sudoku();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void resolverSudokuSinSolucionTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(0, 1, 1);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
    }

    @Test
    public void resolverSudokuVacioEncuentraSolucionTest() {
        solver = new SolverSudoku(sudoku);
        Sudoku resuelto = solver.resolver();
        assertTrue(resuelto.solucionado());
    }

    @Test
    public void resolverSudokuConSolucionUnicaTest() {
        int[][] tableroInicial = tableroConSolucionUnica();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tableroInicial[i][j] != 0) {
                    sudoku.setCasilla(i, j, tableroInicial[i][j]);
                }
            }
        }
        
        solver = new SolverSudoku(sudoku);
        Sudoku resuelto = solver.resolver();
        
        assertTrue(solver.solucionado());
        assertEquals(1, solver.getCantidadSoluciones());
    }

    @Test
    public void resolverSudokuConMultiplesSolucionesTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(1, 1, 2);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        if (solver.solucionado()) {
            assertTrue(solver.getCantidadSoluciones() >= 1);
        }
    }

    @Test
    public void solucionSinAlcanzarElMaximoTest() {
        int[][] tableroInicial = tableroConSolucionUnica();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tableroInicial[i][j] != 0) {
                    sudoku.setCasilla(i, j, tableroInicial[i][j]);
                }
            }
        }
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        assertFalse(solver.alcanzadoLimiteMaximo());
    }

    @Test
    public void resolverSinEjecutarTest() {
        solver = new SolverSudoku(sudoku);
        assertFalse(solver.solucionado());
    }


    @Test
    public void todasLasSolucionesSonCompletasTest() {
        sudoku.setCasilla(0, 0, 5);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        if (solver.solucionado()) {
            List<int[][]> soluciones = solver.getSoluciones();
            for (int[][] solucion : soluciones) {
                boolean completa = true;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (solucion[i][j] == 0) {
                            completa = false;
                            break;
                        }
                    }
                }
                assertTrue(completa);
            }
        }
    }
    
    
    private int[][] tableroConSolucionUnica(){
    	 int[][] tablero = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    	};
        return tablero;
    }
}







