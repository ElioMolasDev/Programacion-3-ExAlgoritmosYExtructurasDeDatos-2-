package modelo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class GrafoTest {

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 2, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 5, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarAristaCOnPesoNoAdmitidoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 2, -11);
	}

	@Test
	public void aristaExistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 1);
		assertTrue(grafo.existeArista(2, 3));
	}

	@Test
	public void aristaOpuestaTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 1);
		assertTrue(grafo.existeArista(3, 2));
	}

	@Test
	public void aristaInexistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 1);
		assertFalse(grafo.existeArista(1, 4));
	}

	@Test
	public void agregarAristaDosVecesTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 1);
		grafo.agregarArista(2, 3, 1);

		assertTrue(grafo.existeArista(2, 3));
	}

	@Test
	public void eliminarAristaExistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4, 1);

		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaInexistenteTest() {
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void eliminarAristaDosVecesTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 4, 1);

		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse(grafo.existeArista(2, 4));
	}

	@Test
	public void todosAisladosTest() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}

	@Test
	public void verticeUniversalTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0, 1);
		grafo.agregarArista(1, 2, 1);
		grafo.agregarArista(1, 3, 1);

		int[] esperado = { 0, 2, 3 };
		assertIguales(esperado, grafo.vecinos(1));
	}

	@Test
	public void verticeNormalTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(2, 3, 1);
		grafo.agregarArista(2, 4, 1);

		int[] esperados = { 1, 2 };
		assertIguales(esperados, grafo.vecinos(3));
	}
	
	@Test 
	public void obtenerAristaTest() {
		Grafo g = new Grafo(2);
		g.agregarArista(0,1,5);
		assertEquals(5, g.obtenerArista(0, 1));
	}
	

	public static void assertIguales(int[] esperado, Set<Integer> obtenido) {
		assertEquals(esperado.length, obtenido.size());

		for (int i = 0; i < esperado.length; ++i)
			assertTrue(obtenido.contains(esperado[i]));
	}

}