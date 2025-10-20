package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test(expected = IllegalArgumentException.class)
	public void interesNegativo() {
		Usuario u = new Usuario("a", 1,1,1,-4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nombreVacio() {
		Usuario u = new Usuario("", 1,1,1,-4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nombreNull() {
		Usuario u = new Usuario(null , 1,1,1,-4);
	}
	
	@Test
	public void testCalculoSimilaridadInteresesIguales() {
	Usuario u1 = new Usuario("a", 3, 4, 5, 2);
	Usuario u2 = new Usuario("b", 3, 4, 5, 2);
	assertEquals(0, u1.calcularIndiceDeSimilaridad(u2));
	}


	@Test
	public void testCalculoSimilaridadInteresesDistintos() {
	Usuario u1 = new Usuario("a", 3, 4, 5, 2);
	Usuario u2 = new Usuario("b", 1, 1, 1, 1);
	int esperado = Math.abs(3-1) + Math.abs(4-1) + Math.abs(5-1) + Math.abs(2-1);
	assertEquals(esperado, u1.calcularIndiceDeSimilaridad(u2));
	}


	@Test
	public void testSimilaridadInteresesExtremos() {
	Usuario u1 = new Usuario("a", 1, 1, 1, 1);
	Usuario u2 = new Usuario("b", 5, 5, 5, 5);
	assertEquals(16, u1.calcularIndiceDeSimilaridad(u2));
	}
}
