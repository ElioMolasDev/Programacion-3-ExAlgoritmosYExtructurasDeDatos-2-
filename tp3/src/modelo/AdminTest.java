package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class AdminTest {

    private Admin admin;

    @Before
    public void setUp() {
        admin = new Admin();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cargarValoresConMatrizNulaTest() {
        admin.cargarValores(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cargarValoresConMatrizNoNuevePorNueveTest() {
        int[][] valores = new int[8][8];
        admin.cargarValores(valores);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cargarValoresConFilasDeDistintaLongitudTest() {
        int[][] valores = new int[9][];
        for (int i = 0; i < 9; i++) {
            valores[i] = new int[i + 1];
        }
        admin.cargarValores(valores);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generarSudokuAleatorioConCantidadCeroTest() {
        admin.generarSudokuAleatorio(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generarSudokuAleatorioConCantidadMayorA81Test() {
        admin.generarSudokuAleatorio(41);
    }
    
    @Test
    public void cargarValoresConMatrizValidaTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 5;
        valores[1][1] = 3;
        
        admin.cargarValores(valores);
        int[][] tablero = admin.obtenerTablero();
        
        assertEquals(5, tablero[0][0]);
        assertEquals(3, tablero[1][1]);
    }

    @Test
    public void detectarConflictosEnFilaTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 1;
        valores[0][1] = 1;
        
        admin.cargarValores(valores);
        List<String> conflictos = admin.detectarConflictos();
        
        assertFalse(conflictos.isEmpty());
        assertTrue(conflictos.get(0).contains("fila"));
    }

    @Test
    public void detectarConflictosEnColumnaTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 2;
        valores[1][0] = 2;
        
        admin.cargarValores(valores);
        List<String> conflictos = admin.detectarConflictos();
        
        assertFalse(conflictos.isEmpty());
        assertTrue(conflictos.get(0).contains("columna"));
    }

    @Test
    public void detectarConflictosEnSubcuadriculaTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 3;
        valores[1][1] = 3;
        
        admin.cargarValores(valores);
        List<String> conflictos = admin.detectarConflictos();
        
        assertFalse(conflictos.isEmpty());
        assertTrue(conflictos.get(0).contains("subcuadrícula") || 
                   conflictos.get(0).contains("subcuadrÃ­cula"));
    }

    @Test
    public void sinConflictosRetornaListaVaciaTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 1;
        valores[0][1] = 2;
        valores[1][0] = 3;
        
        admin.cargarValores(valores);
        List<String> conflictos = admin.detectarConflictos();
        
        assertTrue(conflictos.isEmpty());
    }

    @Test
    public void generarSudokuAleatorioConCantidadValidaTest() {
        int[][] tablero = admin.generarSudokuAleatorio(20);
        
        assertNotNull(tablero);
        assertEquals(9, tablero.length);
        assertEquals(9, tablero[0].length);
    }


    @Test
    public void resolverSudokuRetornaMatrizTest() {
        int[][] valores = new int[9][9];
        admin.cargarValores(valores);
        
        int[][] resultado = admin.resolverSudoku();
        
        assertNotNull(resultado);
        assertEquals(9, resultado.length);
        assertEquals(9, resultado[0].length);
    }

    @Test
    public void sudokuSolucionadoRetornaFalseSinResolverTest() {
        int[][] valores = new int[9][9];
        admin.cargarValores(valores);
        
        assertFalse(admin.sudokuSolucionado());
    }

    @Test
    public void sudokuSolucionadoRetornaTrueDespuesDeResolverTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 1;
        admin.cargarValores(valores);
        
        admin.resolverSudoku();
        
        if (admin.getCantidadSoluciones() > 0) {
            assertTrue(admin.sudokuSolucionado());
        }
    }

    @Test
    public void limpiarSudokuReiniciaTableroTest() {
        int[][] valores = new int[9][9];
        valores[0][0] = 5;
        admin.cargarValores(valores);
        
        admin.limpiarSudoku();
        int[][] tablero = admin.obtenerTablero();
        
        assertEquals(0, tablero[0][0]);
    }

    @Test
    public void limpiarSudokuReiniciaSolucionesTest() {
        int[][] valores = new int[9][9];
        admin.cargarValores(valores);
        admin.resolverSudoku();
        
        admin.limpiarSudoku();
        
        assertEquals(0, admin.getCantidadSoluciones());
        assertFalse(admin.sudokuSolucionado());
    }

}
