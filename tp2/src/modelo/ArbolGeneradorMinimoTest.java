package modelo;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class ArbolGeneradorMinimoTest {

	@Test(expected = IllegalArgumentException.class)
	public void grafoNullTest() {
		ArbolGeneradorMinimo.kruskal(null);
	}

	@Test
	public void grafoVacioTest() {
		Grafo g = new Grafo(0);
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
		assertTrue(agm.isEmpty());
	}

	@Test
	public void grafoUnVerticeTest() {
		Grafo g = new Grafo(1);
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
		assertTrue(agm.isEmpty());
	}

	@Test
	public void grafoDosVerticesSinAristaTest() {
		Grafo g = new Grafo(2);
		assertTrue(ArbolGeneradorMinimo.kruskal(g).isEmpty());
	}

	@Test
	public void grafoDosVerticesConAristaTest() {
		Grafo g = new Grafo(2);
		g.agregarArista(0, 1, 5);
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
		assertEquals(1, agm.size());
	}

	@Test
	public void grafoInconexoTest() {
		Grafo g = inicializarGrafoInconexo();
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
		assertTrue(agm.size() < g.tamanio() - 1);
	}

	@Test
	public void grafoCompletoTest() {
		Grafo g = inicializarGrafoCompleto();
		List<int[]> agm = ArbolGeneradorMinimo.kruskal(g);
		assertEquals(g.tamanio() - 1, agm.size());
	}

	private Grafo inicializarGrafoInconexo() {
		Grafo g = new Grafo(6);
		g.agregarArista(0, 1, 3);
		g.agregarArista(1, 2, 2);
		g.agregarArista(3, 4, 4);
		g.agregarArista(4, 5, 1);
		return g;
	}

	private Grafo inicializarGrafoCompleto() {
		Grafo g = new Grafo(5);
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				g.agregarArista(i, j, i + j + 1);
			}
		}
		return g;
	}

}
