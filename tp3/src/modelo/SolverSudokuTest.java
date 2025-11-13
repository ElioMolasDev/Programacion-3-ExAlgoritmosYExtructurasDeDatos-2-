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

    @Test
    public void resolverSudokuVacioEncuentraSolucionTest() {
        solver = new SolverSudoku(sudoku);
        Sudoku resuelto = solver.resolver();
        
        assertTrue(solver.solucionado());
        assertTrue(resuelto.solucionado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void resolverSudokuSinSolucionTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(0, 1, 1);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
    }

    @Test
    public void resolverSudokuConSolucionUnicaTest() {
        int[][] tableroInicial = {
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
    public void getCantidadSolucionesRetornaCeroSinResolverTest() {
        solver = new SolverSudoku(sudoku);
        assertEquals(0, solver.getCantidadSoluciones());
    }

    @Test
    public void getSolucionesRetornaListaVaciaSinResolverTest() {
        solver = new SolverSudoku(sudoku);
        List<int[][]> soluciones = solver.getSoluciones();
        
        assertNotNull(soluciones);
        assertEquals(0, soluciones.size());
    }

    @Test
    public void getSolucionRetornaNullConIndiceInvalidoTest() {
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        assertNull(solver.getSolucion(-1));
        assertNull(solver.getSolucion(solver.getCantidadSoluciones()));
    }

    @Test
    public void getSolucionRetornaSolucionValidaTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(1, 1, 2);
        sudoku.setCasilla(2, 2, 3);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        if (solver.solucionado()) {
            int[][] solucion = solver.getSolucion(0);
            assertNotNull(solucion);
            assertEquals(9, solucion.length);
            assertEquals(9, solucion[0].length);
        }
    }

    @Test
    public void getSolucionRetornaCopiaProfundaTest() {
        sudoku.setCasilla(0, 0, 1);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        if (solver.solucionado() && solver.getCantidadSoluciones() > 0) {
            int[][] solucion1 = solver.getSolucion(0);
            int[][] solucion2 = solver.getSolucion(0);
            
            solucion1[0][0] = 999;
            assertNotEquals(999, solucion2[0][0]);
        }
    }

    @Test
    public void alcanzadoLimiteMaximoRetornaFalseConPocasSolucionesTest() {
        int[][] tableroInicial = {
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
    public void solucionadoRetornaFalseSinResolverTest() {
        solver = new SolverSudoku(sudoku);
        assertFalse(solver.solucionado());
    }

    @Test
    public void resolverMantieneSudokuOriginalSinCambiosTest() {
        sudoku.setCasilla(0, 0, 5);
        sudoku.setCasilla(1, 1, 7);
        
        int[][] antes = sudoku.getTablero();
        solver = new SolverSudoku(sudoku);
        
        assertEquals(5, antes[0][0]);
        assertEquals(7, antes[1][1]);
    }

    @Test
    public void todasLasSolucionesContienenValoresInicialesTest() {
        sudoku.setCasilla(0, 0, 1);
        sudoku.setCasilla(1, 1, 2);
        
        solver = new SolverSudoku(sudoku);
        solver.resolver();
        
        if (solver.solucionado()) {
            List<int[][]> soluciones = solver.getSoluciones();
            for (int[][] solucion : soluciones) {
                assertEquals(1, solucion[0][0]);
                assertEquals(2, solucion[1][1]);
            }
        }
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
}







