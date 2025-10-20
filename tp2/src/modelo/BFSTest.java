package modelo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class BFSTest {

	@Test(expected=IllegalArgumentException.class)
	public void grafoNullTest() 
	{
		BFS.esConexo(null);
	}

	@Test
	public void grafoVacioTest() 
	{
		assertTrue(BFS.esConexo(new Grafo(0)));
	}
	
	@Test
	public void grafoUnVerticeTest() 
	{
		assertTrue(BFS.esConexo(new Grafo(1)));
	}
	
	@Test
	public void grafoDosVerticesAisladosTest() 
	{
		assertFalse(BFS.esConexo(new Grafo(2)));
	}
	
	@Test
	public void grafoDosVerticesConexoTest() 
	{
		Grafo g = new Grafo(2);
		g.agregarArista(0, 1,2);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void grafoInconexoTest() 
	{
		Grafo g = inicializarGrafoInconexo();	
		assertFalse(BFS.esConexo(g));
	}
	
	@Test
	public void grafoCompletoTest() 
	{
		Grafo g = inicializarGrafoCompleto();
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesGrafoCompletoTest() 
	{
		Grafo g = inicializarGrafoCompleto();
		
		int[] esperado = {0, 1, 2, 3};
		assertIguales(esperado, BFS.alcanzables(g, 0));
	}

	
	@Test
	public void alcanzablesInconexoTest() 
	{
		Grafo g = inicializarGrafoInconexo();
		
		int[] esperado = {0, 1, 2, 3, 4};
		assertIguales(esperado, BFS.alcanzables(g, 0));
	}
	
	private Grafo inicializarGrafoInconexo() 
	{
		Grafo g = new Grafo(7);
		g.agregarArista(0, 1,2);
		g.agregarArista(0, 2,2);
		g.agregarArista(1, 2,3);
		g.agregarArista(1, 3,2);
		g.agregarArista(2, 4,2);
		g.agregarArista(3, 4,2);
		g.agregarArista(5, 6,2);
		
		return g;		
	}
	
	private Grafo inicializarGrafoCompleto() 
	{
		Grafo g = new Grafo(4);
		g.agregarArista(0, 1,2);
		g.agregarArista(1, 2,2);
		g.agregarArista(2, 3,2);
		g.agregarArista(0, 3,2);
		g.agregarArista(0, 2,2);
		g.agregarArista(1, 3,2);
		
		return g;		
	}
	
	public static void assertIguales(int[] esperado, Set<Integer> obtenido) {
		assertEquals(esperado.length, obtenido.size());

		for (int i = 0; i < esperado.length; ++i)
			assertTrue(obtenido.contains(esperado[i]));
	}

}
